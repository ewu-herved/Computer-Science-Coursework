import java.util.Scanner;
import java.io.*;

public class SysCalls {

   public static void main(String[] args) throws Exception {
   
      Scanner input = new Scanner(new File("test.txt"));
      
      while(input.hasNextLine()) {
      
         System.out.println(input.nextLine());
      }
      
      input.close();
   }
}