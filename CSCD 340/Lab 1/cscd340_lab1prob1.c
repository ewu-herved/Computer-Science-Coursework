#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x = 12;
	double val = 4.9567;
	double *dptr = &val;
	int array[] = {10,20,30,40,50,60};
	double val2 = 3.14159;
	int y = 99;
	double * dptr2 = &val2;
	int *ptr2 = &y;
	char *word = (char*)calloc(10, sizeof(char));
	int *ptr = &x;


	printf("x: %p\nptr: %p\nval: %p\ndptr: %p\narray: %p\narray[5]: %p\nval2: %p\ny:%p\ndptr2: %p\nptr2: %p\nword: %p\n", &x, &ptr, &val, &dptr, &array[0], &array[5], &val2, &y, &dptr2, &ptr2, &word);
	printf("word: %p\n", word);

	return 0;

}// end main



/*
NOTE this must be completed on cslinux.eastern.ewu.edu

a) Does the stack grow up or down?  How do you know? Justify your answer.

b) What version of GCC are you using?

c) What version of Linux are you using?

d) What is odd about how memory is arranged compared to the declarations?

e) Run the program twice and each time construct a memory map.

f) Did the addresses change between runs? Why or why not? Justify your answer.

g) How many bytes are allocated by the calloc?

h) How many bytes are leaked? Provide the valgrind output below.

*/