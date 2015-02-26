import java.util.Scanner;

public class DigitSum {
   public static void main(String[] args) {
      //Create a Scanner
      Scanner input = new Scanner(System.in);
      
      //Prompt for an integer between 0 and 9999
      System.out.print("Enter an integer between 0 and 9999: ");
      int integer = input.nextInt();
      
      //Find the sum of the integer's digits
      int oneSpace = integer % 10;
      int tenSpace = integer / 10 % 10;
      int hundredSpace = integer / 100 % 10;
      int thousandSpace = integer / 1000 % 10;
      int sum = oneSpace + tenSpace + hundredSpace + thousandSpace;
      
      //Output the sum of the digits
      System.out.println("The sum of the digits is: " + sum);
      }
   }