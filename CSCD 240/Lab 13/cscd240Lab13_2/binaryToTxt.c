#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#define MAX_CHARS 100

void convertToText(int fin);
void convert(int fin);
void strip(char str[]);

int main() {

    int fin = 0;

    fin = open("myBinary.bin", O_RDONLY);

    convertToText(fin);
    lseek(fin, 0, SEEK_SET);
    printf("\n\n");
    convert(fin);

    close(fin);

    return 0;
}

void convertToText(int fin) {

    char buffer[MAX_CHARS];
    int length = 0;
    int line = 0;

    while (!eof(fin)) {

        read(fin, &length, sizeof(int));
        read(fin, buffer, length * sizeof(char));
        buffer[length] = '\n';
        strip(buffer);
        if(line > 50) {
            line = 0;
            printf("\n");
        }
        printf("%s ", buffer);
        line += length;
    }
}

void convert(int fin) {

    char buffer[MAX_CHARS];
    int length = 0;
    int line = 0;

    while (!eof(fin)) {

        read(fin, &length, sizeof(int));
        read(fin, buffer, length * sizeof(char));
        buffer[length] = '\n';
        strip(buffer);
        write(1, buffer, length * sizeof(char));
        line += length;
    }
}

void strip(char str[]) {

    int x = 0;

    while(str[x] != '\r' && str[x] != '\n' && str[x] != '\0') {

        x++;
    }
    str[x] = '\0';
}

