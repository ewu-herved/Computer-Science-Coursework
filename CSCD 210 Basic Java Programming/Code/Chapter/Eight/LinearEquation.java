import java.util.*;

public class LinearEquation {

   private static Scanner input = new Scanner(System.in);
   
   public static double a;
   
   private static double b;
   
   private static double c;
   
   private static double d;
   
   private static double e;
   
   private static double f;  

   LinearEquation() {   
   } 
   
   public static double a() {
   
       System.out.print("Please enter a value for a: ");
       
       a = input.nextDouble();
       
       return a;
   }
   
   public static void b() {
   
       System.out.print("Please enter a value for b: ");
       
       b = input.nextDouble();
   }  
   
   public static void c() {
   
       System.out.print("Please enter a value for c: ");
       
       c = input.nextDouble();
   }
   
   public static void d() {
   
       System.out.print("Please enter a value for d: ");
       
       d = input.nextDouble();
   }
   
   public static void e() {
   
       System.out.print("Please enter a value for e: ");
       
       e = input.nextDouble();
   }
   
   public static double f() {
   
       System.out.print("Please enter a value for f: ");
       
       f = input.nextDouble();
       
       return f;
   }
   
   public static boolean isSolvable() {
   
      boolean answer = true;
      
      if (a * d - b * c == 0)
         answer = false;
         
      return answer;
   }
   
   public static double getX() {
   
      double x;
      
      x = (e * d - b * f)/(a * d - b * c);
      
      return x;
      
   }
   
   public static double getY() {
   
      double y;
      
      y = (a * f - e * c)/(a * d - b * c);
      
      return y;
      
   }
} 