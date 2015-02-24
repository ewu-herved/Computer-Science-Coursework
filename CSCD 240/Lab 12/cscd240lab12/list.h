//Dan Herve
//CSCD 240: Lab 12
//comments in LinkedList.c

#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED

#include <stdlib.h>
#include <stdio.h>

typedef struct Node {

    int data;
    struct Node *next;
} Node;

typedef struct LinkedList {

    Node *head;
    int size;
} LinkedList;

LinkedList * linkedList();

void clear(LinkedList * myList);

int size(LinkedList * myList);

void addFirst(LinkedList * myList, int d);

void addLast(LinkedList * myList, int d);

int addDataByIndex(LinkedList * myList, int d, int index);

void sort(LinkedList * myList);

Node * removeByIndex(LinkedList * theList, int index);

int removeByValue(LinkedList * theList, int d);

void printList(LinkedList * myList);

#endif // LIST_H_INCLUDED
