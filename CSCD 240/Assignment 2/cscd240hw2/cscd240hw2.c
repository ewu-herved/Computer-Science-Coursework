//Dan Herve
//CSCD 240: Assignment 2

#include "cscd240hw2.h"

int main() {

    FILE *fin = NULL; //file needs to have parts of speech in order:
                      //articles, nouns, verbs, prepositions and the
                      //first line of each should have format: # PoS
    char **articles = NULL; //array of articles read from file
    int totalArts = 0;
    char **nouns = NULL; //array of nouns
    int totalNouns = 0;
    char **verbs = NULL; //array of verbs
    int totalVerbs = 0;
    char **prepositions = NULL; //array of prepositions
    int totalPreps = 0;
    char *sentence[5]; //array for random sentences
    char **sortedWords = NULL; //array for sorted words; stores pointers
    int choice = 0;

    printf("Welcome to the Random Sentence Generator\n\n");

    fin = promptOpenInputFile();

    srand(time(0)); //for sentence generator

    articles = fillArray(fin, &totalArts); //reads words from file
    nouns = fillArray(fin, &totalNouns);
    verbs = fillArray(fin, &totalVerbs);
    prepositions = fillArray(fin, &totalPreps);

    printf("Processed:\n%d Articles\n%d Nouns\n%d Verbs\n%d Prepositions\n\n", totalArts, totalNouns, totalVerbs, totalPreps);

    do {

        printf("Please choose from the following:\n1)Generate a Sentence\n2)Display all words\n3)Add a word\n4)Display all words sorted\n5)Exit the program\nChoice --> ");

        scanf("%d", &choice);
        printf("\n");

        switch(choice) {

            case 1: sentenceGen(articles, totalArts, nouns, totalNouns, verbs, totalVerbs, prepositions, totalPreps, sentence);
                    printWords(sentence, 5);
                    printf("\n");
                    break;

            case 2: printf("Articles: ");
                    printWords(articles, totalArts);
                    printf("Nouns: ");
                    printWords(nouns, totalNouns);
                    printf("Verbs: ");
                    printWords(verbs, totalVerbs);
                    printf("Prepositions: ");
                    printWords(prepositions, totalPreps);
                    printf("\n");
                    break;

            case 3: addMenu(&articles, &totalArts, &nouns, &totalNouns, &verbs, &totalVerbs, &prepositions, &totalPreps);
                    break;

            case 4: sortWords(articles, totalArts, nouns, totalNouns, verbs, totalVerbs, prepositions, totalPreps, &sortedWords);
                    break;

            case 5: printf("Have a nice day!\n");
                    break;

            default: printf("That is not a valid menu choice.\n\n");

        }

    } while(choice != 5);

    cleanUp(articles, totalArts); //cleanup dynamic arrays
    cleanUp(nouns, totalNouns);
    cleanUp(verbs, totalVerbs);
    cleanUp(prepositions, totalPreps);
    free(sortedWords); //an array of pointers; only the array needs cleaning
    fclose(fin);

    return 0;
}
