import java.util.Scanner;

public class ModularityPractice {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      double numerator = 42;
      
      double denomenator = 7;
      
      double answer = divEm(numerator, denomenator);
      
      System.out.print(answer);
      }
   public static double divEm(double num, double den) {
      double ans = num / den;
      anotherMethod(ans);
      return ans;
      }
   public static void anotherMethod(double parm1) {
      System.out.println(parm1);
      }
   }