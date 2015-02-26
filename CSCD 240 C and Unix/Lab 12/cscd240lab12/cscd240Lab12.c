//Dan Herve
//CSCD 240: Lab 12
//comments in LinkedList.c

#include "list.h"

int main()
{
    int x, okay;
    Node * res = NULL;

    // creating a new list
    LinkedList * myList = linkedList();

    printf("Size of List is: %d\n", size(myList));
    printList(myList);
    printf("\n");

    // add first
    for(x = 10; x < 15; x++)
        addFirst(myList, x);

    printf("Size of List is: %d\n", size(myList));
    printList(myList);
    printf("\n");

    // add last
    for(x = 6; x > 0; x--)
        addLast(myList, x);

    printf("Size of List is: %d\n", size(myList));
    printList(myList);
    printf("\n");

     // add by index -- bad index
     okay = addDataByIndex(myList, 35, 35);
     if(!okay)
        printf("Not Added\n\n");

     else
     {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
     }// end else


    // add by index - index 3
    okay = addDataByIndex(myList, 35, 3);
    if(!okay)
        printf("Not Added\n\n");
    else
    {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
    }// end else


    // add by index - index 0
    okay = addDataByIndex(myList, 55, 0);
    if(!okay)
        printf("Not Added\n\n");
    else
    {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
    }// end else


    // add by index -- end of list
    okay = addDataByIndex(myList, 77, size(myList));
    if(!okay)
        printf("Not Added\n\n");
    else
    {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
    }// end else


     // Sort the list
    sort(myList);
    printf("Size of List is: %d\n", size(myList));
    printList(myList);
    printf("\n");



    // remove by index -- end of list
    res = removeByIndex(myList, size(myList) - 1);
    if(res == NULL)
        printf("Not Removed\n\n");
    else
    {
        printf("Removed Node value was: %d\n", res->data);
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else

    // remove by index -- Not in the list
    res = removeByIndex(myList, size(myList) + 1);
    if(res == NULL)
        printf("Not Removed\n\n");
    else
    {
        printf("Removed Node value was: %d\n", res->data);
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else

    // remove by index -- index 0
    res = removeByIndex(myList, 0);
    if(res == NULL)
        printf("Not Removed\n\n");
    else
    {
        printf("Removed Node value was: %d\n", res->data);
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else

    // remove by index -- index 5
    res = removeByIndex(myList, 5);
    if(res == NULL)
        printf("Not Removed\n\n");
    else
    {
        printf("Removed Node value was: %d\n", res->data);
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else


    // remove by value -- value 5
    printf("Attempting to remove %d\n", 5);
    okay = removeByValue(myList, 5);
    if(!okay)
        printf("Not Removed\n\n");
    else
    {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else

    // remove by value -- value 2
    printf("Attempting to remove %d\n", 2);
    okay = removeByValue(myList, 2);
    if(!okay)
        printf("Not Removed\n\n");
    else
    {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else

    // remove by value -- value 99 -- should fail
    printf("Attempting to remove %d\n", 99);
    okay = removeByValue(myList, 99);
    if(!okay)
        printf("Not Removed\n\n");
    else
    {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else

    // remove by value -- value 55
    printf("Attempting to remove %d\n", 55);
    okay = removeByValue(myList, 55);
    if(!okay)
        printf("Not Removed\n\n");
    else
    {
        printf("Size of List is: %d\n", size(myList));
        printList(myList);
        printf("\n");
        free(res);
        res = NULL;
    }// end else


    sort(myList);
    printf("Size of List is: %d\n", size(myList));
    printList(myList);
    printf("\n");


    // Clear the List
    clear(myList);
    free(myList);
    myList = NULL;

    printf("Size of List is: %d\n", size(myList));
    printList(myList);
    printf("\n");



    return 0;
}
