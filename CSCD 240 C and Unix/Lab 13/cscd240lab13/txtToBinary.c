#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>

#define MAX_CHARS 100

FILE * openInputFile(char filename[]);
FILE * promptOpenInputFile();

int main() {

    FILE *fin = NULL;
    int fout = 0;
    char buffer[MAX_CHARS];
    int length = 0;

    fin = promptOpenInputFile();
    fout = open("myBinary.bin", O_CREAT|O_WRONLY, 0777);

    while (!feof(fin)) {

        fscanf(fin, "%s", buffer);
        length = strlen(buffer);
        write(fout, &length, sizeof(int));
        write(fout, buffer, length*sizeof(char));
    }

    fclose(fin);
    close(fout);

    return 0;
}

FILE * openInputFile(char filename[]) {

    FILE * inf = NULL;

    do {

        inf = fopen(filename, "r");

        if (inf == NULL) {

            printf("File not found. Please enter another filename:\n");
            scanf("%s", filename);
        }
    } while(inf == NULL);

    return inf;
}

FILE * promptOpenInputFile() {

    char filename[100];

    FILE *inf = NULL;

    do {

        printf("Please enter the name of an input file: ");

        scanf("%s", filename);

        inf = openInputFile(filename);

        printf("\n\n");

        if (inf == NULL) {

            printf("File not found.");
        }
    } while (inf == NULL);

    return inf;
}


