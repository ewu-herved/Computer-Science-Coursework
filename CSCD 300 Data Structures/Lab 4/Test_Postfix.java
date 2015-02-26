//Dan Herve
//CSCD 300 Lab 4

import java.util.*;
import java.io.*;

public class Test_Postfix { //driver class
   
   public static void main(String[] args) throws FileNotFoundException {
   
      int num1;
      
      int num2;
      
      char op;
      
      int result = 0;
      
      StackList postFix = new StackList(); 
      
      try {
      
         Scanner input = new Scanner(new File(args[0]));
      
         while (input.hasNextLine()) { //checks for data
      
            if (input.hasNextInt()) { //pushes an int
         
               postFix.push(input.nextInt());
            }
         
            else { //pushes an operator and operates
         
               postFix.push(input.next());
            
               String temp = (String) postFix.pop();
         
               op = temp.charAt(0);            
            
               num2 = (Integer) postFix.pop();
            
               num1 = (Integer) postFix.pop();
        
               switch (op) {
            
                  case '+': postFix.push(num1 + num2);
                            break;
               
                  case '-': postFix.push(num1 - num2);
                            break;
               
                  case '*': postFix.push(num1 * num2);
                            break;
               
                  case '/': postFix.push(num1 / num2);
                            break;
               }
            }            
         }
      
         result = (Integer) postFix.pop();
      }
      
      catch (NullPointerException e) { //this error occurs if there are not enough operands 
            
         System.out.println("Error: The input file does not conform to proper postfix notation.");
         System.exit(0);
      }
      
      catch (NoSuchElementException f) { //this error occurs if there is a /r in the input
      }
      
      catch (ArrayIndexOutOfBoundsException g) { //this error occurs if a .txt file isn't included
      
         System.out.println("Error: User must include the address of a .txt file conforming to postfix notation.");
         System.exit(0);
      }
      
      if (postFix.isEmpty() == false) { //this error occurs if there are too many operands
      
         System.out.println("Error: The input file does not conform to proper postfix notation.");
      }
            
      else {
      
         System.out.println(result);
      }
   }
}