import java.util.Scanner;

public class CelsiusToFahrenheit {
   public static void main(String[] args){
      //Create a Scanner
      Scanner input = new Scanner(System.in);
      
      //Prompt the user to enter degrees Celsius
      System.out.print("Enter a number of degrees, Celsius that " +
      "you would like to have converted to degrees, Fahrenheit: ");
     
      //Allow for input
      double celsius = input.nextDouble();
      
      //Interpret input 
      double fahrenheit = (9.0 / 5) * celsius + 32;
      
      //Output the degrees, Fahrenheit
      System.out.print(celsius + " degrees, Celsius is " + fahrenheit +
      " degrees, Fahrenheit.");
      }
   }