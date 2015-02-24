#include <stdio.h>
#include <string.h>

struct student
{
	char name[100];
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


	return 0;
}

void readInfo2(struct student *person)
{
	strcpy(person	->	name, "Person 1");
	person->id = 66666;
}

void printStudent(struct student person)
{
	printf("Name: %s\nID: %d\n", person.name, person.id);
}
