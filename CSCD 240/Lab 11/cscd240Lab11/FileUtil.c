#include "FileUtil.h"

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

FILE * openFile() {

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

FILE * openOutputFile(char filename[]) {

    FILE * outf = NULL;

    outf = fopen(filename, "w");

    if (outf == NULL) {

        printf("File cannot be overwritten");
        exit(0);
    }

    else {

        return outf;
    }
}

FILE * promptOpenOutputFile() {

    char filename[100];

    FILE *outf = NULL;

    printf("What is the name of the file you would like to write to?\n");

    scanf("%s", filename);

    outf = openOutputFile(filename);

    return outf;
}
