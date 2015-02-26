#include "utility.h"

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

int menu(){

    int choice = 0;

    do {

        printf("1) Print the List\n2) Add First\n3) Add Last\n4) Sort the List(ascending order)\n5) Delete a Word\n6) Quit -\n\nChoice--> ");

        scanf("%d", &choice);

        printf("\n");

    } while(choice < 1 || choice > 6);

    return choice;
}

void strip(char * array){

    int x = 0;

    while(array[x] != '\r' && array[x] != '\n' && array[x] != '\0') {

        x++;
    }
    array[x] = '\0';
}

int countRecords(FILE * fin, int lines){

    int count = 0;
    char buffer[100];

    while (!feof(fin)) {

        fgets(buffer, 100, fin);
        count++;
    }

    count /= lines;

    rewind(fin);

    return count;
}

void buildList(LinkedList * myList, FILE * fin, int total) {

    int x = 0;
    char buffer[100];
    Node * nn;
    char * temp;

    myList->size = 0;

    if (total == 0);

    else {

    for(x = 0; x < total; x++){

        nn = (Node*)calloc(1, sizeof(Node));

        fscanf(fin, "%s", buffer);

        strip(buffer);

        temp = (char*)calloc(strlen(buffer) + 1, sizeof(char));

        strcpy(temp, buffer);

        nn->data = temp;

        addLast(myList, nn);
    }
    }
}
