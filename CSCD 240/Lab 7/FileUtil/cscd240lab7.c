#include "FileUtil.h"

int main()
{
    char buffer[MAX];

    FILE *file1 = NULL;
    FILE *file2 = NULL;

    file1 = promptOpenInputFile();

    file2 = promptOpenOutputFile();

    while(fgets(buffer, MAX, file1) != NULL) {

        fputs(buffer, file2);
    }

    fclose(file1);
    fclose(file2);

    return 0;
}
