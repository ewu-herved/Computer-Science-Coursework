import javax.swing.JOptionPane;

public class numberAverage {//Class finds the sum of numbers and averages them
   public static void main(String[] args) {
      
      int sum = 0;
      
      int count = 0;
      
      int option = JOptionPane.YES_OPTION;
      
      int countPos = 0;
      int countNeg = 0;
      
      while (option == JOptionPane.YES_OPTION) {
         String integer = JOptionPane.showInputDialog("Enter an integer: ");
         
         int data = Integer.parseInt(integer);
         
         sum += data;
         
         
         if (data > 0)
         countPos++;
         
         else if (data == 0) 
         ;
         
         else
         countNeg++;
                 
         count++;
                  
         option = JOptionPane.showConfirmDialog(null, "Continue?");
      }
      
      double average = sum / count;
      
      JOptionPane.showMessageDialog(null, "The sum is " + sum +
      "\nThe number of positives is " + countPos + "\nThe number" +
      " of negatives is " + countNeg + "\nThe average is " + average);
   }
}
         
         
