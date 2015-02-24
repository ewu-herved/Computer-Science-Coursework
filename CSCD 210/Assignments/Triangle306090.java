//Dan Herve
//Lab Lengths of a 30-60-90 Triangle
//No shortcomings identified

import javax.swing.JOptionPane; //import dialog box Class

public class Triangle306090 { //declare Class
   public static void main(String[] args) { //main method
      
      //Request triangle base from user from a dialog box
      String baseString = JOptionPane.showInputDialog(null, "Enter the value for the base of a 30-60" +
      "-90 triangle: ", "Find Height and Hypotenuse of a 30-60-90", JOptionPane.QUESTION_MESSAGE);
      
      //Convert string to double      
      double base = Double.parseDouble(baseString);
      
      //Declare the string containing the answer      
      String output = getValue(base);
      
      //Output the answer in a dialog window
      displaySides(output);
         
      }      
   public static String getValue(double bas) { //a method to calculate the unknown sides
   
      //Calculate hpyotenuse of triangle
      double hypotenuse = 2 * bas;
      
      //Calculate height of triangle
      double height = bas * Math.sqrt(3); 
      
      //String that states the lengths of the hypotenuse and height given the base
      String output = "If the base of the triangle is " + bas + ", then the hypotenuse is " + 
      hypotenuse + " and the height is " + height +  ".";   
      
      //return the string to the main method
      return output;      
      }      
   public static void displaySides(String output){ //creat a dialog box with the answer
      //Output the string with the answer
      JOptionPane.showMessageDialog(null, output, "Find Height and Hypotenuse of a 30-60-90", 
      JOptionPane.QUESTION_MESSAGE);           
      }
   }
      
      
      