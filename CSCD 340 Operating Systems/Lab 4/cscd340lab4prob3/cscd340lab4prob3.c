#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include "linkedList.h"
#define MAX 100

void makeargs(char *s, char *** prePipe, char *** postPipe);
void pipeIt(char ** prePipe, char ** postPipe);
void clean(char ***prePipe, char ***postPipe);
void strip(char *s);

int main()
{
	char s[MAX];
	char ** prePipe = NULL, ** postPipe = NULL;

	printf("Please enter a string (exit to exit) ");
	fgets(s, MAX, stdin);

	strip(s);
	makeargs(s, &prePipe, &postPipe);

	while(strcmp(s, "exit") != 0)
	{
		// code to determine pipe sides

		pipeIt(prePipe, postPipe);


		printf("Please enter a string (exit to exit) ");
		fgets(s, MAX, stdin);
		strip(s);

	}// end while
	clean(&prePipe, &postPipe);
    return 0;
}// end main

void makeargs(char *s, char *** prePipe, char *** postPipe)
{
   int preArgs = 0, postArgs = 0, pipeFlag = 0; //number of commands
   LinkedList *comToks = linkedList(); //LinkedList of command tokens *************
   int count = 0; //iterator
   char *temp = NULL;
   char * saveptr = NULL;
   Node * nn;

    if(strcmp(s, "\0") != 0) { // prime read to populate comToks

        temp = strtok_r(s, " ", &saveptr);

        strip(temp);

        nn = buildNode(); // ****************

        nn->data = (char*)calloc(strlen(temp) + 1, sizeof(char)); //****************

        strcpy(nn->data, temp);

        addLast(comToks, nn);

        preArgs++;

        temp = strtok_r(NULL, " ", &saveptr);
    }

   while(temp != NULL) { //populate comToks with all commands

      strip(temp);

      if (strcmp(temp, "|") != 0) {
          nn = buildNode();
          nn->data = (char*)calloc(strlen(temp) + 1, sizeof(char));
          strcpy(nn->data, temp);
          addLast(comToks, nn);
      }
      else {
          pipeFlag = -1;
      }

      temp = strtok_r(NULL, " ", &saveptr);

      if (pipeFlag == 0) {
          preArgs++;
      }
      else if(pipeFlag == -1) {
          pipeFlag = 1;
      }
      else{
          postArgs++;
      }
   }

   (*prePipe) = (char**)calloc(preArgs + 1, sizeof(char*)); //****************
   (*postPipe) = (char**)calloc(postArgs + 1, sizeof(char*));//*****************

   if(preArgs == 0) { //check to see if no commands were entered

      printf("Error: no string entered\n\n");
      free(comToks);
      return;
   }

   while (preArgs > 0 || postArgs > 0) { //depopulate comToks and populate argv with popped nodes

      temp = (char*)removeFirst(comToks);

      if(preArgs > 0) {

          (*prePipe)[count] = (char*)calloc(strlen(temp) + 1, sizeof(char)); //**************
          strcpy((*prePipe)[count], temp);
          preArgs--;
          count++;
          free(temp);
          if (preArgs == 0) {
              count = 0;
          }
      }
      else if(postArgs > 0) {

          (*postPipe)[count] = (char*)calloc(strlen(temp) + 1, sizeof(char));
          strcpy((*postPipe)[count], temp);
          postArgs--;
          count++;
          free(temp);
      }
   }

   free(comToks);

}// end makeArgs

void pipeIt(char ** prePipe, char ** postPipe)
{

    int fd[2];
    pid_t id;

    if (pipe(fd) < 0) {

        printf("Error: failed to open file descriptors\n");
        exit(-1);
    }

    id = fork();

    if (id < 0) {

        printf("Error: fork returning bad pid\n");
        exit(-1);
    }

    else if (id == 0) {

        close(fd[0]);
        close(1);
        dup(fd[1]);
        if (execvp(prePipe[0], prePipe) < 0) {
            printf("Error: Parent exec failed.\n");
            exit(-1);
        }
        printf("test_pipeit\n");
    }
    else {

        close(fd[1]); //we want to control the read in in case we’re not ready for it
        close(0); //we don’t want to write to actual stdout
        dup(fd[0]); //points to stdout
        //close(fd[1]); //stdout is now pointing here, so fd[1] is not needed
	    if (execvp(postPipe[0], postPipe) < 0) {
            printf("Error: Child exec failed.\n");
            exit(-1);
	    }
	    printf("test_pipeit\n");
    }
}// end pipeIt

void clean(char ***prePipe, char ***postPipe)
{
    int i;

    for(i = 0; (*prePipe)[i] != NULL; i++) {

        free((*prePipe)[i]);
    }

    for(i = 0; (*postPipe)[i] != NULL; i++) {

        free((*postPipe)[i]);
    }
    free(*prePipe);
    free(*postPipe);

}// end clean

void strip(char *s)
{

    int x = 0;

    if(s == NULL) {

        return;
    }

    while(s[x] != '\r' && s[x] != '\n' && s[x] != '\0') {

        x++;
    }
    s[x] = '\0';

    if (s[0] == ' ') {

        x = 1;

        while(s[x] == ' ') {

            x++;
        }

        sprintf(s, "%.*s", (int)strlen(s), s + x);
    }
}// end strip
