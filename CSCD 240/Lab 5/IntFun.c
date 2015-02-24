//Dan Herve
//Lab 5: Whirlwind C

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

   int main() {

      int num = 0;

      double num2 = 0.0;

      int choice = 0;

      int length = 0;

      int i = 0;

      double d = 0;

      double e = 1;

      double factorial = 1;

      int digits = 0;

      int tracker = 0;

      int evens = 0;

      int odds = 0;

      int zeros = 0;

      printf("Welcome to Integer Fun");

      printf("\nPlease enter a non-negative integer: ");

      scanf( "%d", &num );

      printf("\n");

      while (num < 0) {

         printf("\nI am sorry that is not a non-negative integer.\nPlease enter a non-negative integer: ");

         scanf( "%d", num );
      }

      while (choice != 5) {

         printf("Please select from the following menu choices:\n\n   1. Enter a new number\n   2. Print the number of odd, even and zero digits in the integer\n   3. Print the prime numbers between 2 and the integer\n   4. Print the value of e up to the number specified\n   5. Quit the program\n");

         printf("Choice--> ");

         scanf( "%d", &choice );

         switch (choice) {

            case 1: printf("Enter a new number: ");
                    scanf( "%d", &num );
                    break;

            case 2: tracker = num;

                    while (tracker != 0) {

                       digits++;
                       tracker = tracker / 10;
                    }

                    tracker = num;

                    for (i = 0; i < digits; i++) {

                       if (tracker % 10 == 0)
                          zeros ++;
                       else if (tracker % 10 % 2 == 1)
                          odds++;
                       else
                          evens++;

                       tracker = tracker / 10;
                    }

                    printf("\nThe results for %d are:\nOdd - %d\nEven - %d\nZero(s) - %d\n", num, odds, evens, zeros);
                    break;

            case 3: printf("\nThe Prime numbers between 2 and %d are\n", num);

                    num2 = num;

                    if (num < 2) {

                        printf("%d does not meet the criteria of this operation.", num);
                        break;
                    }

                    if (num >= 2)
                        printf("2\n");

                    for (i = 3; i < num; i++) {

                       for(d=2; d<=sqrt(num) + 1; d++){

                            if(fmod(i, d) == 0 && i != d)
                                break;

                            else if (d >= sqrt(num))
                                printf("%.0d\n", i);
                        }
                    }

                    printf("\n\n");
                    break;

            case 4: printf("The values of e up to %d are:\n", num);

                    for (i = 1; i <= num; i++) {

                        factorial *= i;

                        e += 1 / factorial;

                        printf("%d: %.16lf\n",i, e);
                    }

                    factorial = 1;

                    e = 1;

                    break;

            case 5: printf("\nThank you and have a nice day.");
                    break;

            default: printf("\nI am sorry that is an invalid menu choice.\nPlease try again\n");
                     getchar();
         }
      }
   }
