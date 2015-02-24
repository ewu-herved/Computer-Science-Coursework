#include "FileUtil.h"

FILE * openInputFile2(char filename[]) {

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

FILE * openInputFile() {

    char filename[100];

    FILE *inf = NULL;

    do {

        printf("What is the name of the file you would like to access?\n");

        scanf("%s", filename);

        inf = openInputFile2(filename);

        if (inf == NULL) {

            printf("File not found.");
        }
    } while (inf == NULL);

    return inf;
}

FILE * openOutputFile2(char filename[]) {

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

FILE * openOutputFile() {

    char filename[100];

    FILE *outf = NULL;

    printf("What is the name of the file you would like to write to?\n");

    scanf("%s", filename);

    outf = openOutputFile2(filename);

    return outf;
}
