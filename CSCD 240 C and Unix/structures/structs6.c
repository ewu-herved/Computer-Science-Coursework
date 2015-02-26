#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct address
{
	char *street;
};

struct student
{
	char *name;
	int id;
	struct address add;
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

	if(stu1.add.street != NULL)
	{
		free(stu1.add.street);
		stu1.add.street = NULL;
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

	printf("Please enter the id ");
	scanf("%d", &person -> id);
	getchar();

	printf("Please enter the street ");
	fgets(temp, 100, stdin);
	person->add.street = (char *)calloc(strlen(temp), sizeof(char));
	strcpy(person->add.street, temp);

}

void printStudent(struct student person)
{
	printf("Name: %s\nID: %d\nAddress:%s\n", person.name, person.id, person.add.street);
}
