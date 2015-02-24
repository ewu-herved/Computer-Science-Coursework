//Dan Herve
//Assignment 6: Linked Lists
//Extra Credit Completed

import java.util.*;

public class ListTester { //driver class

   private static ListReferenceBased myList; //public member variables
   
   private static ListReferenceBased evenList;

   public static void main(String[] args) { //main
   
      menu();
   }
   
   private static void menu() { //primary menu
   
      Scanner input = new Scanner(System.in);
   
      boolean continueInput = true;
      
      int choice = 0;
      
      System.out.println("Welcome to LinkList Fun!\n");
   
      do {
      
         try {               
            
            System.out.print("Please select an option:\n1. Create a new list\n2. Sort the list\n3. Print the list\n" +
                             "4. Print the list in reverse\n5. Create an even sublist and display it\n" +
                             "6. Print the members of a given interval\n7. Delete list element\n8. Delete the list\n" +
                             "9. Quit\n\nChoice: ");
                                  
            choice = input.nextInt();
               
            switch (choice) {
               
               case 1: makeList();
                       break;
                         
               case 2: sortList();
                       break;
                       
               case 3: printList();
                       break;       
                  
               case 4: reversePrintList();
                       break;
                      
               case 5: evenListPrint();
                       break;
                  
               case 6: nthNum();
                       break;
                  
               case 7: deleteItem();
                       break;
                  
               case 8: deleteList();
                       break;
                  
               case 9: System.out.println("Have a nice day!");
                       break;
            }
               
            if (choice > 9 || choice < 1) {
               
               throw new InputMismatchException();
            }   
         }        
         
         catch (InputMismatchException e){
         
            System.out.println("\nThat is not a valid menu option. Please select an option.\n");
         }
      } while(continueInput && choice != 9);
   
   }
   
   private static void makeList() { //creates a list of random numbers between 0 and 999
   
      Scanner input = new Scanner(System.in);
   
      myList = new ListReferenceBased();
      
      Random generator = new Random();
      
      int size = 0;
      
      boolean validInput = false;
      
      do {
      
         try {
      
            System.out.print("How many items should the list have?\n\nNumber of items: ");
      
            size = input.nextInt();
         
            if (size < 1) {
         
               throw new InputMismatchException("That is not a valid choice");
            }
         
            validInput = true;         
         }
      
         catch (InputMismatchException e) {
      
            System.out.println("That is not a valid choice.\n");
            
            input.nextLine();
         } 
      } while (validInput == false);
      
      while(myList.getSize() < size) {
      
         myList.addNode((Integer) generator.nextInt(1000));
      }
   }
   
   private static void nthNum() { //prints the elements of the list with a given divisor
   
      Scanner input = new Scanner(System.in);
   
      boolean validInput = false;
      
      int interval = 0;
      
      if (myList == null || myList.getHead() == null) {
      
         System.out.println("\nThere is currently no list.\n");
      }
      
      else {
      
         do {
      
            try {
      
               System.out.print("Indicate the interval you would you like to print: ");
      
               interval = input.nextInt();
         
               if (interval < 1) {
         
                  throw new InputMismatchException("That is not a valid choice");
               }
         
               validInput = true;         
            }
      
            catch (InputMismatchException e) {
      
               System.out.println("That is not a valid choice.\n");
            
               input.nextLine();
            } 
         } while (validInput == false);
      
         System.out.println(myList.toString(interval));
      }
   }
   
   private static void deleteItem() { // deletes an item from the list
   
      Scanner input = new Scanner(System.in);
   
      boolean validInput = false;
      
      Integer element = 0;
      
      if (myList == null || myList.getHead() == null) {
      
         System.out.println("\nThere is currently no list.\n");
      }
      
      else {
      
         do {
      
            try {
      
               System.out.print("\nIndicate the element you would like to remove: ");
      
               element = input.nextInt();
         
               validInput = true;         
            }
      
            catch (InputMismatchException e) {
      
               System.out.println("That is not a valid choice.\n");
            
               input.nextLine();
            } 
         } while (validInput == false);
      
         myList.removeNode(element);
      }
   }
   
   private static void printList() { //prints the list
   
      if (myList == null || myList.getHead() == null) {
      
         System.out.println("\nThere is currently no list.\n");
      }
      
      else {
      
         System.out.println(myList.toString());
      }
   }
   
   private static void reversePrintList() { //prints the list in reverse
   
      if (myList == null || myList.getHead() == null) {
      
         System.out.println("\nThere is currently no list.\n");
      }
      
      else {
      
         System.out.println(myList.reversePrint());
      }
   }
   
   private static void evenListPrint() { //creates a sublist of the even list elements and prints it
   
      if (myList == null || myList.getHead() == null) {
      
         System.out.println("\nThere is currently no list.\n");
      }
      
      else {
         
         evenList = myList.evenList();
         
         System.out.println(evenList.toString());
      }
   }
   
   private static void sortList() { //sorts the list in ascending order
   
      if (myList == null || myList.getHead() == null) {
      
         System.out.println("\nThere is currently no list.\n");
      }
      
      else {
      
         myList.sortSelection();
      }
   }
   
   private static void deleteList() { //deletes the whole list
   
      if (myList == null || myList.getHead() == null) {
      
         System.out.println("\nThere is currently no list.\n");
      }
      
      else {
      
         myList.removeAll();
      }
   }                     
}