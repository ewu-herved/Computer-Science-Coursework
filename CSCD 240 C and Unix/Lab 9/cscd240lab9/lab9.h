#ifndef LAB9_H_INCLUDED
#define LAB9_H_INCLUDED

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "FileUtil.h"

typedef struct {

    char street[100];
    char city[100];
    char state[3];
    int zip;
}Address;

int fillArray(Address *array, FILE *fin);

int menu();

void printStreetSortedArray(Address *array, int total);

void printCitySortedArray(Address *array, int total);

void printStateCitySortedArray(int total, Address *array);

void printZipSortedArray(int total, Address *array);

void sort(Address *array, int total);

void sort2(Address *array, int total);

void sort3(Address *array, int total);

void sort4(Address *array, int total);

void strip(char str[]);

#endif // LAB9_H_INCLUDED
