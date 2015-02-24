#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

void convertToText(int fin);

void convert(int fin);

void strip(char * array);

int main() {

    int fin = -1;

    fin = open("myBinary.bin", O_RDONLY);

    if (fin == -1) {

        printf("File could not be opened.");
    }

    convertToText(fin);

    lseek(fin, 0, SEEK_SET);

    convert(fin);

    close(fin);

    return 0;
}

void convertToText(int fin) {

    char buffer[100];
    int eof;

    do {

        eof = read(fin, buffer, sizeof(char));

        strip(buffer);

        if (eof != 0) {

            fprintf(stdout,"%s\n", buffer);
        }

    } while (eof != 0);
}

void convert(int fin) {

    char buffer[100];
    int eof;

    do {

        eof = read(fin, buffer, sizeof(char));

        printf("\n");

        if (eof != 0) {

            write(1, buffer, sizeof(char));
        }
    } while(eof != 0);
}

void strip(char * array){

    int x = 0;

    while(array[x] != '\r' && array[x] != '\n' && array[x] != '\0') {

        x++;
    }
    array[x] = '\0';
}
