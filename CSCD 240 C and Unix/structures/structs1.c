#include <stdio.h>

struct date
{
	int month;
	int day;
	int year;
};

int main()
{
	struct date today;

	today.month = 11;
	today.year = 2013;


	printf("Please enter the day ");
	scanf("%d", &today.day);

	printf("The date is: %d/%d/%d\n", today.month, today.day, today.year);

	return 0;
}
