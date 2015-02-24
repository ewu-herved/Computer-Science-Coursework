#include "process.h"

void readProcs(LinkedList * ready) {

    int procCount = 0;
    int count = 0;

    FILE * fin = NULL;

    fin = fopen("processes.txt", "r");

    if (fin == NULL) {

        printf("File could not be opened.");
        return;
    }

    fscanf(fin, "%d", &procCount);

    while (count < procCount && feof(fin) == 0) {

        PCB * process = (PCB *)calloc(1, sizeof(PCB));

        fscanf(fin, "%d", &process->processID);
        fscanf(fin, "%ld", &process->arrivalTimeStamp);
        fscanf(fin, "%ld", &process->totalBurstTime);
        process->remainingBurstTime = process->totalBurstTime;
        fscanf(fin, "%d", &process->processPriority);

        Node * nn = buildNode();
        nn->data = process;
        addLast(ready, nn);

        count++;
    }

    fclose(fin);
}

void sjf(LinkedList * ready, LinkedList * finished) {

    int time = 0;
    Node * curr;

    while(ready->size > 0) {

        curr = ready->head;

        PCB * nextUp = NULL;

        while(curr != NULL) {

            PCB * temp = curr->data;

            if(temp->arrivalTimeStamp <= time) {

                if(nextUp != NULL) {

                    if(temp->remainingBurstTime < nextUp->remainingBurstTime)
                        nextUp = temp;
                }
                else
                    nextUp = temp;
            }

            if(curr != NULL)
                curr = curr->next;
        }

        if (nextUp != NULL) {

            nextUp->executionStartTime = time;

            while(nextUp->remainingBurstTime > 0) {

                time++;
                nextUp->remainingBurstTime--;
            }

            nextUp->executionEndTime = time;

            addLast(finished, removeItem(ready, (void *)(&nextUp->processID), compareTo));

            nextUp = NULL;
        }
        else
            time++;

        curr = ready->head;
    }

    printPCB(finished, "Shortest Job First");
    clearList(finished);
}

void priority(LinkedList * ready, LinkedList * finished) {

    int time = 0;
    Node * curr;

    while(ready->size > 0) {

        curr = ready->head;

        PCB * nextUp = NULL;

        while(curr != NULL) {

            PCB * temp = curr->data;

            if(temp->arrivalTimeStamp <= time) {

                if(nextUp != NULL) {

                    if(temp->processPriority < nextUp->processPriority)
                        nextUp = temp;
                }
                else
                    nextUp = temp;
            }

            if(curr != NULL)
                curr = curr->next;
        }

        if (nextUp != NULL) {

            nextUp->executionStartTime = time;

            while(nextUp->remainingBurstTime > 0) {

                time++;
                nextUp->remainingBurstTime--;
            }

            nextUp->executionEndTime = time;

            addLast(finished, removeItem(ready, (void *)(&nextUp->processID), compareTo));

            nextUp = NULL;
        }
        else
            time++;

        curr = ready->head;
    }

    printPCB(finished, "Priority");
    clearList(finished);
}

void printPCB(LinkedList * finished, char * algorithm) {

    Node * curr;

    int totalProcs = 0;
    long totalWait = 0;
    long endRun = 0;
    long totalTA = 0;

    printf("%s Algorithm\n\n", algorithm);

    for(curr = finished->head; curr != NULL; curr = curr->next) {

        PCB * temp = curr->data;
        long waitTime = (temp->executionEndTime - temp->arrivalTimeStamp - temp->totalBurstTime);
        long turnaround = temp->executionEndTime - temp->arrivalTimeStamp;

//        printf("Process id = %d\n", temp->processID);
//        printf("Arrival Time = %ld\n", temp->arrivalTimeStamp);
//        printf("Execution Start Time = %ld\n", temp->executionStartTime);
//        printf("Execution End Time = %ld\n", temp->executionEndTime);
//        printf("Total Burst Time = %ld\n", temp->totalBurstTime);
//        printf("Job Priority = %d\n", temp->processPriority);
//        printf("Wait time = %ld\n", waitTime);
//        printf("Turnaround time = %ld\n\n", turnaround);

        totalWait = totalWait + waitTime;
        totalTA = totalTA + turnaround;
        totalProcs++;
        endRun = temp->executionEndTime;
    }

    printf("Throughput = %f\n", (double)((double)totalProcs / (double)endRun));
    printf("Average wait time = %f\n", (double)((double)totalWait / (double)totalProcs));
    printf("Average turnaround time = %f\n", (double)((double)totalTA / (double)totalProcs));

    printf("\n");
}

int compareTo(Node * curr, void * comparable) {

    PCB * temp = curr->data;
    int arg = *((int *)comparable);

    return temp->processID - arg;
}
