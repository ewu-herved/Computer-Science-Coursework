#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <pthread.h>
#include <sys/types.h>
#define MAX 100

void pipeIt(char ** prePipe, char ** postPipe);
void writePipe(int fd, char **command, int args);
void readPipe(int fd, char **command);

int main()
{
	char * prePipe[] = {"ls", "-l", NULL}, * postPipe[] = {"wc", "-w", NULL};

    pipeIt(prePipe, postPipe);

}// end main

void pipeIt(char ** prePipe, char ** postPipe)
{

    int fd[2], * status;
    pid_t id;

    if (pipe(fd) < 0) {

        printf("Error: failed to open file descriptors\n");
        exit(-1);
    }

    id = fork();

    if (id < 0) {

        exit(-1);
    }

    else if (id != 0) {

        close(fd[1]);
        close(0);
        dup(fd[0]);
        execvp(postPipe[0], postPipe);
    }
    else {

        close(fd[0]); //we want to control the read in in case we’re not ready for it
        close(1); //we don’t want to write to actual stdout
        dup(fd[1]); //points to stdout
        close(fd[1]); //stdout is now pointing here, so fd[1] is not needed
	    execvp(prePipe[0], prePipe);
    }
}// end pipeIt;

void writePipe(int fd, char **command, int args){

    FILE * file;
    int i;
    file = fdopen(fd, "w");
    for(i = 0; i < args; i++) {

        if(i == args -1) {

            fprintf(file, "%s", command[i]);


            printf("test_fprintf\n");
        }
        else {

            fprintf(file, "%s ", command[i]);
        }
    }

    fclose(file);
}

void readPipe(int fd, char **command){

    FILE * file;
    char buffer[100];
    file = fdopen(fd, "r");
    fgets(buffer, 100, file);
    strcpy(*command, buffer);
    fclose(file);
}
