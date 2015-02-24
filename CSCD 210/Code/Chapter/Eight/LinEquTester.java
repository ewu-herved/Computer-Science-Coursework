public class LinEquTester {

   private static LinearEquation solver = new LinearEquation();
   
   public static void main(String[] args) {
   
      System.out.println("Please enter values for the following equation:\n");
      System.out.println("ax + by = e      ed - bf     af - ec\n" +
                         "cx + dy = f  x = ------- y = -------\n" +
                         "                 ad - bc     ad - bc\n");      
      
      getValues();
      
      if (solver.isSolvable() == false)
         System.out.print("\nThe equation has no solution.");
      else           
         System.out.print("\nx = " + solver.getX() + "\ny = " + solver.getY());    
   }   
   
   public static void getValues() {
   
      solver.a();
      
      solver.b();
      
      solver.c();
      
      solver.d();
      
      solver.e();
      
      solver.f();       
   }
}