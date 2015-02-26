//Dan Herve
//Assignment 4: Array Traversal and Exception Handling
//No known shortcomings

import java.util.*;

public class MeanMedian {

   static Scanner input = new Scanner(System.in);
   
   static int num;
   
   static int[] intAra = new int[0]; 
         

   public static void main(String[] args) {      
      
      System.out.println("Welcome to Integer Array Fun");
      
      num = enterInt(); 
      
      menu();     
      
   }   
   
   public static int enterInt() { //method takes an integer from user  

      boolean continueInput = true; 
      
      do {      
      
         try {
         
            System.out.print("\nPlease enter a non-negative integer: ");
      
            num = input.nextInt();
      
            intAra = toAra(num); //create an array from the integer
      
            System.out.println();          
      
            while (num < 0) {

               System.out.print("I am sorry, that is not a non-negative integer.\n\nPlease enter a non-negative integer: ");

               num = input.nextInt();         
            }
         
            continueInput = false;
         }      
      
         catch(InputMismatchException ex) {
      
            System.out.println("\nI am sorry, that is not a non-negative integer.");

            input.nextLine();
            
            
         }      
      } while (continueInput);
      return num;
      
   }
   
   public static void menu() { //method creates a menu of choices     
      
      int choice = 0;
      
      boolean continueInput = true;
      
      do {
      
         try {
   
            while (choice != 6) {
      
               System.out.println("Please select from the following menu choices:\n\n" +
               "   1. Add a number to the array" +
               "\n   2. Display the mean" +
               "\n   3. Display the median" +
               "\n   4. Print the array to the screen" +
               "\n   5. Print the array in reverse order" +
               "\n   6. Quit the program\n");
         
               System.out.print("Choice--> ");
         
               choice = input.nextInt();
         
               switch (choice) {
         
                  case 1: enterInt();
                          break;
            
                  case 2: findMean(intAra);
                          break;
            
                  case 3: findMedian(intAra);
                          break;
                    
                  case 4: printAra(intAra);
                          break;
            
                  case 5: reverseAra(intAra);
                          break; 
                  
                  case 6: System.out.println("\nThank you and have a nice day.");
                          break;
            
                  default: System.out.println("\nI am sorry, that is an invalid menu choice." +
                  "\nPlease try again\n");
               }
            }   
            
            continueInput = false;
         }
         
         catch(InputMismatchException ex) {
      
            System.out.println("\nI am sorry, that is not valid menu choice.\n");

            input.nextLine();            
         }      
      } while (continueInput); 
         
   }
   
   public static int[] toAra(int num) { //adds an int input to an array      
      
      int[] ints = new int[intAra.length + 1];
      
      for (int i = 0; i < ints.length; i++) {
      
         if (i == ints.length - 1) 
            ints[i] = num;
         else
            ints[i] = intAra[i];
      }
            
      return ints;      
   }
   
   public static void printAra(int[] intAra) { //prints the numbers input by the user as an array
   
      System.out.println("\n" + Arrays.toString(intAra) + "\n");
   }
   
   public static void findMean(int[] intAra) { //Calculates the mean of the array of numbers
   
      int count = 0;
      
      int sum = 0;
   
      for (int i = 0; i < intAra.length; i++) {
      
         count++;         
         
         sum += intAra[i];
      }
      
      double mean = (double) sum / count;
      
      System.out.println("\nThe mean of the array is " + mean + "\n");
   }
   
   public static void findMedian(int[] intAra) { //Calculates the median of the array of numbers
   
      int[] sortedAra = intAra.clone(); 
      
      SortSearchUtil.sortSelection(sortedAra); //sorts the array
      
      if (sortedAra.length % 2 == 0) {
         int[] median = {sortedAra[(sortedAra.length / 2) - 1], sortedAra[sortedAra.length / 2]};
         System.out.println("\nThe median of the array is " + Arrays.toString(median));
      }
      else {
         int median = sortedAra[sortedAra.length / 2];
         System.out.println("\nThe median of the array is " + median); 
      }
      
      System.out.println();
   }
   
   public static void reverseAra(int[] intAra) { //reverses the order of the array
   
      int[] reverseAra = intAra.clone();
   
      for (int i = 0; i < (reverseAra.length / 2); i++) {
      
         int temp = reverseAra[i];
         
         int reciprocal = reverseAra.length - (i + 1);
         
         reverseAra[i] = reverseAra[reciprocal];
         
         reverseAra[reciprocal] = temp;
      }
            
      System.out.println("\nThe array sorted in reverse order is: " +
      Arrays.toString(reverseAra) + "\n");
   }
}