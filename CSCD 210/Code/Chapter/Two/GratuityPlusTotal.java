import java.util.Scanner;

public class GratuityPlusTotal {
   public static void main(String[] args) {
      //Import Scanner
      Scanner input = new Scanner(System.in);
      
      //Prompt for subtotal of bill and desired gratuity
      System.out.println("Calculating gratuity can be hard. I can help.");
      System.out.print("How much was the bill? ");
      double bill = input.nextDouble();
      System.out.print("What percentage do you wish to tip? ");
      double gratuity = input.nextDouble();
      
      //Calculate gratuity and total
      double tip = gratuity / 100 * bill;
      double total = tip + bill;
      
      //Output the results
      System.out.print("The tip should be $" + 
      (int)(tip * 100) / (double)100); //explicit casting widening for reference
      System.out.print("; the total bill would then be $" + 
      (int)(total * 100) / 100.0 + ".");
      }
   }