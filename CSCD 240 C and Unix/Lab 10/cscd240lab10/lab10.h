#ifndef LAB10_H_INCLUDED
#define LAB10_H_INCLUDED

#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define INTS 30
#define CHARS 20

int compareToInts(const void *int1, const void *int2);

int compareToChars(const void *char1, const void *char2);

void printIntArray(int *intArray);

void printCharArray(char *charArray);

#endif // LAB10_H_INCLUDED
