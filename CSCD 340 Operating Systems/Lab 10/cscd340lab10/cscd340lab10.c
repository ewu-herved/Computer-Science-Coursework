#include "lab10.h"

int translatedAddress = 0;
int pageFaults = 0;
int pageEvictions = 0;
int frameCounter = 0;
int rewriteCounter = 0;

int main()
{

    int virtualAddressSpace;
    int pageSize;
    int physicalAddressSpace;
    PTE ** virtualMemory;
    FILE * fin;

    openSetup(&virtualAddressSpace, &pageSize, &physicalAddressSpace);

    virtualMemory = buildVirtualMemory(virtualAddressSpace, pageSize, physicalAddressSpace);

    fin = openFile();

    printPhysicalAddress(virtualMemory, fin, pageSize, physicalAddressSpace);

    int count = 0;

    for(count = 0; count < virtualAddressSpace / pageSize; count++) {

        free(virtualMemory[count]);
    }

    free(virtualMemory);
    free(fin);
    return 0;
}

void openSetup(int * virtualAddressSpace, int * pageSize, int * physicalAddressSpace) {

    FILE * fin = NULL;

    fin = fopen("setup.txt", "r");

    if (fin == NULL) {

        printf("File could not be opened.\n");
        exit(-1);
    }

    fscanf(fin, "%d", virtualAddressSpace);
    fscanf(fin, "%d", pageSize);
    fscanf(fin, "%d", physicalAddressSpace);

    fclose(fin);
}

PTE ** buildVirtualMemory(int virtualAddressSpace, int pageSize, int physicalAddressSpace) {

    PTE ** pageTable;
    int pageNum = virtualAddressSpace / pageSize;

    pageTable = (PTE **)calloc(pageNum, sizeof(PTE *));

    int i = 0;

    for(i = 0; i < pageNum; i++) {

        PTE * temp = (PTE*)calloc(1, sizeof(PTE));

        temp->frame = -1;
        temp->reference = 0;

        pageTable[i] = temp;
    }

    return pageTable;
}

FILE * openFile() {

    char filename[100];

    FILE *inf = NULL;

    do {

        printf("Please enter the name of an input file: ");

        scanf("%s", filename);

        do {

            inf = fopen(filename, "r");

            if (inf == NULL) {

                printf("File not found. Please enter another filename:\n");
                scanf("%s", filename);
            }
        } while(inf == NULL);

        printf("\n\n");

        if (inf == NULL) {

            printf("File not found.");
        }
    } while (inf == NULL);

    return inf;
}

void printPhysicalAddress(PTE ** pageTable, FILE * fin, int pageSize, int physicalAddressSpace) {

    int translatedAddress = 0;
    int pageFaults = 0;
    int pageEvictions = 0;

    while (feof(fin) == 0) {

        int virtualAddress;
        int pageNum;
        char * hitOrMiss;
        int physicalAddress;

        fscanf(fin, "%d", &virtualAddress);

        pageNum = getPage(virtualAddress, pageSize);

        if(pageTable[pageNum]->reference == 0) {

            pageFaults++;
            hitOrMiss = "miss";
            if(frameCounter < (physicalAddressSpace / pageSize)) {
                pageTable[pageNum]->frame = frameCounter;
                frameCounter++;
            }
            else {
                pageEvictions++;
                pageTable[pageNum]->frame = rewriteCounter;
                pageTable[pageNum]->reference = 1;
                rewriteCounter++;
                if(rewriteCounter == (physicalAddressSpace / pageSize) - 1)
                    rewriteCounter = 0;
            }
        }

        else{

           hitOrMiss = "hit";
        }

        pageTable[pageNum]->reference++;

        physicalAddress = getPhysicalAddress(virtualAddress, pageSize) + (pageNum * pageTable[pageNum]->frame);

        printf("Virtual Address: %d\nPage Number: %d\n%s\nPage Frame Number: %d\nPhysical Address: %d\n=========================\n", virtualAddress, pageNum, hitOrMiss, pageTable[pageNum]->frame, physicalAddress);

        translatedAddress++;
    }

    printf("\nNumber of translated addresses = %d\nPage Faults = %d\nPage Fault Rate = %.5lf\nPage Evictions = %d\nPage Eviction Rate = %.5lf\n", translatedAddress, pageFaults, (double)pageFaults / (double) translatedAddress, pageEvictions, (double) pageEvictions / (double) translatedAddress);
}

void convertToBinary(int that, char ** num) { //converts longs to an array representation of a binary

    double decimal = that;

    int count = 0;
    int binaryLength;

    int power;

    int remainder = (int) decimal;

    while (decimal >= 1.0) {

        decimal /= 2;
        count++;
    }

    int * binaryFormat;

    if (count == 0) {

        binaryFormat =(int*)calloc(1, sizeof(int));
        binaryFormat[0] = 0;
        binaryLength = 1;
    }
    else {
        binaryFormat = (int*)calloc(count, sizeof(int));
        binaryLength = count;
    }

    for (count = 0; count < binaryLength; count++) {

        power = (int) pow(2, binaryLength - count -1);

        if (remainder > 0 && power <= remainder) {

            binaryFormat[count] = (int) (remainder / power);

            remainder -= (power * binaryFormat[count]);

            //printf("%d\n", binaryFormat[count]);
        }

        else {

            binaryFormat[count] = 0;
            //printf("%d\n", binaryFormat[count]);
        }
    }

    char * binaryStr = (char*)calloc(binaryLength + 1, sizeof(char));

    char buffer[100];

    for(count = 0; count < binaryLength; count++) {

        sprintf(buffer, "%d", binaryFormat[count]);
        strcat(binaryStr, buffer);
    }
    strcat(binaryStr, "\0");

    free(binaryFormat);

    *num = binaryStr;
}

int binaryToDecimal(char * binaryStr) { //converts array representation of a binary to a long

    int binaryLength = 0;

    int count = 0;

    while(binaryStr[count] != '\0') {

        binaryLength++;
        count++;
    }

    int binary[binaryLength];

    char buffer[10];

    for(count = 0; count < binaryLength; count++) {

        sprintf(buffer, "%c", binaryStr[count]);
        binary[count] = strtol(buffer, NULL, 10);
    }

    int decimal = 0;

    for (count = 0; count < binaryLength; count++) {

        if (binary[count] != 0) {

            decimal += binary[count] * pow(2, binaryLength - count -1);
        }
    }

    return decimal;
}

int getPage(int logical, int pageSize) {

    char * binaryVAS = NULL;

    convertToBinary(logical, &binaryVAS);

    char * binaryPageSize = NULL;

    convertToBinary(pageSize, &binaryPageSize);

    int offset = strlen(binaryPageSize) - 1;

    char binaryPage[strlen(binaryVAS) - offset];

    sprintf(binaryPage, "%.*s", (int)(strlen(binaryVAS) - offset), binaryVAS);

    strcat(binaryPage, "\0");

    int page = binaryToDecimal(binaryPage);

    free(binaryVAS);
    free(binaryPageSize);

    return page;
}

int getPhysicalAddress(int logical, int pageSize) {

    char * binaryVAS = NULL;

    convertToBinary(logical, &binaryVAS);

    char * binaryPageSize = NULL;

    convertToBinary(pageSize, &binaryPageSize);

    int offset = strlen(binaryPageSize);

    char physicalAddress[offset];

    sprintf(physicalAddress, "%.*s", (int)(strlen(binaryVAS) - offset), binaryVAS + offset);

    int address = binaryToDecimal(physicalAddress);

    free(binaryVAS);
    free(binaryPageSize);

    return address;
}
