#include <stdio.h>
#include <stdlib.h>

#include "memory.h"

int menu();

MemoryBlock * getProcess();

void printMemoryMenu(LinkedList * first, LinkedList * best, LinkedList * worst);
void analyse(LinkedList * algorithm, double processTime, double runs, char * name);
int deleteThis();

int main()
{
    LinkedList * first = linkedList();
    LinkedList * best = linkedList();
    LinkedList * worst = linkedList();
    MemoryBlock * process;

    int choice = 0;

    double firstFitProcessTime = 0;
    double firstFitRuns = 0;
    double bestFitProcessTime = 0;
    double bestFitRuns = 0;
    double worstFitProcessTime = 0;
    double worstFitRuns = 0;

    initialMemory(first);
    initialMemory(best);
    initialMemory(worst);

    do
    {
        choice = menu();
        int del;

        switch(choice)
        {
            case 1: printMemoryMenu(first, best, worst);
                    break;

            case 2: process = getProcess();
                    firstFitProcessTime += firstFit(first, process);
                    firstFitRuns++;
                    bestFitProcessTime += bestFit(best, process);
                    bestFitRuns++;
                    worstFitProcessTime += worstFit(worst, process);
                    worstFitRuns++;
                    break;

            case 3: analyse(first, firstFitProcessTime, firstFitRuns, "First Fit");
                    analyse(best, bestFitProcessTime, bestFitRuns, "Best Fit");
                    analyse(worst, worstFitProcessTime, worstFitRuns, "Worst Fit");
                    break;

            case 4: del = deleteThis();
                    deleteProcess(first, del);
                    //deleteProcess(best, del);
                    //deleteProcess(worst, del);
                    break;

            case 5:
                    break;


            default: printf("That is not a valid menu choice\n");
        }// end switch

    }while(choice != 5);

    clearList(first);
    clearList(best);
    clearList(worst);
    free(first);
    free(best);
    free(worst);

    return 0;
}

int menu(){

    int choice = 0;

    do {

        printf("1) Print the Memory Map\n2) Enter new process\n3) Analyze Processes\n4) Delete a process\n5) Quit -\n\nChoice--> ");

        scanf("%d", &choice);

        printf("\n");

    } while(choice < 1 || choice > 5);

    return choice;
}

MemoryBlock * getProcess() {

    MemoryBlock * process = (MemoryBlock *)calloc(1, sizeof(MemoryBlock));

    printf("Type your processID# (int): ");
    scanf("%d", &process->processId);
    printf("Type the process's segment size (int): ");
    scanf("%d", &process->segmentSize);
    printf("\n");

    return process;
}

void printMemoryMenu(LinkedList * first, LinkedList * best, LinkedList * worst) {

    int choice = 0;

    printf("1) Print the First Fit Memory Map\n2) Print the Best Fit Memory Map\n3) Print the Worst Fit Memory Map\n\nChoice--> ");

    scanf("%d", &choice);

    printf("\n");

    switch(choice)
    {
        case 1: printMemory(first, "First Fit");
                break;

        case 2: printMemory(best, "Best Fit");
                break;

        case 3: printMemory(worst, "Worst Fit");
                break;

        default: printf("That is not a valid menu choice\n");
    }// end switch
}

void analyse(LinkedList * algorithm, double processTime, double runs, char * name) {

    Node * curr;

    printf("%s Algorithm\n\n", name);

    double holes = 0;

    double totalHoleSize = 0;

    for(curr = algorithm->head; curr != NULL; curr = curr->next) {

        MemoryBlock * temp = curr->data;

        if(temp->processId == 0) {
            holes++;
            totalHoleSize += (double)(temp->segmentSize);
        }

        //average placement time
        //number of holes
        //average size of holes
    }

    printf("Average Placement Time = %.3lf\n", processTime / runs);
    printf("Fragments = %.0lf\n", holes);
    printf("Average Fragment Size = %.3lf\n\n", totalHoleSize / holes);

    printf("\n");
}

int deleteThis() {

    int temp;

    printf("Type the processID# you want to clear (int): ");
    scanf("%d", &temp);
    printf("\n");

    return temp;
}
