import java.util.Scanner;

public class displayPyramid {

   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter a number less than 21 to build a pyramid:");
      
      int number = input.nextInt();      
      
      int first = number;     
                 
      if (number < 21) {
         for (int t = 1; t <= number; t++) {         
         
            for (int i = number ; i > t; i--) { 
               
               if (i > 9) 
                  
                  System.out.print("   ");
               
               else
               
                  System.out.print("  ");
               
            }
            for (int i = 0; i < t; i++) {
               
               System.out.print((t - i) + " ");
            }
            for (int i = 1; i < t; i++) {
               
               System.out.print((i + 1) + " ");
            }
            
            System.out.println();            
         }         
      }
      else {
      
      System.out.println(number + " is not less than 20.");
      } 
   }
}