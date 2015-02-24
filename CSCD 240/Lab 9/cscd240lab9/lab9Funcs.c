#include "lab9.h"

int fillArray(Address *array, FILE *fin){

    int x = 0;
    char buffer[100];

    fgets(buffer, 100, fin);
    strip(buffer);
    strcpy(array[x].street, buffer);

    while(!feof(fin)) {

        fgets(buffer, 100, fin);
        strip(buffer);
        strcpy(array[x].city, buffer);
        fscanf(fin, "%s", array[x].state);
        fscanf(fin, "%d", &array[x].zip);
        fgets(buffer, 100, fin);
        x++;
        fgets(buffer, 100, fin);
        strip(buffer);
        strcpy(array[x].street, buffer);
    }

    return x;
}

int menu(){

    int choice = 0;

    do {

        printf("1) Print the array sorted by street\n2) Print the array sorted by city\n3) Print the array sorted by state then city\n4) Print the array sorted by zip\n5) Quit\nChoice--> ");

        scanf("%d", &choice);
    }while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);

    printf("\n");

    return choice;
}

void printStreetSortedArray(Address *array, int total){

    int x = 0;

    sort(array, total);

    for(x = 0; x < total; x++){

        printf("Address %d:\n\n%s\n%s, %s %d\n\n", x + 1, array[x].street, array[x].city, array[x].state, array[x].zip);
    }
}

void printCitySortedArray(Address *array, int total){

    int x = 0;

    sort2(array, total);

    for(x = 0; x < total; x++){

        printf("Address %d:\n\n%s\n%s, %s %d\n\n", x + 1, array[x].street, array[x].city, array[x].state, array[x].zip);
    }
}

void printStateCitySortedArray(int total, Address *array){

    int x = 0;

    sort3(array, total);

    for(x = 0; x < total; x++){

        printf("Address %d:\n\n%s\n%s, %s %d\n\n", x + 1, array[x].street, array[x].city, array[x].state, array[x].zip);
    }
}

void printZipSortedArray(int total, Address *array){

    int x = 0;

    sort4(array, total);

    for(x = 0; x < total; x++){

        printf("Address %d:\n\n%s\n%s, %s %d\n\n", x + 1, array[x].street, array[x].city, array[x].state, array[x].zip);
    }
}

void sort(Address *array, int total) {

    int x = 0;
    int y = 0;
    Address * smallest = NULL;
    Address temp;

    for (x = 0; x < total; x++) {

        smallest = &array[x];
        for(y = x + 1; y < total; y++) {

            if(strcmp((*smallest).street, (array)[y].street) > 0) {

                temp = *smallest;
                array[x] = array[y];
                array[y] = temp;
            }
        }
    }
}

void sort2(Address *array, int total) {

    int x = 0;
    int y = 0;
    Address * smallest = NULL;
    Address temp;

    for (x = 0; x < total; x++) {

        smallest = &array[x];
        for(y = x + 1; y < total; y++) {

            if(strcmp((*smallest).city, (array)[y].city) > 0) {

                temp = *smallest;
                array[x] = array[y];
                array[y] = temp;
            }
        }
    }
}

void sort3(Address *array, int total) {

    int x = 0;
    int y = 0;
    Address * smallest = NULL;
    Address temp;

    for (x = 0; x < total; x++) {

        smallest = &array[x];
        for(y = x + 1; y < total; y++) {

            if(strcmp((*smallest).state, (array)[y].state) == 0) {

                if(strcmp((*smallest).city, (array)[y].city) > 0) {

                    temp = *smallest;
                    array[x] = array[y];
                    array[y] = temp;
                }
            }

            else if(strcmp((*smallest).state, (array)[y].state) > 0) {

                temp = *smallest;
                array[x] = array[y];
                array[y] = temp;
            }
        }
    }
}

void sort4(Address *array, int total) {

    int x = 0;
    int y = 0;
    Address * smallest = NULL;
    Address temp;

    for (x = 0; x < total; x++) {

        smallest = &array[x];
        for(y = x + 1; y < total; y++) {

            if((*smallest).zip > array[y].zip) {

                temp = *smallest;
                array[x] = array[y];
                array[y] = temp;
            }
        }
    }
}

void strip(char str[]) {

    int x = 0;

    while(str[x] != '\r' && str[x] != '\n' && str[x] != '\0') {

        x++;
    }
    str[x] = '\0';
}
