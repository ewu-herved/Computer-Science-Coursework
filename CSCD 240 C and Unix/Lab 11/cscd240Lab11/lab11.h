#ifndef LAB11_H_INCLUDED
#define LAB11_H_INCLUDED

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "FileUtil.h"

typedef struct {

    char *street;
    char *city;
    char *state;
    int zip;
}Address;

Address * fillArray(int *total, FILE *fin);

int menu();

void printArray(Address *array, int total);

int compareStreet(const void *parm1, const void *parm2);

int compareCityZip(const void *parm1, const void *parm2);

int compareStateCityZip(const void *parm1, const void *parm2);

int compareZip(const void *parm1, const void *parm2);

void cleanUp(Address *array, int total);

void strip(char str[]);

#endif // LAB11_H_INCLUDED
