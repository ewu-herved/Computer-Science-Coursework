#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct node
{
    void * data;
    struct node * next;
};
typedef struct node Node;


struct linkedlist
{
    Node * head;
    int size;
};
typedef struct linkedlist LinkedList;


LinkedList * linkedList();

Node * buildNode();
void sort(LinkedList * theList);
void clearList(LinkedList * theList);

void printList(LinkedList * theList, char *(*f)(Node * node));
void addLast(LinkedList * theList, Node * nn);
void addFirst(LinkedList * theList, Node * nn);
Node * removeItem(LinkedList * theList, void * comparable, int (*f)(Node *, void *));
void * removeFirst(LinkedList *theList);

#endif // LINKEDLIST_H
