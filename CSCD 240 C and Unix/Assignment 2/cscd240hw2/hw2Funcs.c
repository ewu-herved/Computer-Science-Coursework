#include "cscd240hw2.h"

char ** fillArray(FILE *fin, int *total) { //fills arrays from file data
                                           //format specified in cscd240hw2.c
    char buffer[100];
    int x = 0;
    char ** pos = NULL;

    fscanf(fin, "%d", total);
    fscanf(fin, "%s", buffer);

    pos = (char**)calloc(*total, sizeof(char*)); //uses dynamic arrays

    for(x = 0; x < *total; x++) {

        fscanf(fin, "%s", buffer);
        pos[x] = (char*)calloc(strlen(buffer) + 1, sizeof(char));
        strcpy(pos[x], buffer);
    }

    return pos;
}

char * randomWord(char **pos, int total) { //grabs a random word from array

    int temp = 0;

    temp = rand() % total;

    return pos[temp];
}

void sentenceGen(char **articles, int totalArts, char **nouns, int totalNouns, char **verbs, int totalVerbs, char **prepositions, int totalPreps, char **sentence) {
//generates sentences from the PoS arrays
    char *word1 = NULL;
    char *word2 = NULL;
    char *word3 = NULL;
    char *word4 = NULL;
    char *word5 = NULL;

    word1 = randomWord(nouns, totalNouns);
    sentence[0] = word1;
    word2 = randomWord(verbs, totalVerbs);
    sentence[1] = word2;
    word3 = randomWord(prepositions, totalPreps);
    sentence[2] = word3;
    word4 = randomWord(articles, totalArts);
    sentence[3] = word4;
    word5 = randomWord(nouns, totalNouns);
    sentence[4] = word5;
}

void printWords(char **pos, int total) { //prints all the words in an array

    int x = 0;

    for (x = 0; x < total; x++) {

        if (x == total - 1)
            printf("%s\n", pos[x]);
        else
            printf("%s ", pos[x]);
    }
}

void addMenu(char ***articles, int *totalArts, char ***nouns, int *totalNouns, char ***verbs, int *totalVerbs, char ***prepositions, int *totalPreps){
//menu to add words
    int choice = 0;

    do {

        printf("Add a word to:\n1)Articles\n2)Nouns\n3)Verbs\n4)Prepositions\nChoice --> ");

        scanf("%d", &choice);
        printf("\n");

        switch(choice) {

            case 1: add(articles, totalArts);
                    break;

            case 2: add(nouns, totalNouns);
                    break;

            case 3: add(verbs, totalVerbs);
                    break;

            case 4: add(prepositions, totalPreps);
                    break;

            default: printf("That is not a valid menu choice.\n\n");
                     break;
        }
    } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
}

void add(char ***pos, int *total) { //code for adding words

    char buffer[100];
    char **tempAra = NULL;
    int x = 0;

    tempAra = (char**)calloc(*total + 1, sizeof(char*));
    //creates a new array 1 size larger

    for(x = 0; x < (*total); x++) { //copy old array

        sscanf((*pos)[x], "%s", buffer);
        tempAra[x] = (char*)calloc(strlen(buffer) + 1, sizeof(char));
        strcpy(tempAra[x], buffer);
    }

    cleanUp(*pos, *total); //clean up old array

    (*total)++;

    *pos = tempAra; //assign pointer to new array

    printf("What word would you like to add: ");

    scanf("%s", buffer);
    while(fgetc(stdin) != '\n');
    printf("\n");

    (*pos)[(*total) - 1] = (char*)calloc(strlen(buffer) + 1, sizeof(char));
    strcpy((*pos)[(*total) - 1], buffer); //new value into new array
}

void sortWords(char **articles, int totalArts, char **nouns, int totalNouns, char **verbs, int totalVerbs, char **prepositions, int totalPreps, char ***sortedWords) {

    int total = totalArts + totalNouns + totalVerbs + totalPreps;
    int index = 0;
    int x = 0;

    *sortedWords = (char**)calloc(total, sizeof(char*));
    //creates one big array of words

    addWords(articles, totalArts, &index, *sortedWords);
    addWords(nouns, totalNouns, &index, *sortedWords);
    addWords(verbs, totalVerbs, &index, *sortedWords);
    addWords(prepositions, totalPreps, &index, *sortedWords);

    quickSort(*sortedWords, 0, total - 1); //sorts using quicksort algorithm

    for (x = 0; x < total; x++) {

        if (x == total - 1)
            printf("%s\n\n", (*sortedWords)[x]);
        else
            printf("%s ", (*sortedWords)[x]);
    }
}

void quickSort(char **sortedWords, int left, int right) {

    int pivot_index = 0;

    if(left >= right)
        return;

    pivot_index = part(sortedWords, left, right);
    quickSort(sortedWords, left, pivot_index - 1);
    quickSort(sortedWords, pivot_index + 1, right);
}

int part(char **sortedWords, int left, int right) {

    char *pivot = sortedWords[right];
    int index = left;
    int x = 0;
    char *temp = NULL;

    for(x = left; x <= right - 1; x++) {

        if(strcmp(sortedWords[x], pivot) <= 0) {

            temp = sortedWords[index];
            sortedWords[index] = sortedWords[x];
            sortedWords[x] = temp;
            index++;
        }
    }
    temp = sortedWords[index];
    sortedWords[index] = sortedWords[right];
    sortedWords[right] = temp;
    return index;
}

void addWords(char **pos, int total, int * index, char **sortedWords) {
//adds words to sortedWords array
    int x = 0;
    int startingIndex = *index;

    for(x = 0; x < total; x++) {

        sortedWords[x + startingIndex] = pos[x];
        (*index)++;
    }
}

void cleanUp(char **pos, int total) { //frees each dynamic element of
                                      //dynamic array and the array
    int x = 0;

    for (x = 0; x < total; x++) {

        free(pos[x]);
    }

    free(pos);
}

