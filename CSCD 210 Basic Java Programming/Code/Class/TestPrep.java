public class TestPrep {

   public static void main(String[] args) {
      
      
      
      int[] myInts = {0, 1, 2, 3};
     
      for (int myValue : myInts) { 
         System.out.println(myValue); 
      }
      
      
      for (int x = 1; x <= 5; x++) { 
         for (int y = 0; y <= x; y++ ) { 
            System.out.print(x * y + " "); 
         } 
         System.out.println(); 
      } 
   }
} 