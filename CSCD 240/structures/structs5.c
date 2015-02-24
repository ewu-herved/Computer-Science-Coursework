#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student
{
	char *name;
	int id;
};

void readInfo2(struct student *person);
void printStudent(struct student person);

int main()
{
	struct student stu1;

	readInfo2(&stu1);

	printf("\nStudent1:\n");
	printStudent(stu1);

	if(stu1.name != NULL)
	{
		free(stu1.name);
		stu1.name = NULL;
	}
	return 0;
}

void readInfo2(struct student *person)
{
	char temp[100];
	printf("Please enter the name ");
	fgets(temp, 100, stdin);
	person->name = (char *)calloc(strlen(temp), sizeof(char));
	strncpy(person->name, temp, strlen(temp)-1);
	person->id = 66678;
}

void printStudent(struct student person)
{
	printf("Name: %s\nID: %d\n", person.name, person.id);
}
