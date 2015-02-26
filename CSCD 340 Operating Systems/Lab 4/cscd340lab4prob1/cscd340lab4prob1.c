
#include "lab4prob1.h"

int main()
{
	char **argv;
	char s[MAX];
	int argc;
	LinkedList * comList = linkedList();
	Node * nn;
	char * (*fp)(Node *) = comPrint;

	printf("Please enter a command (exit to exit or print to print) ");
	fgets(s, MAX, stdin);
	strip(s);

 	while(strcmp(s, "exit") != 0)
  	{
  	    if(strcmp(s, "print") == 0) {

           printList(comList, fp);
  	    }

  	    else {

		argc = makeargs(s, &argv);
  		if(argc != -1)
  		{
    			printf("There are %d tokens.\nThe tokens are:\n", argc);
    			printargs(argc, argv);
    			nn = buildNode();
                nn->data = buildCom(s, comList->size + 1);
    			addLast(comList, nn);

			forkIt(argv);
		}//end if

  		clean(argc, argv);
  		argv = NULL;
  	    }

		printf("Please enter a command (exit to exit or print to print) ");
		fgets(s, MAX, stdin);
        strip(s);
	}// end while
	clearListCom(comList);
	free(comList);
    return 0;
}// end main

void clean(int argc, char **argv)
{
    int count = 0;

    for(count = 0; count <= argc; count++) {

        free(argv[count]);
    }

    free(argv);
}// end clean

void printargs(int argc, char **argv)
{
	int x;
	for(x = 0; x < argc; x++)
		printf("%s\n", argv[x]);
    printf("\n");

}// end printargs

int makeargs(char *s, char *** argv)
{
   int argc = 0; //number of commands
   LinkedList *comToks = linkedList(); //LinkedList of command tokens
   int count = 0; //iterator
   char *temp = NULL;
   char * saveptr = NULL;
   Node * nn;

    if(strcmp(s, "\0") != 0) { // prime read to populate comToks

        temp = strtok_r(s, " ", &saveptr);

        strip(temp);

        nn = buildNode();

        nn->data = (char*)calloc(strlen(temp) + 1, sizeof(char));

        strcpy(nn->data, temp);

        addLast(comToks, nn);

        temp = strtok_r(NULL, " ", &saveptr);
    }

   while(temp != NULL) { //populate comToks with all commands

      strip(temp);
      nn = buildNode();
      nn->data = (char*)calloc(strlen(temp) + 1, sizeof(char));
      strcpy(nn->data, temp);
      addLast(comToks, nn);
      temp = strtok_r(NULL, " ", &saveptr);
   }

   argc = comToks->size;

   (*argv) = (char**)calloc(comToks->size + 1, sizeof(char*)); //allocate memory for array of command tokens

   if(argc == 0) { //check to see if no commands were entered

      printf("Error: no string entered\n\n");
      free(comToks);
      return -1;
   }

   for(count = 0; count < comToks->size; count++) { //depopulate comToks and populate argv with popped nodes

      temp = (char*)removeFirst(comToks);
      (*argv)[count] = (char*)calloc(strlen(temp) + 1, sizeof(char));
      strcpy((*argv)[count], temp);
      free(temp);
   }

   free(comToks);

   return argc; //returns the number of commands

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

Command * buildCom(char* str, int num) {

   Command * command = (Command *)calloc(1, sizeof(Command));

   command->comName = (char*)calloc(strlen(str) + 1, sizeof(char));

   strcpy(command->comName, str);
   command->comNum = num;

   return command;
}

char * comPrint(Node * node) {

    Command * com = node->data;
    char * str= com->comName;
    int num = com->comNum;
    char numStr[30];
    sprintf(numStr, "%d", num);

    char * temp = (char*)calloc((strlen(str) + 1 + strlen(numStr) + 1), sizeof(char));
    sprintf(temp, "%s %s", numStr, str);

    return temp;
}

void clearListCom(LinkedList * theList){ //free the Nodes

    Node *curr;
    Command * temp;

    if(theList->size == 0);
    else {

        for(curr = theList->head; curr != NULL; curr = theList->head){

            theList->head = theList->head->next; //chop off the first node
            temp = curr->data;
            free(temp->comName);
            free(curr->data);
            free(curr);
            theList->size--;
        }
    }
}
