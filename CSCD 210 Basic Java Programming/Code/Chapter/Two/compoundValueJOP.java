import javax.swing.JOptionPane;

public class compoundValueJOP {
   public static void main(String[] args) {
      
      String savingsString = JOptionPane.showInputDialog(null, "Enter an amount to save each month: ", 
      "Monthly Savings", JOptionPane.QUESTION_MESSAGE);
      double savings = Double.parseDouble(savingsString);
            
      String annualPercentString = JOptionPane.showInputDialog(null, "Enter an annual interest rate" + 
      " for your account: ", "Interest Rate", JOptionPane.QUESTION_MESSAGE);
      double annualPercent = Double.parseDouble(annualPercentString);
      
      String monthsString = JOptionPane.showInputDialog(null, "Enter a number of months to see your" +
      " total amount saved: ", "Numbers of Months Saved", JOptionPane.QUESTION_MESSAGE);
      int months = Integer.parseInt(monthsString);     
      
      double monthlyInterest = annualPercent / 100 / 12;
      
      
      int monthsSaved = 0;
      double totalSavings = 0;
      while (monthsSaved < months){
         
         totalSavings = (totalSavings + savings) * (1 + monthlyInterest);

         monthsSaved++;
         }
      
      String output = "After six months you will have a total savings of: $" + 
      (int) (totalSavings * 100) / 100.0;
      JOptionPane.showMessageDialog(null, output, "Amount Saved", JOptionPane.QUESTION_MESSAGE);
      }
   }