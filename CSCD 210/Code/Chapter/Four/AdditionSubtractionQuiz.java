import javax.swing.JOptionPane; //Find fix for empty input

public class AdditionSubtractionQuiz {
   public static void main(String[] args) {
      
      int numCorrect = 0;
      
      int numIncorrect = 0;
      
      for (int count = 0; count < 16; count++) {
        
         int number1 = (int) (Math.random() * 10);
         int number2 = (int) (Math.random() * 10);
         
         
         
         if (number1 < number2) {
                     
            int sum = number1 + number2;
            
            String sumInput = JOptionPane.showInputDialog(null, number1 + 
            " + " + number2 + " = ", count + 1 + " of 16", JOptionPane.QUESTION_MESSAGE);
            
            int sumAnswer = Integer.parseInt(sumInput);
            
            if (sumAnswer == number1 + number2) {
               numCorrect++;
               JOptionPane.showMessageDialog(null, "Correct!");
            }
            else if (sumAnswer != number1 + number2){
               numIncorrect++;
               JOptionPane.showMessageDialog(null, "Incorrect\nThe correct answer is " +
               sum); 
               }
            else { 
               break;                     
            }
         }   
         else { 
         
            int difference = number1 - number2;
         
            String difInput = JOptionPane.showInputDialog(null, number1 + " - " + 
            number2 + " = ", count + 1 + " of 16", JOptionPane.QUESTION_MESSAGE);
            
            int difAnswer = Integer.parseInt(difInput);
            
            if (difAnswer == number1 - number2){
               numCorrect++;
               JOptionPane.showMessageDialog(null, "Correct!");
            }
            else {
               numIncorrect++;
               JOptionPane.showMessageDialog(null, "Incorrect\nThe correct answer is " +
               difference);
            } 
         }      
      }
      JOptionPane.showMessageDialog(null, "Your score is:\n" + "Correct: " + 
      numCorrect + "\nIncorrect: " + numIncorrect);
   }
}      
         
         
         
         
         