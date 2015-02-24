#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main() {

    char buffer[100];
    FILE * fin = NULL;
    int fout = -1;

do {

    printf("Please enter the name of an input file: ");

    scanf("%s", buffer);

    do {

        fin = fopen(buffer, "r");

        if(fin == NULL) {

            printf("File not found. Please enter another filename:\n");
            scanf("%s", buffer);
        }
    } while(fin == NULL);

    printf("\n\n");

    if (fin == NULL) {

        printf("File not found.");
    }
} while(fin == NULL);

fout = open("myBinary.bin", O_CREAT|O_WRONLY, 0777);

if (fout == -1) {

    printf("Error: myBinary.bin cannot be created.");
    exit(0);
}

while(!feof(fin)) {

    fscanf(fin, "%s", buffer);

    write(fout, buffer, sizeof(char));
}

    return 0;
    fclose(fin);
    close(fout);
}
