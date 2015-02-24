//Dan Herve
//CSCD 300 Assignment 1

#include "cscd240hw1.h"

int main() {

   int solutions = 0;
   int days = 0;
   int dish[10][10];
   int curDish[10][10];
   int D[16];
   int i = 0;
   int x = 0;
   FILE * input = NULL;
   FILE * output = NULL;

   input = promptOpenInputFile();
   output = promptOpenOutputFile();

   fscanf(input, "%i", &solutions);

   for (i = 0; i < solutions; i++) {

      fscanf(input, "%i", &days);

      control(input, D, output, i);

      survey(input, dish, curDish);

      project(output, dish, 0);

      for (x = 0; x < days; x++) {

         process(dish, curDish, D);

         project(output, curDish, x + 1);
      }
   }

   fclose(input);
   fclose(output);

   return 0;
}
