//Dan Herve
//Assignment 3: LongInteger Calculator
//No known shortcomings; completed all extra credit

import java.util.*; //import Scanner

public class IntDriver {

   private static Scanner input = new Scanner(System.in);
   
   private static LongInteger num1;
   
   private static LongInteger num2;
   
   private static LongInteger total;
   
   private static String operator;
   
   private static String mode = "Decimal Mode";

   public static void main(String[] args) {
         
      System.out.println("Welcome to the Integer Calculator!\n\n");
      
      modeChoice(); //selects the mode of operation
   }
   
   private static void menu() { //operations menu
   
      boolean continueInput = true;
      
      String choice = ""; 
      
      input.nextLine();     
      
      do { 
         
         try {
            
            while (continueInput == true) { //Prompts the user to continue after slaying a foe
               
               System.out.println(mode + "\n\nBin - Binary       +\nOct - Octal        -\nDec - Decimal      *" +
                                  "\nHex - Hexidecimal  /\nQ - Quit           =\nM - Changes calculator mode\n");   
               
               if (num1 != null && operator == null && num2 == null) { //examines existing input and prints it
                  
                  System.out.print(num1.toString() + numberType(num1));
               }
               
               else if (num1 != null && operator != null && num2 == null) {
               
                  System.out.print(num1.toString() + numberType(num1) + " " + operator);
               }
               
               else if (num1 != null && operator != null && num2 != null) {
               
                  System.out.print(num1.toString() + numberType(num1) + " " + operator + " " + num2.toString() + numberType(num2));
               }
         
               choice = input.nextLine(); //selection for this instance of the menu
               
               if (choice.equals("Bin") || choice.equals("bin")) { //prompts for binary number
                  
                  System.out.print("Enter a binary number: ");
                  
                  String number = input.nextLine();
                                                      
                  if (operator != null) {
                  
                     num2 = new BinaryInteger(number);
                  }
                  
                  else {
                  
                     num1 = new BinaryInteger(number); 
                  }
               }
                    
               else if (choice.equals("Oct") || choice.equals("oct")) { //prompts for octal number
               
                  System.out.print("Enter an octal number: ");
                  
                  if (operator != null) {
                  
                     num2 = new OctalInteger(input.nextLine());
                  }
                  
                  else {
                  
                     num1 = new OctalInteger(input.nextLine()); 
                  }
               }
               
               else if (choice.equals("Dec") || choice.equals("dec")) { //prompts for decimal number
               
                  System.out.print("Enter a decimal number: ");
                  
                  if (operator != null) {
                  
                     num2 = new LongInteger(input.nextLong());
                  }
                  
                  else {
                  
                     num1 = new LongInteger(input.nextLong()); 
                  }
               }
               
               else if (choice.equals("Hex") || choice.equals("hex")) { // prompts for hexidecimal number
               
                  System.out.print("Enter an hexidecimal number: ");
                  
                  if (operator != null) {
                  
                     num2 = new HexidecimalInteger(input.nextLine());
                  }
                  
                  else {
                  
                     num1 = new HexidecimalInteger(input.nextLine()); 
                  }
               }
               
               else if (choice.equals("+")) {
                  
                  if (num2 != null) {
                  
                     num1 = calculate();
                     num2 = null;
                  }
                  
                  operator = "+";  
               }
               
               else if (choice.equals("-")) {
               
                  if (num2 != null) {
                  
                     num1 = calculate();
                     num2 = null;
                  }
                  
                  operator = "-";
               }
               
               else if (choice.equals("*")) {
               
                  if (num2 != null) {
                  
                     num1 = calculate();
                     num2 = null;
                  }
                  
                  operator = "*";
               }
               
               else if (choice.equals("/")) {
               
                  if (num2 != null) {
                  
                     num1 = calculate();
                     num2 = null;
                  }
                  
                  operator = "/";
               }
               
               else if (choice.equals("=")) { //performs a final calculation and resets saved values to null
               
                  if (num1 != null && num2 != null && operator != null) {
                  
                     printAns();
                     System.out.print("\nPress enter to continue.");
                     input.nextLine();
                  }
                  
                  else {
                  
                     System.out.println("Insufficient data to make calculation.\n");
                  }
               }
               
               else if (choice.equals("Q") || choice.equals("q")) { //quits the program
               
                  System.out.println("Thank for using the Integer Calculator.\n\nHave a nice day!");
                  
                  System.exit(0);
               }
               
               else if (choice.equals("M") || choice.equals("m")) { //changes calculator mode
               
                  continueInput = false;
               }
               
               else if (mode == "Hexidecimal Mode") { //accepts hex input if in hex mode
               
                  if (operator != null) {
                  
                     num2 = new HexidecimalInteger(choice);
                  }
                  
                  else {
                  
                     num1 = new HexidecimalInteger(choice);
                  }
               }
               
               else if (Long.parseLong(choice) >= 0 || Long.parseLong(choice) < 0) { //accepts number input for the relevant mode
                  
                  long temp = Long.parseLong(choice);
                  
                  if (operator != null) {
                  
                     if (mode == "Decimal Mode") {
                     
                        num2 = new LongInteger(temp);
                     }
                     
                     else if (mode == "Binary Mode") {
                     
                        num2 = new BinaryInteger(choice);
                     }
                     
                     else if (mode == "Octal Mode") {
                     
                        num2 = new OctalInteger(choice);
                     }
                  }
                  
                  else {
                  
                     if (mode == "Decimal Mode") {
                     
                        num1 = new LongInteger(temp);
                     }
                     
                     else if (mode == "Binary Mode") {
                     
                        num1 = new BinaryInteger(choice);
                     }
                     
                     else if (mode == "Octal Mode") {
                     
                        num1 = new OctalInteger(choice);
                     }
                  }
               }
               
               else { //alerts the user if their input is invalid
               
                  System.out.println("That is not valid input.\n\nPress enter to continue.");
                  
                  input.nextLine();
               }             
            }
         }
         
         catch (InputMismatchException ex) { //alerts the user if their input is invalid
         
            System.out.println("That is not a valid choice.\n\nPress enter to continue.");
               
            input.nextLine();
         }
         
         catch (NumberFormatException ex) { //alerts the user if their input is invalid
         
            System.out.println("You must input a menu option or number. Press enter to continue.");
               
            input.nextLine();
         }
      } while(continueInput);
   }
   
