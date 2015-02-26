#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define MAX 100

int buffer = 0;

pthread_mutex_t the_mutex;

pthread_cond_t condc;

pthread_cond_t condp;

void * producer(void * ptr)
{
    int x;

    for(x = buffer; x <= MAX; x++) {

        pthread_mutex_lock(&the_mutex);

        printf("Producer activates\n");

        while (buffer != 0) {

            printf("Producer waiting\n");

            pthread_cond_wait(&condp, &the_mutex);
        }

        buffer = x;
        printf("Producer produces; buffer is full up to position: %d\n", buffer);
        pthread_cond_signal(&condc);
        pthread_mutex_unlock(&the_mutex);
    }

    return 0;
}

void * consumer(void * ptr)
{
    //int x;

    while(buffer < MAX) {

        pthread_mutex_lock(&the_mutex);

        printf("Consumer activates\n");

        while (buffer == 0) {

            printf("Consumer waiting\n");

            pthread_cond_wait(&condc, &the_mutex);
        }

        buffer--;
        printf("Consumer consumes; buffer is full up to position: %d\n", buffer);
        pthread_cond_signal(&condp);
        pthread_mutex_unlock(&the_mutex);
    }

    return 0;
}

int main() {

    pthread_t pro, con;
	pthread_mutex_init(&the_mutex, 0);
	pthread_cond_init(&condc, 0);
	pthread_cond_init(&condp, 0);
	pthread_create(&pro, 0, producer, NULL);
	pthread_create(&con, 0, consumer, NULL);

	pthread_join(pro, NULL);
	pthread_join(con, NULL);
	pthread_cond_destroy(&condc);
	pthread_cond_destroy(&condp);
	pthread_mutex_destroy(&the_mutex);

    return 0;
}
