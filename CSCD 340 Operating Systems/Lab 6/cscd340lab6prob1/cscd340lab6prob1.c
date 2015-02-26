#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define FORKS 5
#define THINKING 0
#define HUNGRY 1
#define EATING 2

int state[FORKS];

pthread_cond_t philArray[FORKS];

pthread_mutex_t the_mutex;

void test(int i) {

    if (state[i] == HUNGRY && state[(i + 4) % FORKS] != EATING && state[(i + 1) % FORKS] != EATING) {

        state[i] = EATING;

        printf("Philosopher %d starts eating.\n", i);

        printf("[%d, %d, %d, %d, %d]\n", state[0], state[1], state[2], state[3], state[4]);

        pthread_cond_signal(&philArray[i]);
    }
    else {

        if (state[i] == THINKING) {

            printf("Philosopher %d is deep in thought.\n", i);
        }
    }
}

void takeFork(int i) {

    pthread_mutex_lock(&the_mutex);

    printf("Philosopher %d is hungry.\n", i);

    state[i] = HUNGRY;

    test(i);

    if(state[i] != EATING) {
        printf("Philosopher %d does not have enough chopsticks available\n", i);
        printf("[%d, %d, %d, %d, %d]\n", state[0], state[1], state[2], state[3], state[4]);
        pthread_cond_wait(&philArray[i], &the_mutex);
    }

    pthread_mutex_unlock(&the_mutex);
}

void putFork(int i) {

    pthread_mutex_lock(&the_mutex);

    state[i] = THINKING;

    printf("Philosopher %d puts down the forks and starts thinking.\n", i);

    printf("[%d, %d, %d, %d, %d]\n", state[0], state[1], state[2], state[3], state[4]);

    test((i + 4) % FORKS);

    test((i + 1) % FORKS);

    pthread_mutex_unlock(&the_mutex);


}

void * phil(void * tid) {

    int temp = *((int*)tid);

    while(1) {

        takeFork(temp);

        putFork(temp);
    }
}

int main()
{

    pthread_t tid[FORKS];

    int i;

    pthread_mutex_init(&the_mutex, NULL);

    for(i = 0; i < FORKS; i++) {

        state[i] = THINKING;
        pthread_cond_init(&philArray[i], NULL);
    }

    for(i = 0; i < FORKS; i++) {

        pthread_create(&tid[i], NULL, phil, (void *)(&i));
    }

    for(i = 0; i < FORKS; i++) {

        pthread_join(tid[i], NULL);
    }

    for(i = 0; i < FORKS; i++) {

        pthread_cond_destroy(&philArray[i]);
    }

    pthread_mutex_destroy(&the_mutex);

    return 0;
}
