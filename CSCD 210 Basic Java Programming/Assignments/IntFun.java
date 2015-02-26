//Dan Herve
//Assignment 3: Menu Driven Application
//No known shortcomings; attempted extra credit

import java.util.*;
import java.lang.Math;

public class IntFun {

   static Scanner input = new Scanner(System.in);
   
   static int num;
   
   static int[] digitAra; 
      

   public static void main(String[] args) {
   
      int digits = 0;
      
      num = 435;
      
      int tracker = num;
      
      int odds = 0, evens = 0, zeros = 0;
      
      while (tracker != 0) {

                       digits++;
                       tracker = tracker / 10;
                    }

                    tracker = num;

                    for (int i = 0; i < digits; i++) {

                       if (tracker % 10 == 0)
                          zeros ++;
                       else if (tracker % 10 % 2 == 1)
                          odds++;
                       else
                          evens++;

                       tracker = tracker / 10;
                    }

                    System.out.printf("\nThe results for %d are:\nOdd - %d\nEven - %d\nZero(s) - %d\n", num, odds, evens, zeros);
                    
      
      System.out.println("Welcome to Integer Fun");
      
      num = enterInt(); 
      
      menu();     
      
   }   
   
   public static int enterInt() { //method takes an integer from user  

      System.out.print("\nPlease enter a non-negative integer: ");
      
      num = input.nextInt();
      
      digitAra = toAra(num); //create an array from the integer
      
      System.out.println();
      
      while (num < 0) {

         System.out.print("\nI am sorry that is not a non-negative integer.\nPlease enter a non-negative integer: ");

         num = input.nextInt();         
      }
      
      return num;
   }
   
   public static void menu() { //method creates a menu of choices     
      
      int choice = 0;
   
      while (choice != 5) {
      
         System.out.println("Please select from the following menu choices:\n\n" +
         "   1. Enter a new number" +
         "\n   2. Print the number of odd, even and zero digits in the integer" +
         "\n   3. Print the prime numbers between 2 and the integer" +
         "\n   4. Print the sum of the digits of the integer" +
         "\n   5. Quit the program\n");
         
         System.out.print("Choice--> ");
         
         choice = input.nextInt();
         
         switch (choice) {
         
            case 1: enterInt();
                    break;
            
            case 2: howManyDigits();
                    break;
            
            case 3: printPrimes();
                    break;
                    
            case 4: printSum();
                    break;
            
            case 5: System.out.println("\nThank you and have a nice day.");
                    break;
            
            default: System.out.println("\nI am sorry that is an invalid menu choice." +
            "\nPlease try again\n");
         }
      }
   }
   
   public static int[] toAra(int num) { //converts an int to an array
   
      int digitCount = 0;
      
      int[] digits;
      
      int temp = num;
      
      while (num != 0) {
         
         digitCount++;
         num = num / 10; 
      }
      
      num = temp;
      
      digits = new int[digitCount];
      
      int tracker = num;
      
      for (int i = digitCount - 1; i >= 0; i--) {      
                  
         digits[i] = tracker % 10;
         
         tracker = tracker / 10;
      }
      
      return digits;
   }
   
   public static void howManyDigits() { //method counts evens, odds and zeros in an int  
           
      int evens = 0;
      
      int odds = 0;
      
      int zeros = 0;
      
      for (int i = 0; i < digitAra.length; i++) {
      
         if (digitAra[i] == 0)
            zeros ++;
         else if (digitAra[i] % 2 == 1)
            odds++;
         else
            evens++;
      }      
      
      System.out.println("\nThe results for " + num + " are:\nOdd - " + odds +
      "\nEven - " + evens + "\nZero(s) - " + zeros + "\n");     
   }
   
   public static void printPrimes() { //method finds the primes between 2 and an int
   
      int[] numAra = new int[num - 1];            
      
      for (int i = num; i > 1; i--) {
      
         numAra[i - 2] = i;         
      }
      
      int[] numAraTemp = Arrays.copyOf(numAra, num - 1);
      
      for (int i = 0; i < numAra.length; i++) {
         
         for (int j = i + 1; j < numAra.length; j++) {
         
         if (numAraTemp[j] % numAraTemp[i] == 0)
            numAra[j] = 0;
         
         }
      }
      
      int count = 0; 
      
      for (int i = 0; i < numAra.length; i++) {          
         
         if (numAra[i] != 0) 
            
            count++;
      }     
            
      int[] primeAra = new int[count];
      
      int forCount = 0;
         
      for (int i = 0; i < numAra.length; i++) { 
         
         int temp = 0;         
         
         if (numAra[i] != 0) {
            
            temp = numAra[i];
             
            primeAra[forCount] = temp;
            
            forCount++; 
         }
      } 
            
      System.out.print("\nThe Prime numbers between 2 and " + 
      num + " are ");
      
      for (int i = 0; i < primeAra.length; i++) { 
         
         if (i != primeAra.length - 1) 
            
            System.out.print(primeAra[i] + ", ");
            
            if (i % 10 == 0)
               
               System.out.println(); 
            
         else if (i == primeAra.length - 1)
         
            System.out.println("and " + primeAra[i] + "\n");
      }
   }
   
   public static void printSum() { // method finds the sum of the digits of an int
   
      int sum = 0;
      
      for (int i = 0; i < digitAra.length; i++) {
      
         sum += digitAra[i];
      }
      
      System.out.println("\nThe sum of the digits of " + num + " are: " +
      sum + "\n");   
   }    
}