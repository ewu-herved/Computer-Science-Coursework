//Dan Herve

import java.util.*;
import java.io.*;

public class Test_BinarySearchDup {
   
   public static void main(String[] args) throws FileNotFoundException {
   
      Pair answer = binarySearchEx(new File(args[0]), Integer.parseInt(args[1]));
      
      System.out.println(answer.toString());
   }

   public static int binarySearch(Comparable[] ara, int target) { //Binary Search fpr reference
   
      int high = ara.length - 1;
      int low = 0;
      
      while(high > low) {
      
         int mid = (high + low) / 2;
         
         if (mid == target) {
         
            return mid;
         }
         
         if (mid < target) {
         
            low = mid + 1;
         }
         
         if (mid > target) {
         
            high = mid - 1;
         } 
      }
      
      return - 1;
   }
   
   public static Pair binarySearchEx(File file, int target) throws FileNotFoundException { //Binary Search that checks for all examples of the element in question
   
      Scanner input = new Scanner(file);
      
      int count = 1;
      
      while(input.nextLine() != null && input.hasNext()) {
      
         count++;
      }
      
      int[] ara = new int[count];
      
      input.close();
      
      input = new Scanner(file);
      
      for(int i = 0; i < count; i++) {
      
         ara[i] = input.nextInt();
      }
      
      input.close();
      
      return new Pair(ara, target);
   }
}         