//Dan Herve
//creates a char array and an int array. It reads from input to the Char array and
//then converts numbers into doubles which the program then uses to calculate
//overall grade
//Shortcomings: while redirection works for windows cmd, unix gets a Segmentation fault

#include "gradeCalculator.h"

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void readFile() {

    char buffer[BUFFERSIZE] = {0};

    char *pEnd = "initial";

    double numbers[40];

    int i = 0;

    double mean = 0;

    double totMean = 0;

    int count = 0;

    fgets(buffer, BUFFERSIZE, stdin);

    printf("Student name: %s\n\n", buffer);

    printf("Assignment Scores: ");

    fgets(buffer, BUFFERSIZE, stdin);

    numbers[0] = strtod(buffer, &pEnd);

    printf("%.0lf ", numbers[0]);

    mean = numbers[0];

    count++;

    for(i = 1; strcmp(pEnd, "\n"); i++) {

        numbers[i] = strtod(pEnd, &pEnd);

        mean += numbers[i];

        count++;

        printf("%.0lf ", numbers[i]);
    }

    totMean += mean / i * .25;

    printf("\nAssignments Average - %.1lf%%", mean / i);

    printf("\n\nLab Scores: ");

    fgets(buffer, BUFFERSIZE, stdin);

    numbers[0] = strtod(buffer, &pEnd);

    printf("%.0lf ", numbers[0]);

    mean = numbers[0];

    count++;

    for(i = 1; strcmp(pEnd, "\n"); i++) {

        numbers[i] = strtod(pEnd, &pEnd);

        mean += numbers[i];

        count++;

        printf("%.0lf ", numbers[i]);
    }

    totMean += mean / i * .2;

    printf("\nLab Average - %.1lf%%", mean / i);

    printf("\n\nQuiz Scores: ");

    fgets(buffer, BUFFERSIZE, stdin);

    numbers[0] = strtod(buffer, &pEnd);

    printf("%.0lf ", numbers[0]);

    mean = numbers[0];\

    count++;

    for(i = 1; strcmp(pEnd, "\n"); i++) {

        numbers[i] = strtod(pEnd, &pEnd);

        mean += numbers[i];\

        count++;

        printf("%.0lf ", numbers[i]);
    }

    totMean += mean / i * .15;

    printf("\nQuiz Average - %.1lf%%", mean / i);

    printf("\n\nExam Scores: ");

    fgets(buffer, BUFFERSIZE, stdin);

    numbers[0] = strtod(buffer, &pEnd);

    printf("%.0lf ", numbers[0]);

    mean = numbers[0];

    count++;

    for(i = 1; strcmp(pEnd, "\0"); i++) {

        numbers[i] = strtod(pEnd, &pEnd);

        mean += numbers[i];

        count++;

        printf("%.0lf ", numbers[i]);
    }

    totMean += mean / i * .4;

    printf("\nExam Average - %.1lf%%", mean / i);

    printf("\n\nYour weighted percentage is: %.1lf%%", totMean);

    printf("\n\nYour final grade is: %.1lf\n\n", 4.2 - ((100 - totMean) / 12));

}

