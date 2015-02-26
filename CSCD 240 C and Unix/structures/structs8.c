#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
	char *street;
}address;

typedef struct
{
	char *name;
	int id;	
    address *add;

}student;

student readInfo();
void printStudent(student person);

int main()
{
	int x;
	student *array;
	array = (student *)calloc(1, sizeof(student));
	
	array[0].add = (address *)calloc(1, sizeof(address));
	
	array[0] = readInfo();
	
	printf("\nStudent0:\n");
	printStudent(array[0]); 
	
	for(x=0; x < 1; x++)
	{
		if(array[x].name != NULL)
		{
			free(array[x].name);
			array[x].name = NULL;
		}
	
		if(array[x].add->street != NULL)
		{
			free(array[x].add->street);
			array[x].add->street = NULL;
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
	person.name = (char *)calloc(strlen(temp)+1, sizeof(char));
	strcpy(person.name, temp);
	
	printf("Please enter the id ");
	scanf("%d", &person.id);
	getchar();
	
	printf("Please enter the street ");
	fgets(temp, 100, stdin);
	person.add[0].street = (char *)calloc(strlen(temp), sizeof(char));
	strcpy(person.add[0].street, temp);
	
	return person;
}

void printStudent(student person)
{
	printf("Name: %s\nID: %d\nAddress:%s\n", person.name, person.id, person.add[0].street);
}
