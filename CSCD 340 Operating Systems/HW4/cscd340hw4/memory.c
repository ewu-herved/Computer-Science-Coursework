#include "memory.h"

void initialMemory(LinkedList * memory) {

    int memSize;
    int startAddress;
    char type[100];
    MemoryBlock * process = NULL;
    MemoryBlock * prev = NULL;

    FILE * fin = NULL;

    fin = fopen("initialMemory.txt", "r");

    if (fin == NULL) {

        printf("File could not be opened.\n");
        exit(-1);
    }

    fscanf(fin, "%d", &memSize);
    fscanf(fin, "%d", &startAddress);

    while (feof(fin) == 0) {

        process = (MemoryBlock *)calloc(1, sizeof(MemoryBlock));

        fscanf(fin, "%s", type);
        fscanf(fin, "%d", &process->processId);
        fscanf(fin, "%d", &process->segmentSize);
        fscanf(fin, "%d", &process->startAddress);
        process->endAddress = process->startAddress + process->segmentSize;

        if(prev == NULL || process->startAddress > prev->endAddress) {

            Node * nn = buildNode();
            MemoryBlock * hole = (MemoryBlock *)calloc(1, sizeof(MemoryBlock));

            hole->processId = 0;
            if(prev == NULL)
                hole->startAddress = startAddress;
            else
                hole->startAddress = process->startAddress - (process->startAddress - prev->endAddress);
            hole->endAddress = process->startAddress;
            hole->segmentSize = hole->endAddress - hole->startAddress;

            nn->data = hole;

            addLast(memory, nn);
        }

        Node * nn = buildNode();
        nn->data = process;

        addLast(memory, nn);

        prev = process;
    }

    if(prev == NULL || prev->endAddress < startAddress + memSize) {

        Node * nn = buildNode();
        MemoryBlock * hole = (MemoryBlock *)calloc(1, sizeof(MemoryBlock));

        hole->processId = 0;
        if(prev == NULL)
            hole->startAddress = startAddress;
        else
            hole->startAddress = prev->endAddress;
        hole->endAddress = startAddress + memSize;
        hole->segmentSize = hole->endAddress - hole->startAddress;

        nn->data = hole;

        addLast(memory, nn);
    }

    fclose(fin);
}

double firstFit(LinkedList * memory, MemoryBlock * newProcess) {

    double processTime = 0;

    int index = 0;

    Node * curr;

    for(curr = memory->head; curr != NULL; curr = curr->next, processTime++, index++) {

        MemoryBlock * temp = curr->data;

        if(temp->processId == 0 && temp->segmentSize >= newProcess->segmentSize) {

            if(newProcess->segmentSize == temp->segmentSize) {

                temp->processId = newProcess->processId;
                temp->segmentSize = newProcess->segmentSize;
                temp->endAddress = temp->startAddress + temp->segmentSize;
            }

            else {

                newProcess->startAddress = temp->startAddress;
                newProcess->endAddress = newProcess->startAddress + newProcess->segmentSize;
                temp->startAddress = newProcess->endAddress;
                temp->segmentSize = temp->endAddress - temp->startAddress;

                Node * temp = buildNode();

                temp->data = newProcess;

                addAtIndex(memory, temp, index);
            }

            return processTime;
        }
    }

    printf("Available memory is too small to accommodate pid %d in First Fit at this time\n\n", newProcess->processId);

    return processTime;
}

double bestFit(LinkedList * memory, MemoryBlock * newProcess) {

    double processTime = 0;

    int index = 0;

    int minIndex = 0;

    Node * minProcess = NULL;

    Node * curr;

    for(curr = memory->head; curr != NULL; curr = curr->next, processTime++, index++) {

        MemoryBlock * temp = curr->data;
        MemoryBlock * min = NULL;
        if(minProcess != NULL)
            min = minProcess->data;

        if(temp->processId == 0 && (minProcess == NULL  || temp->segmentSize < min->segmentSize) && newProcess->segmentSize <= temp->segmentSize) {

            minProcess = curr;
            minIndex = index;
        }
    }

    index = 0;

    for(curr = memory->head; curr != NULL; curr = curr->next, processTime++, index++) {

        MemoryBlock * temp = curr->data;

        if(index == minIndex && temp->segmentSize >= newProcess->segmentSize) {

            if(newProcess->segmentSize == temp->segmentSize) {

                temp->processId = newProcess->processId;
                temp->segmentSize = newProcess->segmentSize;
                temp->endAddress = temp->startAddress + temp->segmentSize;
            }

            else {

                newProcess->startAddress = temp->startAddress;
                newProcess->endAddress = newProcess->startAddress + newProcess->segmentSize;
                temp->startAddress = newProcess->endAddress;
                temp->segmentSize = temp->endAddress - temp->startAddress;

                Node * temp = buildNode();

                temp->data = newProcess;

                addAtIndex(memory, temp, index);
            }

            return processTime;
        }
    }

    printf("Available memory is too small to accommodate pid %d in Best Fit at this time\n\n", newProcess->processId);

    return processTime;
}

double worstFit(LinkedList * memory, MemoryBlock * newProcess) {

    double processTime = 0;

    int index = 0;

    int maxIndex = 0;

    Node * maxProcess = NULL;

    Node * curr;

    for(curr = memory->head; curr != NULL; curr = curr->next, processTime++, index++) {

        MemoryBlock * temp = curr->data;
        MemoryBlock * max = NULL;
        if (maxProcess != NULL)
            max = maxProcess->data;

        if(temp->processId == 0 && (maxProcess == NULL || temp->segmentSize > max->segmentSize) && newProcess->segmentSize <= temp->segmentSize) {

            maxProcess = curr;
            maxIndex = index;
        }
    }

    index = 0;

    for(curr = memory->head; curr != NULL; curr = curr->next, processTime++, index++) {

        MemoryBlock * temp = curr->data;

        if(index == maxIndex && temp->segmentSize >= newProcess->segmentSize) {

            if(newProcess->segmentSize == temp->segmentSize) {

                temp->processId = newProcess->processId;
                temp->segmentSize = newProcess->segmentSize;
                temp->endAddress = temp->startAddress + temp->segmentSize;
            }

            else {

                newProcess->startAddress = temp->startAddress;
                newProcess->endAddress = newProcess->startAddress + newProcess->segmentSize;
                temp->startAddress = newProcess->endAddress;
                temp->segmentSize = temp->endAddress - temp->startAddress;

                Node * temp = buildNode();

                temp->data = newProcess;

                addAtIndex(memory, temp, index);
            }

            return processTime;
        }
    }

    printf("Available memory is too small to accommodate pid %d in Worst Fit at this time\n\n", newProcess->processId);

    return processTime;
}

void printMemory(LinkedList * memory, char * algorithm) {

    Node * curr;

    printf("%s Algorithm\n\n", algorithm);

    for(curr = memory->head; curr != NULL; curr = curr->next) {

        MemoryBlock * temp = curr->data;

        if(temp->processId == 0)
            printf("Hole\n");
        else
            printf("pid P%d\n", temp->processId);
        printf("Start Address = %d\n", temp->startAddress);
        printf("Segment size = %d\n", temp->segmentSize);
        printf("End Address = %d\n\n", temp->endAddress);
    }

    printf("\n");
}
//
//int compareTo(Node * curr, void * comparable) {
//
//    PCB * temp = curr->data;
//    int arg = *((int *)comparable);
//
//    return temp->processID - arg;
//}
