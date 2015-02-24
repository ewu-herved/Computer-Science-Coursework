import javax.swing.JOptionPane;

public class futureTuition {
   public static void main(String[] args) {
      
      double tuition = 10000;      
     
      for (int yearsAttending = 0; yearsAttending < 10; yearsAttending++) {
      
         tuition = tuition * 1.05;         
      }
      
      double attendanceCost = 0;
      
      for (int yearsAttending = 0; yearsAttending < 4; yearsAttending++){
      
         
         
         tuition = tuition * 1.05;        
      
         attendanceCost += tuition;
      }
      JOptionPane.showMessageDialog(null, String.format("If tuition starts at $10,000, the cost to attend university for 4 years after waiting 10 years would be $%.2f", attendanceCost));
   }
}  
      
