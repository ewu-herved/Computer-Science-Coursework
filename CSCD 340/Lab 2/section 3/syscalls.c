#include <stdlib.h>
#include <stdio.h>

int main() {

    char buffer[100];
    FILE * fin = fopen("test.txt", "r");

    while(!feof(fin)) {

        fgets(buffer, 100, fin);
        printf("%s", buffer);
    }

    fclose(fin);

    return 0;
}
