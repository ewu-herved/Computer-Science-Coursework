#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAX 100

void clean(int argc, char **argv);
void printargs(int argc, char **argv);
int makeargs(char *s, char *** argv);
void forkIt(char ** argv);
void strip(char *s);

int main()
{
	char **argv = NULL, s[MAX];
	int argc;

	printf("Please enter a command (exit to exit) ");
	fgets(s, MAX, stdin);

 	while(strcmp(s, "exit\n") != 0)
  	{
		argc = makeargs(s, &argv);
  		if(argc != -1)
  		{
    			printf("There are %d tokens.\nThe tokens are:\n", argc);
    			printargs(argc, argv);
		}// end if

		forkIt(argv);

  		clean(argc, argv);
  		argv = NULL;

		printf("Please enter a command (exit to exit) ");
		fgets(s, MAX, stdin);

	}// end while

}// end main

void clean(int argc, char **argv)
{
    int count = 0;

    for(count = 0; count < argc; count++) {

        free(argv[count]);
    }

    free(argv);
}// end clean

void printargs(int argc, char **argv)
{
	int x;
	for(x = 0; x < argc; x++)
		printf("%s\n", argv[x]);

}// end printargs

int makeargs(char *s, char *** argv)
{
   int argc = 0;
   int count = 0;
   char *temp = NULL;
   char sCpy[strlen(s)];
   char * saveptr = NULL;

   strcpy(sCpy, s);

   temp = strtok_r(s, " ", &saveptr);

   temp = strtok_r(NULL, " ", &saveptr);

   if (strcmp("\n", s) != 0) {

      argc++;
   }

   while(temp != NULL) {

      temp = strtok_r(NULL, " ", &saveptr);
      argc++;
   }

   if(argc == 0) {

      return -1;
   }

   (*argv) = (char**)calloc(argc + 1, sizeof(char*));

   temp = strtok_r(sCpy, " ", &saveptr);

   strip(temp);

   (*argv)[count] = (char*)calloc(strlen(temp) + 1, sizeof(char));

   strcpy((*argv)[count], temp);

   count++;

   while(count < argc) {

      temp = strtok_r(NULL, " ", &saveptr);
      strip(temp);
      (*argv)[count] = (char*)calloc(strlen(temp) + 1, sizeof(char));
      strcpy((*argv)[count], temp);
      count++;
   }

   (*argv)[count] = (char*)NULL;

   return argc;

}// end makeArgs

void forkIt(char ** argv)
{

    int status;
    pid_t pid = fork();

    if(pid < 0) {

	printf("Error: forking failed\n");
	exit(1);
    }

    else if(pid != 0) { //not child

        waitpid(-1, &status, 0);
    }

    else {

        if (execvp(argv[0], argv) < 0) {

            printf("Error: exec failed\n");
            exit(1);
        }
    }
}// end forkIt

void strip(char *s)
{
  int len;
  len = strlen(s);
  if(s[len - 2] == '\r')
    s[len -2] = '\0';

  else if(s[len - 1] == '\n')
    s[len -1] = '\0';
}// end strip

