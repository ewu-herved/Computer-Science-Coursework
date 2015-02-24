#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {

    int count = 1;
    int sleepTime = atoi(argv[1]);
    int iterations = atoi(argv[2]);

    for(count = 1; count <= iterations; count++) {

        sleep(sleepTime);

        fprintf(stderr, "Executing lab1prob1, process id %d, iteration number %d\n", getpid(), count);
    }

    fprintf(stderr, "lab1prob1 is now executing...");

    return 0;
}