   private static void modeChoice() { //menu to select mode. answers will be given in the relevant mode
   
      boolean continueInput = true;
      
      int choice;
      
      do { 
         
         try {
            
            while (continueInput = true) { 
               
               System.out.println("Please seclect desired mode of operation:\n" +
                                  "1. Decimal Mode\n\n2. Binary Mode\n\n3. Octal Mode\n\n4. Hexidecimal Mode\n");
         
               choice = input.nextInt();
            
               switch (choice) {
         
                  case 1: mode = "Decimal Mode"; 
                          menu();   
                          break;
                    
                  case 2: mode = "Binary Mode";
                          menu();                             
                          break;
                             
                  case 3: mode = "Octal Mode";
                          menu();
                          break;
                             
                  case 4: mode = "Hexidecimal Mode";
                          menu();
                          break;
               }             
            }
               
            continueInput = false;
         }
         
         catch (InputMismatchException ex) { //alerts the user if their choice doesn't exist
         
            System.out.println("That is not a valid choice.");
               
            input.nextLine();
         }
      } while(continueInput);
   }
   
   private static LongInteger calculate() { //returns a LongInteger object of the specified type
      
      operatorCalc(num1, operator, num2);
      
      LongInteger answer;
      
      if (mode.equals("Binary Mode")) {
      
         answer = new BinaryInteger(total.getValue());
      }
      
      else if (mode.equals("Octal Mode")) {
      
         answer = new OctalInteger(total.getValue());
      }
      
      else if (mode.equals("Hexidecimal Mode")) {
      
         answer = new HexidecimalInteger(total.getValue());
      }
      
      else {
      
         answer = total;
      }
      
      return answer;
   }
   
   private static void printAns() { //prints out the final answer and resets member variables
   
      LongInteger answer = calculate();
      
      System.out.println(num1.toString() + numberType(num1) + " " + operator + " " + num2.toString() + numberType(num2) + 
                         " = " + answer.toString() + numberType(answer));
      
      num1 = null;
      
      num2 = null;
      
      operator = null;
      
      answer = null;
   }
   
   private static String numberType(LongInteger type) { //prints conversion tab after numbers
   
      if (type.getClass().getName().equals("LongInteger")) {
      
         return "(Dec)";
      }
      else if (type.getClass().getName().equals("BinaryInteger")) {
      
         return "(Bin)";
      }
      
      else if (type.getClass().getName().equals("OctalInteger")) {
      
         return "(Oct)";
      }
      
      else if (type.getClass().getName().equals("HexidecimalInteger")) {
      
         return "(Hex)";
      }
      
      return null;
   }
   
   private static void operatorCalc(LongInteger num1, String operator, LongInteger num2) { //reads the operator and performs 
                                                                                           //calculations based on operator
   
      LongInteger answer;
      
      if (operator.equals("+")) {
                  
         answer = new LongInteger(num1.getValue() + num2.getValue());           
      }
               
      else if (operator.equals("-")) {
               
         answer = new LongInteger(num1.getValue() - num2.getValue());
      }
               
      else if (operator.equals("*")) {
               
         answer = new LongInteger(num1.getValue() * num2.getValue());
      }
               
      else if (operator.equals("/")) {
               
         answer = new LongInteger(num1.getValue() / num2.getValue());
      }
      
      else {
      
         answer = new LongInteger();
      }
      
      total = answer;
   }   
}