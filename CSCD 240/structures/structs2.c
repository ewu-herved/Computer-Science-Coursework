#include <stdio.h>
#include <string.h>

struct student
{
	char name[100];
	int id;	
};

struct student readInfo1();
void readInfo2(struct student person);

int main()
{
	struct student stu1, stu2, stu3 = {"catdog", 9875};
	struct student stu4 = {.id = 2222, .name = "Hello"};
	
	stu1 = readInfo1();
	
	readInfo2(stu2);
	
	printf("\nStudent1:\nName: %s\nID: %d\n", stu1.name, stu1.id); 
	printf("\nStudent2:\nName: %s\nID: %d\n", stu2.name, stu2.id); 
	printf("\nStudent3:\nName: %s\nID: %d\n", stu3.name, stu3.id); 
	printf("\nStudent4:\nName: %s\nID: %d\n", stu4.name, stu4.id); 
	
	return 0;
}

struct student readInfo1()
{
	struct student person;
	
	strcpy(person.name, "Stu Steiner");
	
	person.id = 12345;
	
	return person;
}

void readInfo2(struct student person)
{
	strcpy(person.name, "Person 2");
	person.id = 66666;
}
