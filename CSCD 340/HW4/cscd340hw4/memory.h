#ifndef MEMORY_H
#define MEMORY_H

#include <stdlib.h>
#include <stdio.h>

#include "linkedList.h"

typedef struct MemoryBlock {

    int startAddress;
    int endAddress;
    int segmentSize;
    int processId; //0 indicates a free block
}MemoryBlock;

void initialMemory(LinkedList * memory);
double firstFit(LinkedList * memory, MemoryBlock * newProcess);
double bestFit(LinkedList * memory, MemoryBlock * newProcess);
double worstFit(LinkedList * memory, MemoryBlock * newProcess);
void printMemory(LinkedList * memory, char * algorithm);
void deleteProcess(LinkedList * algorithm, int pid);
//void sjf(LinkedList * ready, LinkedList * finished);
//void priority(LinkedList * ready, LinkedList * finished);
//int compareTo(Node * curr, void * comparable);
//void printPCB(LinkedList * finished, char * algorithm);

#endif // PROCESS_H_INCLUDED
