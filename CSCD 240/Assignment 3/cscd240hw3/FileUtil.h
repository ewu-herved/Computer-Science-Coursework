#ifndef FILEUTIL_H_INCLUDED
#define FILEUTIL_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>

#define MAX 512

FILE * openFile(char array[]);

FILE * openInputFile();

FILE * openOutputFile(char array[]);

FILE * promptOpenOutputFile();

#endif // FILEUTIL_H_INCLUDED
