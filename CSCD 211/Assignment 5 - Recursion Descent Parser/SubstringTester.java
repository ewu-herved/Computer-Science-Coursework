import java.util.*;

/**
* This class prompts the user to enter a string and invokes the SubstringGenerator class
* to print all possible substrings for the given string
*
* @author  Dan Herve
* @see  "SubstringGenerator.java - written by Dan Herve for CSCD 211"
*/

public class SubstringTester {

   private static Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
   
      boolean continueInput = true;
      
      String word; 
      
      int choice = 0;  
         
      do {
      
         try {
         
            while (choice != 2) {
            
               choice = 0;
               
               System.out.println("Enter a word to find all of it's substrings:\n");
         
               word = input.nextLine();
            
               if (wordChecker(word) == false) {
               
                  throw new InputMismatchException("Not a word");
               }
            
               SubstringGenerator selection = new SubstringGenerator(word);
                        
               do {
               
                  try {
            
                     System.out.println("Would you like to enter another word?\n\n1.Yes\n2.No");
               
                     choice = input.nextInt();
                  
                     input.nextLine();
                  
                     if (choice != 2 && choice != 1) {
                  
                        throw new InputMismatchException();
                     }
                  
                     if (choice == 2) {
                  
                        System.out.println("Have a nice day!");
                     }
                  }
                              
                  catch (InputMismatchException num) {
               
                     System.out.print("That is not a valid choice.\n\n");
                  
                     input.nextLine();
                  }
               } while (choice != 1 && choice != 2);
               
            continueInput = false;               
            }
         }
         
         catch (InputMismatchException e) {
         
            System.out.println("Input is not a word.\n");
         }
         
      } while (choice != 2);
   }
   
   /**
   * <pre>
   * The wordChecker ensures that alphabetical characters are entered 
   * and returns false if a number is given
   * </pre>
   *
   * @param   word - represents the given String
   * @return   boolean - returns true or false
   * @exception   none - no exception thrown
   */
   
   private static boolean wordChecker(String word) {
   
      try { 
      
         if (Integer.parseInt(word) >= 0 || Integer.parseInt(word) < 0) {
            
            return false;
         }
      
         return true;
      }
      
      catch (NumberFormatException num) {
         
         return true;
      }
   }
}