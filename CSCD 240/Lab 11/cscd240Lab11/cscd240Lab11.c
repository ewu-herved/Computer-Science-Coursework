#include "lab11.h"

int main()
{
    FILE * fin = NULL;
    int total, choice;
    Address * array = NULL;

    fin = openFile();

    array = fillArray(&total, fin);

    fclose(fin);
    fin = NULL;

    do
	{
		choice = menu();
		switch(choice)
		{
			case 1:	qsort(array, total, sizeof(Address), compareStreet);
					printArray(array, total);
					break;

			case 2: qsort(array, total, sizeof(Address), compareCityZip);
					printArray(array, total);
					break;

			case 3: qsort(array, total, sizeof(Address), compareStateCityZip);
                    printArray(array, total);
					break;

			case 4:	qsort(array, total, sizeof(Address), compareZip);
                    printArray(array, total);
					break;

			case 5:	printf("all done\n");

		}// end switch

	}while(choice != 5);

	cleanUp(array, total);
	array = NULL;

    return 0;

}// end main
