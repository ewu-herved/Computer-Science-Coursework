#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>

int *array;
int elements;
int counter;

void * status(void * tid) {

    while (counter < elements) {

        printf("thread %d filling array element %d with %d\n", *((int*)(tid)), counter, counter + 100);

        array[counter] = counter + 100;

        counter++;
    }

    pthread_exit(NULL);
}

int main(int argc, char * argv[]) {

    if (argc < 3 || argc > 3) {

        printf("Incorrect number of arguments; 2 expected\n");
        exit(-1);
    }

    elements = (int)strtol(argv[1], NULL, 10);
    int threads = (int)strtol(argv[2], NULL, 10);

    array = (int *)calloc(elements, sizeof(int));
    counter = 0;
    pthread_t tid[threads];
    int i;

    for(i = 0; i < threads; i++) {

        pthread_create(&tid[i], NULL, status, (void *)(&i));
    }

    for(i = 0; i < threads; i++) {

        pthread_join(tid[i], NULL);
    }

    free(array);

    return 0;
}
