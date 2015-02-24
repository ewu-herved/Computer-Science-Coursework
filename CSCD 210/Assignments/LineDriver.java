//Dan Herve
//Assignment 7: Line Composition
//No known shortcomings

import java.util.*; //imported for Scanner

public class LineDriver {

   private static Line l1 = new Line(); //member variables
   
   private static Line l2 = new Line();   

   public static void main(String[] args) {
   
   Scanner input = new Scanner(System.in);
   
   menu(input);   
   }
   
   public static void menu(Scanner input) { //menu method for console
   
      int choice = 0;
      
      boolean continueInput = true;
      
      do {
      
         try {
         
            while (choice != 6) {
      
               System.out.println("Please select from the following menu choices:\n\n" +
               "   1. Create line 1" +
               "\n   2. Create line 2" +
               "\n   3. Check if the lines are equivalent" +
               "\n   4. Display the coordinates, length, width, and color of line 1" +
               "\n   5. Display the coordinates, length, width, and color of line 2" +
               "\n   6. Quit the program\n");
         
               System.out.print("Choice--> ");
         
               choice = input.nextInt();
         
               switch (choice) {
         
                  case 1: line1(input);
                          break;
            
                  case 2: line2(input);
                          break;
            
                  case 3: lineEquals();
                          break;
                    
                  case 4: System.out.println(l1.toString());
                          break;
            
                  case 5: System.out.println(l2.toString());
                          break;                    
                                    
                  case 6: System.out.println("\nThank you and have a nice day.");
                          break;
            
                  default: System.out.println("\nI am sorry, that is an invalid menu choice." +
                  "\nPlease try again\n");
               }
            }
            
            continueInput = false;
         }
         
         catch(InputMismatchException ex) { //catches invalid inputs
         
            System.out.println("\nI am sorry, that is not valid menu choice.\n");

            input.nextLine();            
         }      
      } while (continueInput);          
   }
   
   public static void line1(Scanner input) { //creates a line object
   
      do {
      
         try {
      
            System.out.print("\nEnter the x and y coordinates for the first point: ");
      
            l1.setP1(input.nextInt(), input.nextInt());
      
            System.out.print("Enter the x and y coordinates for the second point: ");
      
            l1.setP2(input.nextInt(), input.nextInt());
      
            System.out.print("Enter the width of the line: ");
      
            l1.setWidth(input.nextInt());
      
            System.out.print("Enter the color of the line: ");
      
            l1.setColor(input.next());
      
            System.out.println();
      
            Line.validateLine(l1);
      
            if (Line.validateLine(l1) == false) {
      
               System.out.println("At lease one of your coordinates or your width was " +
               "less than 0, or your end-points were the same.\nPlease re-enter line attributes.");
            }
         }
            
         catch (InputMismatchException ex) { //catches invalid inputs
         
            System.out.println("\nI am sorry, that entry is not of the correct type.");

            input.nextLine();
            
            line1(input);            
         }   
      } while (Line.validateLine(l1) == false);       
   }
   
   public static void line2(Scanner input) { //creates a line object
   
      do {
      
         try {
      
            System.out.print("\nEnter the x and y coordinates for the first point: ");
      
            l2.setP1(input.nextInt(), input.nextInt());
      
            System.out.print("Enter the x and y coordinates for the second point: ");
      
            l2.setP2(input.nextInt(), input.nextInt());
      
            System.out.print("Enter the width of the line: ");
      
            l2.setWidth(input.nextInt());
      
            System.out.print("Enter the color of the line: ");
      
            l2.setColor(input.next());
      
            System.out.println();
      
            Line.validateLine(l2);
      
            if (Line.validateLine(l2) == false) {
      
               System.out.println("At lease one of your coordinates or your width was " +
               "less than 0, or your end-points were the same.\nPlease re-enter line attributes.");
            }
         }
            
         catch (InputMismatchException ex) { //catches invalid inputs
         
            System.out.println("\nI am sorry, that entry is not of the correct type.");

            input.nextLine();
            
            line2(input);            
         }   
      } while (Line.validateLine(l2) == false);       
   }
   
   public static void lineEquals() { //prints line equality to console
   
      boolean lineEquals;
      
      if (l1.equals(l2)) {
      
         System.out.println("\nLine 1 and Line 2 are equal\n");
      }
      
      else {
      
         System.out.println("\nLine 1 and Line 2 are not equal\n");
      }   
   }        
}