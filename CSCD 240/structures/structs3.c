#include <stdio.h>
#include <string.h>

struct student
{
	char name[100];
	int id;
};

void readInfo2(struct student *person);

int main()
{
	struct student stu1;

	readInfo2(&stu1);

	printf("\nStudent1:\nName: %s\nID: %d\n", stu1.name, stu1.id);


	return 0;
}

void readInfo2(struct student *person)
{
	strcpy(person->name, "Person 1");
	(*person).id = 666;
}
