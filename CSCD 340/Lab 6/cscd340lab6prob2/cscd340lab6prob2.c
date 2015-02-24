#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define READERS 3

pthread_mutex_t the_mutex;
pthread_mutex_t db_mutex;
pthread_mutex_t order;
int rc = 0, prev = 0, curr = 0;

FILE * file;

void * reader(void * i) {

    int readNum = *((int*)i);

    //char buffer[100];

    while(1) {

        pthread_mutex_lock(&order);
        pthread_mutex_lock(&the_mutex);

        prev = rc;

        rc++;

        if(prev == 0) {

            pthread_mutex_lock(&db_mutex);
        }

        pthread_mutex_unlock(&the_mutex);

        pthread_mutex_unlock(&order);

        //fgets(buffer, 100, file);

        printf("This is reader %d\n", readNum);

        pthread_mutex_lock(&the_mutex);

        rc--;

        curr = rc;

        if(curr == 0) {

            pthread_mutex_unlock(&db_mutex);
        }

        pthread_mutex_unlock(&the_mutex);

        //printf("%s/n", buffer);
    }
}

void * writer(void *i) {

    while(1) {

        pthread_mutex_lock(&order);
        pthread_mutex_lock(&db_mutex);
        pthread_mutex_unlock(&order);

        //fprintf(file, "This is record %d\n", rc);

        printf("This is the writer\n");

        pthread_mutex_unlock(&db_mutex);
    }
}

int main()
{

    pthread_t tid[READERS];
    pthread_t wtid;

    pthread_mutex_init(&the_mutex, NULL);
    pthread_mutex_init(&db_mutex, NULL);
    pthread_mutex_init(&order, NULL);

    file = fopen("test.txt", "w");

    if ( file == NULL) {

        printf("File could not be opened\n");
        exit(-1);
    }

    int x;

    pthread_create(&wtid, NULL, writer, NULL);

    for(x = 0; x < READERS; x++) {

        pthread_create(&tid[x], NULL, reader, (void *)(&x));
    }

    for(x = 0; x < READERS; x++) {

        pthread_join(tid[x], NULL);
    }

    pthread_join(wtid, NULL);

    pthread_mutex_destroy(&the_mutex);
    pthread_mutex_destroy(&db_mutex);
    pthread_mutex_destroy(&order);

    return 0;
}
