#include "lab10.h"

int compareToInts(const void * a, const void * b) {

    return (*(int*)a - *(int*)b);
}

int compareToChars(const void *char1, const void *char2) {

    return (*(char*)char1 - *(char*)char2);
}

void printIntArray(int *intArray) {

    int x = 0;

    printf("[");

    for(x = 0; x < INTS; x++) {

        if(x == INTS - 1)

            printf("%d]", intArray[x]);

        else
            printf("%d, ", intArray[x]);
    }
}

void printCharArray(char *charArray){

    int x = 0;

    printf("[");

    for(x = 0; x < CHARS; x++) {

        if(x == CHARS - 1)

            printf("%c]", charArray[x]);

        else
            printf("%c, ", charArray[x]);
    }
}
