#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void * hello(void * tid) {

    printf("Hello from thread %d\n", (int)tid + 1);
    pthread_exit(NULL);
}

void * goodbye(void * tid) {

    printf("Goodbye from thread %d\n", (int)tid + 1);
    pthread_exit(NULL);
}

int main()
{
    int status, x;
    pthread_t tid[6];

    for (x = 0; x < 6; x++) {

        printf("Creating thread %d\n", x + 1);

        if (x % 2 == 0) {

            status = pthread_create(&tid[x], NULL, hello, (void *)x);
        }

        else {

            status = pthread_create(&tid[x], NULL, goodbye, (void*)x);
        }

        if (status != 0) {

            printf("threading failed\n");
            exit(-1);
        }
    }

    for (x = 0; x < 6; x++)
        pthread_join(tid[x], NULL);

    return 0;
}


