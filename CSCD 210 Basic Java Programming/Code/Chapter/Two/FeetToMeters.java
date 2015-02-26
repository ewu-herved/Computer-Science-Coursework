import java.util.Scanner;

public class FeetToMeters {
   public static void main(String[] args) {
      //Create a Scanner
      Scanner input = new Scanner(System.in);
      
      //Prompt the user for a value, feet
      System.out.println("Curious about feet-to-meter conversions?");
      System.out.println("Enter a number of feet: ");
      double feet = input.nextDouble();
      
      //Convert feet to meters
      double meters = feet * 0.305;
      
      //Output the conversion
      System.out.println(feet + " feet is " + meters + " meters.");
      }
   }