#ifndef LAB4PROB1_H
#define LAB4PROB1_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <pthread.h>
#include <math.h>
#include "linkedList.h"

#define MAX 100

typedef struct command{

    int comNum;
    char *comName;
} Command;

void clean(int argc, char **argv);
void printargs(int argc, char **argv);
int makeargs(char *s, char *** argv);
void forkIt(char ** argv);
void strip(char *s);
Command * buildCom(char* str, int num);
char * comPrint(Node * node);
void clearListCom(LinkedList * theList);

#endif // LAB4PROB1_H
