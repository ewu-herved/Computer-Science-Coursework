#include "cscd340HW3.h"

int main()
{
    LinkedList * finished = linkedList();
    LinkedList * ready = linkedList();

    readProcs(ready);

    sjf(ready, finished);

    readProcs(ready);

    priority(ready, finished);

    free(finished);
    free(ready);

    return 0;
}
