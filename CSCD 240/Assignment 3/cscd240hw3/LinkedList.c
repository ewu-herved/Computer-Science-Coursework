//Dan Herve
//CSCD 240: HW3

#include "hw3.h"

LinkedList * linkedList(){ //Make a LinkedList

    return (LinkedList*)calloc(1, sizeof(LinkedList));
}

//void cleanUp(LinkedList * myList){ //free the Nodes
//
//    Node *curr;
//
//    if(myList->size == 0);
//    else {
//
//        for(curr = myList->head; curr != NULL; curr = myList->head){
//
//            myList->head = myList->head->next; //chop off the first node
//            free(curr);
//
//            myList->size--;
//        }
//    }
//}

int size(LinkedList * myList){ //return LinkedList size

    if(myList == NULL)
        return 0;

    return myList->size;
}

void addFirst(LinkedList * myList, Stock *d){//add Node to beginning of list

    Node *node = (Node*)calloc(1, sizeof(Node));

    node->data = d;

    node->next = myList->head;
    myList->head = node;
    myList->size++;
}

void addLast(LinkedList * myList, Stock *d){//add Node to end of list

    Node *node = (Node*)calloc(1, sizeof(Node));
    node->data = d;
    Node *curr;

    if(myList->size == 0) {

        myList->head = node;
        myList->size++;
    }

    else {
        for(curr = myList->head; curr->next != NULL; curr = curr->next);

        curr->next = node;
        myList->size++;
    }
}

int addDataByIndex(LinkedList * myList, Stock *d, int index){

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

//void sort(LinkedList * myList){//selection sort
//
//    Node *curr;
//    Node *prev;
//    Stock *smallest = NULL;
//    Stock *temp = NULL;
//
//    if(myList->size == 0);
//
//    for(prev = myList->head; prev != NULL; prev = prev->next) {
//
//        smallest = prev->data;
//
//        for(curr = prev->next; curr != NULL; curr = curr->next) {
//
//            if(smallest > curr->data) {
//
//                temp = smallest;
//                smallest = curr->data;
//                prev->data = smallest;
//                curr->data = temp;
//            }
//        }
//    }
//}

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

Stock * removeByValue(LinkedList * theList, Stock *d) {

    Node *curr;
    Node *prev = theList->head;
    Stock *data = NULL;
    Node *temp = NULL;

    if(theList->size == 0) {

        return NULL;
    }

    for(curr = theList->head; curr != NULL; prev = curr, curr = curr->next) {

        if(strcmp(curr->data->company.symbol, d->company.symbol) == 0)  {

            if(curr == theList->head)//have to move head if removing head Node
                theList->head = curr->next;
            prev->next = curr->next;
            theList->size--;
            data = curr->data;
            free(data->company.name);
            free(data->company.symbol);
            free(&(data->company));
            temp = curr;
            curr = curr->next;
            temp->data = NULL;
            free(temp);
            return data;
        }
    }

    return NULL;
}

int search(LinkedList * myList, char * key) {

    Node *curr = NULL;

    for (curr = myList->head; curr != NULL; curr = curr->next) {

        if (strcmp(key, curr->data->company.symbol) == 0) {

            return 1;
        }
    }

    return 0;
}

//void printList(LinkedList * myList) {
//
//    if(myList == NULL || myList->head == NULL)
//        printf("Empty List\n");
//    else {
//
//        Node *curr;
//        printf("[");
//        for (curr = myList->head; curr != NULL; curr = curr->next){
//
//            if(curr->next == NULL)
//                printf("%p]", curr->data);
//            else
//                printf("%p, ", curr->data);
//        }
//        printf("\n");
//    }
//}
