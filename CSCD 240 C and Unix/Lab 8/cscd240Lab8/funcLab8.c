#include <math.h>
#include "lab8.h"

int * fillArray(FILE *fin, int total) {

    int x = 0;
    int * array = (int *)calloc(total, sizeof(int));

    for (x = 0; x < total; x++) {

        fscanf(fin, "%d", &array[x]);
    }

    return array;
}
double findMean(int *numbers, int total) {

    int x = 0;
    double sum = 0;

    for (x = 0; x < total; x++) {

        sum += numbers[x];
    }

    return sum / total;
}
double findMedian(int total, int *numbers) {

    double median = 0;

    quickSort(numbers, 0, total - 1);

    if(total % 2 == 1) {

        median = numbers[total / 2];
    }
    else {

        median = (double)(numbers[total / 2] + numbers[total / 2 - 1]) / 2;
    }

    return median;
}
double findStdDev(int *numbers, int total) {

    double mean = 0;
    int deviations[total];
    int x = 0;
    double sum = 0;

    mean = findMean(numbers, total);

    for(x = 0; x < total; x++) {

        deviations[x] = numbers[x] - mean;
    }

    for(x = 0; x < total; x++) {

        sum += deviations[x] * deviations[x];
    }

    sum = sum / (total - 1);

    return sqrt(sum);
}
void displayResults(FILE *file, double mean, double median, double stdDev) {

    fprintf(file, "The mean, median, and standard deviation are: %.2lf %.2lf %.2lf\n\n", mean, median, stdDev);
}
void cleanUp(int *array) {

    free(array);
}
int readTotal(FILE *fin) {

    int total = 0;

    fscanf(fin, "%d", &total);

    return total;
}

int partition(int * array, int left, int right) {

    int i = 0;
    int temp = 0;
    int pivot = array[right];
    int index = left;

    for (i = left; i <= right - 1; i++) {

        if(array[i] <= pivot) {

            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            index++;
        }
    }
    temp = array[index];
    array[index] = array[right];
    array[right] = temp;

    return index;
}

int * quickSort(int * array, int left, int right) {

    int pivot_index = 0;

    if(left >= right) {

        return;
    }

    pivot_index = partition(array, left, right);
    quickSort(array, left, pivot_index - 1);
    quickSort(array, pivot_index + 1, right);
}
