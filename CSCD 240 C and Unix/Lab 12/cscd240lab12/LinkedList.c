//Dan Herve
//CSCD 240: Lab 12

#include "list.h"

LinkedList * linkedList(){ //Make a LinkedList

    return (LinkedList*)calloc(1, sizeof(LinkedList));
}

void clear(LinkedList * myList){ //free the Nodes

    Node *curr;

    if(myList->size == 0);
    else {

        for(curr = myList->head; curr != NULL; curr = myList->head){

            myList->head = myList->head->next; //chop off the first node
            free(curr);
            myList->size--;
        }
    }
}

int size(LinkedList * myList){ //return LinkedList size

    if(myList == NULL)
        return 0;

    return myList->size;
}

void addFirst(LinkedList * myList, int d){//add Node to beginning of list

    Node *node = (Node*)calloc(1, sizeof(Node));

    node->data = d;

    node->next = myList->head;
    myList->head = node;
    myList->size++;
}

void addLast(LinkedList * myList, int d){//add Node to end of list

    Node *node = (Node*)calloc(1, sizeof(Node));
    node->data = d;
    Node *curr;

    if(myList->size == 0) {

        myList->head = node;
        myList->size++;
    }

    for(curr = myList->head; curr->next != NULL; curr = curr->next);

    curr->next = node;
    myList->size++;
}

int addDataByIndex(LinkedList * myList, int d, int index){

    Node *node = (Node*)calloc(1, sizeof(Node));//new Node
    node->data = d;
    int count = 0;
    Node *curr = myList->head->next;
    Node *prev = myList->head;

    if((myList->size == 0 && index == 0) || index == 0) {

        free(node);//wasn't used
        addFirst(myList, d);
        return 1;
    }
    else if (index - 1 >= myList->size) {

        free(node);//wasn't used
        printf("Index out of Bounds!\n");
        return 0;
    }

    for(curr = myList->head; count < index; prev = curr, curr = curr->next, count++);

    node->next = curr;
    prev->next = node;
    myList->size++;
    return 1;
}

void sort(LinkedList * myList){//selection sort

    Node *curr;
    Node *prev;
    int smallest = 0;
    int temp = 0;

    if(myList->size == 0);

    for(prev = myList->head; prev != NULL; prev = prev->next) {

        smallest = prev->data;

        for(curr = prev->next; curr != NULL; curr = curr->next) {

            if(smallest > curr->data) {

                temp = smallest;
                smallest = curr->data;
                prev->data = smallest;
                curr->data = temp;
            }
        }
    }
}

Node * removeByIndex(LinkedList * theList, int index){

    int count = 0;
    Node *curr = theList->head;
    Node *prev = theList->head;

    if(theList->size == 0) {

        return NULL;
    }

    if(index - 1 >= theList->size) {

        printf("Index out of Bounds!\n");
        return NULL;
    }

    for(curr = theList->head; count < index; prev = curr, curr = curr->next, count++);

    if(index == 0)//have to move head if removing head Node
        theList->head = curr->next;
    prev->next = curr->next;
    theList->size--;
    return curr;
}

int removeByValue(LinkedList * theList, int d) {

    Node *curr;
    Node *prev = theList->head;
    int data = 0;

    if(theList->size == 0) {

        return 0;
    }

    for(curr = theList->head; curr != NULL; prev = curr, curr = curr->next) {

        if(curr->data == d) {

            if(curr == theList->head)//have to move head if removing head Node
                theList->head = curr->next;
            prev->next = curr->next;
            theList->size--;
            data = curr->data;
            free(curr);
            return data;
        }
    }

    return 0;
}

void printList(LinkedList * myList) {

    if(myList == NULL || myList->head == NULL)
        printf("Empty List\n");
    else {

        Node *curr;
        printf("[");
        for (curr = myList->head; curr != NULL; curr = curr->next){

            if(curr->next == NULL)
                printf("%d]", curr->data);
            else
                printf("%d, ", curr->data);
        }
        printf("\n");
    }
}
