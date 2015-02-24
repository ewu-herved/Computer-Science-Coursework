//Dan Herve
//CSCD 340: HW1

#include "linkedList.h"

LinkedList * linkedList(){ //Make a LinkedList

    return (LinkedList*)calloc(1, sizeof(LinkedList));
}

Node * buildNode(){

    return (Node*)calloc(1, sizeof(Node));
}

void sort(LinkedList * myList){//selection sort

    Node *curr;
    Node *prev;
    char * smallest;
    char * temp;

    if(myList->size == 0);

    for(prev = myList->head; prev != NULL; prev = prev->next) {

        smallest = prev->data;

        for(curr = prev->next; curr != NULL; curr = curr->next) {

            if(strcmp(smallest, curr->data) > 0) {

                temp = smallest;
                smallest = curr->data;
                prev->data = smallest;
                curr->data = temp;
            }
        }
    }
}

int strCompare(const void * str1, const void * str2) {

    const char ** a = (const char**) str1;
    const char ** b = (const char**) str2;
    return strcmp(*a, *b);
}

void clearList(LinkedList * theList){ //free the Nodes

    Node *curr;

    if(theList->size == 0);
    else {

        for(curr = theList->head; curr != NULL; curr = theList->head){

            theList->head = theList->head->next; //chop off the first node
            free(curr->data);
            free(curr);
            theList->size--;
        }
    }
}

void printList(LinkedList * theList, char *(*f)(Node * node)) {

    char * temp;

    if(theList == NULL || theList->head == NULL)
        printf("Empty List\n\n");
    else {

        Node *curr;

        for (curr = theList->head; curr != NULL; curr = curr->next){

            temp = f(curr);

            printf("%s\n", temp);

            free(temp);
        }
        printf("\n");
    }
}

void addLast(LinkedList * theList, Node * nn){//add Node to end of list

    Node *curr;

    if(theList->size == 0) {

        theList->head = nn;
        theList->size++;
    }

    else {

        for(curr = theList->head; curr->next != NULL; curr = curr->next);

        curr->next = nn;
        theList->size++;
    }
}

void addFirst(LinkedList * theList, Node * nn){//add Node to beginning of list

    nn->next = theList->head;
    theList->head = nn;
    theList->size++;
}

int size(LinkedList * myList){ //return LinkedList size

    if(myList == NULL)
        return 0;

    return myList->size;
}

void removeItem(LinkedList * theList, Node * nn) {

    Node *curr;
    Node *prev = theList->head;

    if(theList->size == 0) {

        return;
    }

    for(curr = theList->head; curr != NULL; prev = curr, curr = curr->next) {

        if(*((char**)(curr->data)) == *((char**)(nn->data))) {

            if(curr == theList->head) {//have to move head if removing head Node
                theList->head = curr->next;
            }
            prev->next = curr->next;
            theList->size--;
            free(curr->data);
            free(curr);
            free(nn->data);
            free(nn);
            return;
        }
    }
}

void * removeFirst(LinkedList *theList) {

    void * data;
    Node * curr = theList->head;

    theList->head = theList->head->next;

    data = curr->data;
    free(curr);
    return data;
}
