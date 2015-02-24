#ifndef CSCD240HW2_H_INCLUDED
#define CSCD240HW2_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "FileUtil.h"

char ** fillArray(FILE *fin, int *total);

void sentenceGen(char **articles, int totalArts, char **nouns, int totalNouns, char **verbs, int totalVerbs, char **prepositions, int totalPreps, char **sentence);

void printWords(char **pos, int total);

void addMenu(char ***articles, int *totalArts, char ***nouns, int *totalNouns, char ***verbs, int *totalVerbs, char ***prepositions, int *totalPreps);

void add(char ***pos, int *total);

void sortWords(char **articles, int totalArts, char **nouns, int totalNouns, char **verbs, int totalVerbs, char **prepositions, int totalPreps, char ***sortedWords);

void quickSort(char **sortedWords, int left, int right);

int part(char **sortedWords, int left, int right);

void addWords(char **pos, int total, int * index, char **sortedWords);

void cleanUp(char **pos, int total);

#endif // CSCD240HW2_H_INCLUDED
