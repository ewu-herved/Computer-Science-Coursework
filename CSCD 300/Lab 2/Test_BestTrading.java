import java.util.*;
import java.io.*;

public class Test_BestTrading {

   static Trade bestTrade = new Trade();

   public static void main(String[] args) throws FileNotFoundException {
      
      Scanner input = new Scanner(new File("data.txt"));
      
      int[]p;
      
      int count = 0;
      
      if (input.hasNext()) {
      
         count++;
      }
      
      while(input.next() != null && input.hasNext()) {
      
         count++;
      }
      
      input.close();
      
      p = new int[count];
      
      input = new Scanner(new File("data.txt"));
      
      for (int i = 0; input.hasNextLine(); i++) {
      
         p[i] = input.nextInt();
      }
      
      System.out.println(bestTrade(p).toString());      
   }
   
   public static Trade bestTrade(int[] p) {
   
      int lowest = p[0];
      
      int lowestIndex = 0;
      
      if (lowest == -1) {
         
         for(int i = p.length - 2; i >= 0; i--) {
      
            if (p[i] > lowest) {
         
               lowest = p[i];
            }  
         }         
      }
      
      int highest = p[p.length - 1];
      
      int highestIndex = p.length - 1;
      
      int profit = 0;
      
      for(int i = 1; i < p.length; i++) {
      
         if (p[i] < lowest && p[i] >= 0 || lowest == -1 && p[i] < highest) {
         
            if (p[i] == - 1) {}
            
            else {
            
               lowest = p[i];
            
               lowestIndex = i;
            }
         }  
      }
      
      for(int i = p.length - 2; i >= 0; i--) {
      
         if (p[i] > highest) {
         
            highest = p[i];
            
            highestIndex = i;
         }  
      }
      
      if (highestIndex > lowestIndex) {
      
         profit = highest - lowest;
      
         return new Trade(lowestIndex, highestIndex, profit);
      }
      
      if (p[highestIndex] == -1) { 
      
         return new Trade(0, 0, 0);
      }
      
      p[highestIndex] = -1;
      
      Trade lowProfit = bestTrade(p);
      
      //p[highestIndex] = highest;
      //p[lowestIndex] = highest + 1;
      
      Trade highProfit = bestTrade(p);
      
      if (highProfit.profit > lowProfit.profit) {
      
         profit = highProfit.profit;
         lowestIndex = highProfit.in;
         highestIndex = highProfit.out;
      }
      else {
         profit = lowProfit.profit;
         lowestIndex = lowProfit.in;
         highestIndex = lowProfit.out;
      }
      
      return new Trade(lowestIndex, highestIndex, profit);
   }
}