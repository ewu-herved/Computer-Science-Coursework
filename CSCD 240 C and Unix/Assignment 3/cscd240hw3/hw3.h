#ifndef HW3_H_INCLUDED
#define HW3_H_INCLUDED

#include "FileUtil.h"
#include <string.h>

typedef struct Company {

    char *name;
    char *symbol;
} Company;

typedef struct Stock {

    Company company;
    double price;
    int shares;
} Stock;

typedef struct Node {

    Stock *data;
    struct Node *next;
} Node;

typedef struct LinkedList {

    Node *head;
    int size;
} LinkedList;

int countRecords(FILE * fin, int lines);

void buildList(LinkedList *myList, FILE *fin, int total);

int menu();

void printStockValue(LinkedList *myList);

void buyStock(LinkedList *myList, int *total);

void sellStock(LinkedList *myList, int *total);

void printStockInfo(LinkedList *myList);

void cleanUp(LinkedList * myList);

void strip(char str[]);



LinkedList * linkedList();

//void cleanUp(LinkedList * myList);

int size(LinkedList * myList);

void addFirst(LinkedList * myList, Stock *d);

void addLast(LinkedList * myList, Stock *d);

int addDataByIndex(LinkedList * myList, Stock *d, int index);

void sort(LinkedList * myList);

Node * removeByIndex(LinkedList * theList, int index);

Stock * removeByValue(LinkedList * theList, Stock *d);

int search(LinkedList * myList, char * key);

void printList(LinkedList * myList);

#endif // HW3_H_INCLUDED
