import java.util.*;
import java.io.*;

public class FileScanner {

   public Scanner getScanner(String filename) {
      
      Scanner temp;
      
      try {
      
         File names = new File(filename);
         
         temp = new Scanner(names);
         
         return temp;         
      }
      catch (FileNotFoundException fnfe) {
      
         System.out.println("File of names not found.");
      }
      
      return null;      
   }
}