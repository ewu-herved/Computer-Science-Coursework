#ifndef LAB10_H_INCLUDED
#define LAB10_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct pte {

    int frame;
    int reference;
    int modifiable;
}PTE;

void openSetup(int * virtualAddressSpace, int * pageSize, int * physicalAddressSpace);
PTE ** buildVirtualMemory(int virtualAddressSpace, int pageSize, int physicalAddressSpace);
FILE * openFile();
void printPhysicalAddress(PTE ** virtualMemory, FILE * fin, int pageSize, int physicalAddressSpace);
void convertToBinary(int that, char ** num);
int binaryToDecimal(char * binaryStr);
int getPage(int logical, int pageSize);
int getPhysicalAddress(int logical, int pageSize);

#endif // LAB10_H_INCLUDED
