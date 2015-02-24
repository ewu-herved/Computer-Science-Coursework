#include <stdio.h>
#include <stdlib.h>
#include <string.h>
const int MAX=1000;

void strip(char *s)
{
  int len;
  len = strlen(s);
  if(s[len - 2] == '\r')
    s[len -2] = '\0';

    s[len -1] = '\0';
}// end strip  else if(s[len - 1] == '\n')


void clean(int argc, char **argv)
{

    int count = 0;

    for(count = 0; count <= argc; count++) {

        free(argv[count]);
    }

    free(argv);
}

void printargs(int argc, char **argv)
{
	int x;
	for(x = 0; x < argc; x++)
		printf("%s\n", argv[x]);

}

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

   return argc;

}// end makeArgs


int main()
{
  char **argv = NULL;
  char s[1000];
  int argc;

  printf("Please enter a string to parse: ");
  fgets(s, 1000, stdin);

  strip(s);
  printf("\n");

  argc = makeargs(s, &argv);
  if(argc != -1)
  {
    printf("There are %d tokens.\nThe tokens are:\n", argc);
    printargs(argc, argv);

  }// end if

  clean(argc, argv);
  argv = NULL;

    return 0;
}// end main
