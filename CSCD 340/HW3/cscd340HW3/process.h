#ifndef PROCESS_H
#define PROCESS_H

#include <stdlib.h>
#include <stdio.h>

#include "linkedList.h"

typedef struct pcb {

    int processID;
    long arrivalTimeStamp;
    long totalBurstTime;
    long executionStartTime;
    long executionEndTime;
    long remainingBurstTime;
    int processPriority;
}PCB;

void readProcs(LinkedList * waiting);
void sjf(LinkedList * ready, LinkedList * finished);
void priority(LinkedList * ready, LinkedList * finished);
int compareTo(Node * curr, void * comparable);
void printPCB(LinkedList * finished, char * algorithm);

#endif // PROCESS_H_INCLUDED
