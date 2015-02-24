#ifndef FILEUTIL_H_INCLUDED
#define FILEUTIL_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>

#define MAX 512

FILE * openInputFile2(char array[]);

FILE * openInputFile();

FILE * openOutputFile2(char array[]);

FILE * openOutputFile();

#endif // FILEUTIL_H_INCLUDED
