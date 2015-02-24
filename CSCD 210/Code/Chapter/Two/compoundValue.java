import java.util.Scanner;

public class compoundValue {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter an amount to save each month: ");
      double savings = input.nextDouble();
      
      System.out.print("Enter an annual interest rate for your account: ");
      double annualPercent = input.nextDouble();
      
      System.out.print("Enter a number of months to see your total amount saved: ");
      int months = input.nextInt();     
      
      double monthlyInterest = annualPercent / 100 / 12;
      
      
      int monthsSaved = 0;
      double totalSavings = 0;
      while (monthsSaved < months){
         
         totalSavings = (totalSavings + savings) * (1 + monthlyInterest);

         monthsSaved++;
         }
      
      System.out.println("After six months you will have a total savings of: $" + 
      (int) (totalSavings * 100) / 100.0);
      }
   }