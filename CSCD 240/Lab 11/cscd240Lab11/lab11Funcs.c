#include "lab11.h"

Address * fillArray(int *total, FILE *fin){

    int x = 0;
    Address *array = NULL;
    char buffer[100];
    *total = 0;
    int boolean = 0;

    fgets(buffer, 100, fin);
    (*total)++;

    while(!feof(fin)) {

        fgets(buffer, 100, fin);
        (*total)++;
        boolean = 1;
    }

    rewind(fin);

    *total /= 4;

    array = (Address*)calloc(*total, sizeof(Address));

    while(x < *total && boolean == 1) {

        fgets(buffer, 100, fin);
        strip(buffer);
        array[x].street = (char*)calloc(strlen(buffer) + 1, sizeof(char));
        strcpy(array[x].street, buffer);
        fgets(buffer, 100, fin);
        strip(buffer);
        array[x].city = (char*)calloc(strlen(buffer) + 1, sizeof(char));
        strcpy(array[x].city, buffer);
        fgets(buffer, 100, fin);
        strip(buffer);
        array[x].state = (char*)calloc(strlen(buffer) + 1, sizeof(char));
        strcpy(array[x].state, buffer);
        fscanf(fin, "%d", &array[x].zip);
        fgets(buffer, 100, fin);
        x++;
    }

    return array;
}

int menu(){

    int choice = 0;

    do {

        printf("1) Print the array sorted by street\n2) Print the array sorted by city then by zip\n3) Print the array sorted by state then city then by zip\n4) Print the array sorted by zip\n5) Quit\nChoice--> ");

        scanf("%d", &choice);
    }while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);

    printf("\n");

    return choice;
}

void printArray(Address *array, int total){

    int x = 0;

    for(x = 0; x < total; x++){

        printf("Address %d:\n\n%s\n%s, %s %d\n\n", x + 1, array[x].street, array[x].city, array[x].state, array[x].zip);
    }
}

int compareStreet(const void *parm1, const void *parm2) {

    Address a1 = *(Address*)parm1;
    Address a2 = *(Address*)parm2;

    return strcmp(a1.street, a2.street);
}

int compareCityZip(const void *parm1, const void *parm2) {

    Address a1 = *(Address*)parm1;
    Address a2 = *(Address*)parm2;

    if (strcmp(a1.city, a2.city) == 0) {

        return a1.zip - a2.zip;
    }

    return strcmp(a1.city, a2.city);
}

int compareStateCityZip(const void *parm1, const void *parm2) {

    Address a1 = *(Address*)parm1;
    Address a2 = *(Address*)parm2;

    if (strcmp(a1.state, a2.state) == 0 && strcmp(a1.city, a2.city) == 0) {

        return a1.zip - a2.zip;
    }

    else if (strcmp(a1.state, a2.state) == 0) {

        return a2.city - a1.city;
    }

    return strcmp(a1.state, a2.state);
}

int compareZip(const void *parm1, const void *parm2) {

    Address a1 = *(Address*)parm1;
    Address a2 = *(Address*)parm2;

    return a1.zip - a2.zip;
}

void cleanUp(Address *array, int total){

    int x = 0;

    for (x = 0; x < total; x++){

        free(array[x].street);
        free(array[x].city);
        free(array[x].state);
    }

    free(array);
}

void strip(char str[]) {

    int x = 0;

    while(str[x] != '\r' && str[x] != '\n' && str[x] != '\0') {

        x++;
    }
    str[x] = '\0';
}
