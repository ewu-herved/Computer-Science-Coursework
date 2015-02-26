//Dan Herve
//CSCD 240: HW3

#include "hw3.h"

int main()
{
	int total, choice;
	FILE * fin = NULL;
	LinkedList * myList = linkedList();

	fin = openInputFile();
	total = countRecords(fin, 3);
	buildList(myList, fin, total);

	do
	{
		choice = menu();

		if(choice == 1)
			printStockValue(myList);

		else if(choice == 2)
			buyStock(myList, &total);

		else if(choice == 3)
			sellStock(myList, &total);

		else if(choice == 4)
			printStockInfo(myList);

	}while(choice != 5);

	cleanUp(myList);
	free(myList);
	fclose(fin);
	myList = NULL;

	return 0;

}// end main

