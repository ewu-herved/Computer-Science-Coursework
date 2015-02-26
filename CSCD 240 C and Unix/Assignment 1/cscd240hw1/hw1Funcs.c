//Dan Herve
//CSCD 300 Assignment 1

#include "cscd240hw1.h"

void control(FILE * input, int *D, FILE * output, int solution) {

   int x = 0;

   for (x = 0; x < 16; x++) {

      fscanf(input, "%i", &D[x]);
   }

   fprintf(output, "Solution: %i\n\n", solution + 1);

   for(x = 0; x < 16; x++) {

         fprintf(output, "%i ", D[x]);
      }

      fprintf(output, "\n\n");
}

void survey(FILE * input, int dish[][10], int curDish[][10]) {

   int x = 0;

   int y = 0;

   int temp = 0;

   for (x = 0; x < 10; x++) {

      for (y = 0; y < 10; y++) {

         fscanf(input, "%i", &temp);
         dish[x][y] = temp;
         curDish[x][y] = temp;
      }
   }
}

void process(int dish[][10], int curDish[][10], int *D) {

    int K = 0;
    int x = 0;
    int y = 0;

    for (y = 0; y < 10; y++) {

      for (x = 0; x < 10; x++) {

         K += dish[y][x];

         if (y - 1 >= 0) {

            K += dish[y - 1][x];
         }

         if (y + 1 < 10) {

            K += dish[y + 1][x];
         }

         if (x - 1 >= 0) {

            K += dish[y][x - 1];
         }

         if (x + 1 < 10) {

            K += dish[y][x + 1];
         }

         curDish[y][x] += D[K];

         if (curDish[y][x] > 3) {

            curDish[y][x] = 3;
         }

         else if (curDish[y][x] < 0) {

            curDish[y][x] = 0;
         }

         K = 0;
      }
   }

   for (y = 0; y < 10; y++) {

      for (x = 0; x < 10; x++) {

         dish[y][x] = curDish[y][x];
      }
   }
}

void project(FILE * output, int dish[][10], int day) {

   int x = 0;
   int y = 0;
   char sym = ' ';

   fprintf(output, "Generation: %i\n\n", day);

   for(y = 0; y < 10; y++) {

      for(x = 0; x < 10; x++) {

         if (dish[y][x] == 3) {

            sym = '#';
         }

         else if (dish[y][x] == 2) {

            sym = 'X';
         }

         else if (dish[y][x] == 1) {

            sym = '!';
         }

         else {

            sym = '.';
         }

         fprintf(output, "%c ", sym);
      }

      fprintf(output, "\n");
   }

   fprintf(output, "\n");
}
