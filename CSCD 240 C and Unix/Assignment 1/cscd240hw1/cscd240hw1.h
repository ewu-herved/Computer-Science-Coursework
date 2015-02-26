//Dan Herve
//CSCD 300 Assignment 1

#ifndef CSCD240HW1_H_INCLUDED
#define CSCD240HW1_H_INCLUDED

#include <stdlib.h>
#include <stdio.h>
#include "FileUtil.h"

void control(FILE * input, int *, FILE *, int);

void survey(FILE * input, int [][10], int [][10]);

void process(int [][10], int [][10], int []);

void project(FILE *, int [][10], int);


#endif //CSCD240HW1_H
