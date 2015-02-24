import java.util.Scanner;

public class CylinderVolume {
   public static void main(String[] args) {
      //New Scanner
      Scanner input = new Scanner(System.in);
      
      //Request input for radius and length of cylinder
      System.out.println("Enter the radius and length of a cylinder:");
      System.out.print("(i.e radius length): ");
      Double radius = input.nextDouble();
      Double length = input.nextDouble();
      
      //Compute the area and volume of the cylinder
      Double area = radius * radius * Math.PI;
      Double volume = area * length;
      
      //Output the result to the user
      System.out.println("The area of the cylinder is: " + area);
      System.out.println("The volume of the cylinder is: " + volume);
      }
   }