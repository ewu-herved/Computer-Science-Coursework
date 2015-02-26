import java.util.Scanner;

public class Time {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter the number of hours from GMT that your timezone is offset by: ");
      int timeZone = input.nextInt();
      
      long totalMilliseconds = System.currentTimeMillis();
      
      long totalSeconds = totalMilliseconds / 1000;
      long currentSecond = totalSeconds % 60;
      
      long totalMinutes = totalSeconds / 60;
      long currentMinute= totalMinutes % 60;
      
      long totalHours = totalMinutes / 60;
      long currentHour = totalHours % 24;
     
      System.out.println("The current time in G.M.T is: " + currentHour + ":" + currentMinute + 
      ":" + currentSecond);
      System.out.println("The current time in your timezone is: " + (totalHours + timeZone) % 24 + ":" + currentMinute + 
      ":" + currentSecond);

      
      }
   }