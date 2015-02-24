#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct address
{
	char *street;
};

typedef struct
{
	char *name;
	int id;
	struct address add;
}student;

student readInfo();
void printStudent(student person);

int main()
{
	int x;
	student *array;
	array = (student *)calloc(2, sizeof(student));

	array[0] = readInfo();
	array[1] = readInfo();

	printf("\nStudent0:\n");
	printStudent(array[0]);

	printf("\nStudent 1:\n");
	printStudent(array[1]);

	for(x=0; x < 2; x++)
	{
		if(array[x].name != NULL)
		{
			free(array[x].name);
			array[x].name = NULL;
		}

		if(array[x].add.street != NULL)
		{
			free(array[x].add.street);
			array[x].add.street = NULL;
		}
	}

	if(array != NULL)
	{
		free(array);
		array = NULL;
	}
	return 0;
}

student readInfo()
{
	student person;
	char temp[100];
	printf("Please enter the name ");
	fgets(temp, 100, stdin);
	person.name = (char *)calloc(strlen(temp), sizeof(char));
	strcpy(person.name, temp);

	printf("Please enter the id ");
	scanf("%d", &person.id);
	getchar();

	printf("Please enter the street ");
	fgets(temp, 100, stdin);
	person.add.street = (char *)calloc(strlen(temp), sizeof(char));
	strcpy(person.add.street, temp);

	return person;
}

void printStudent(student person)
{
	printf("Name: %s\nID: %d\nAddress:%s\n", person.name, person.id, person.add.street);
}
