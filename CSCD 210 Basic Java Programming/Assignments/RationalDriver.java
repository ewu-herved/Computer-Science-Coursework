//Dan Herve
//Assignment 6: Rational Numbers
//No known shortcomings

import java.util.*;

public class RationalDriver {
   
   public static void main(String[] args) { //Creates the scanner, an array, and calls the menu
   
      Scanner input = new Scanner(System.in);

      Rational[] ratAra = {new Rational(2, 3), new Rational(2, 18), new Rational(3, 12),
      new Rational(9, 3), new Rational(2, 5), new Rational(22, 7)};
      
      menu(input, ratAra);
   }
   
   public static void menu(Scanner input, Rational[] ratAra) { //method creates a menu of choices     
      
      int choice = 0;
      
      boolean continueInput = true;
      
      do {
      
         try {
   
            while (choice != 7) {
      
               System.out.println("Please select from the following menu choices:\n\n" +
               "   1. Display the value of a rational number" +
               "\n   2. Change the value of a stored rational number" +
               "\n   3. Show the sum of two rational numbers" +
               "\n   4. Show the difference of two rational numbers" +
               "\n   5. Sort the stored rational numbers by value" +
               "\n   6. Print the stored rational numbers to the screen" +
               "\n   7. Quit the program\n");
         
               System.out.print("Choice--> ");
         
               choice = input.nextInt();
         
               switch (choice) {
         
                  case 1: showRat(input, ratAra);
                          break;
            
                  case 2: changeRat(input, ratAra);
                          break;
            
                  case 3: addRats(input, ratAra);
                          break;
                    
                  case 4: subRats(input, ratAra);
                          break;
            
                  case 5: sortRats(ratAra);
                          break;
                          
                  case 6: System.out.println("\n" + Arrays.toString(ratAra) + "\n");
                          break; 
                  
                  case 7: System.out.println("\nThank you and have a nice day.");
                          break;
            
                  default: System.out.println("\nI am sorry, that is an invalid menu choice." +
                  "\nPlease try again\n");
               }
            }   
            
            continueInput = false;
         }
         
         catch(InputMismatchException ex) { //makes sure the input is of the correct type
      
            System.out.println("\nI am sorry, that is not valid menu choice.\n");

            input.nextLine();            
         }      
      } while (continueInput);          
   }
   
   public static void showRat(Scanner input, Rational[] ratAra) { //shows a Rational at an index
   
      boolean continueinput = true;
      
      do {
      
         try {
      
            System.out.print("\nPlease select an index value between 0 and 5: ");
      
            int choice = input.nextInt();
      
            System.out.println("\nThe rational at index " + choice + " is " + 
            ratAra[choice].toString() + "\n");
            
            continueinput = false;
         }
         
         catch(InputMismatchException ex) { //checks for correct input type
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }
         
         catch(ArrayIndexOutOfBoundsException ex) { //makes sure the selection exists
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }  
      } while (continueinput);
   }
   
   public static void changeRat(Scanner input, Rational[] ratAra) { //Replaces a Rational at an index
   
      boolean continueinput = true;
      
      do {
      
         try {
      
            System.out.print("\nPlease select an index value between 0 and 5 to change: ");
      
            int choice = input.nextInt();
      
            if (choice >= 0 && choice < 6) {
            
               System.out.print("\nEnter a new numerator and denomenator for the new rational " +
               "number.\n\nNumerator: ");
            
               int newNum = input.nextInt();
            
               System.out.print("\nDenomenator: ");
            
               int newDen = input.nextInt();
            
               Rational newRat = new Rational(newNum, newDen);
            
               ratAra[choice] = newRat;
            
               System.out.println("\nThe rational at index " + choice + " is now " + 
               newRat + "\n");
            
               continueinput = false;
            }
            
            else 
            
               System.out.println("\nI am sorry, that is not valid index choice.");   
         }
         
         catch(InputMismatchException ex) { //same as above
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }
         
         catch(ArrayIndexOutOfBoundsException ex) { //same as above
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }  
      } while (continueinput);
   }
   
   public static void addRats(Scanner input, Rational[] ratAra) { //Adds two existing Rationals together
   
      boolean continueinput = true;
      
      do {
      
         try {
            
            System.out.print("\nPlease select an index value between 0 and 5 for the first number: ");
      
            Rational rat1 = ratAra[input.nextInt()];
            
            System.out.print("\nPlease select an index value between 0 and 5 for the second number: ");            
            
            Rational rat2 = ratAra[input.nextInt()];
            
            if (rat2 != rat1) {
            
               System.out.println("\nThe sum of these rational numbers is: " + Rational.addRational(rat1, rat2) + "\n");
                        
               continueinput = false;
            }
            
            else {
            
               System.out.println("\nPlease select an index other than the one you have already chosen.");
            }
         }
                     
         catch(InputMismatchException ex) { 
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }
         
         catch(ArrayIndexOutOfBoundsException ex) { 
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }  
      } while (continueinput);
   }
   
   public static void subRats(Scanner input, Rational[] ratAra) { //Subtracts two existing rationals
   
      boolean continueinput = true;
      
      do {
      
         try {
            
            System.out.print("\nPlease select an index value between 0 and 5 for the first number: ");
      
            Rational rat1 = ratAra[input.nextInt()];
            
            System.out.print("\nPlease select an index value between 0 and 5 for the second number: ");            
            
            Rational rat2 = ratAra[input.nextInt()];
            
            if (rat2 != rat1) {
            
               System.out.println("\nThe sum of these rational numbers is: " + Rational.subRational(rat1, rat2) + "\n");
                        
               continueinput = false;
            }
            
            else {
            
               System.out.println("\nPlease select an index other than the one you have already chosen.");
            }
         }
                     
         catch(InputMismatchException ex) { 
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }
         
         catch(ArrayIndexOutOfBoundsException ex) { 
         
            System.out.println("\nI am sorry, that is not valid index choice.");

            input.nextLine();            
         }  
      } while (continueinput);
   }
   
   public static void sortRats(Rational[] ratAra) { //sorts the array of rationals ascending
   
      SortSearchUtil.sortSelection(ratAra);
      
      System.out.println();
   }
}