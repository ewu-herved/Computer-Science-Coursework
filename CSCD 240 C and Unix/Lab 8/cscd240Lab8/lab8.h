#ifndef LAB8_H_INCLUDED
#define LAB8_H_INCLUDED

#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "FileUtil.h"

int * fillArray(FILE *fin, int total);
double findMean(int *numbers, int total);
double findMedian(int total, int *numbers);
double findStdDev(int *numbers, int total);
void displayResults(FILE *file, double mean, double median, double stdDev);
void cleanUp(int *array);
int readTotal(FILE *fin);
int partition(int * array, int left, int right);
int * quickSort(int *array, int left, int right);

#endif // LAB8_H_INCLUDED
