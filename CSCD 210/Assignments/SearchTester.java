//Dan Herve
//Lab 2 Linear Search
//No known shortcomings

public class SearchTester { 

   public static void main(String[] args) { 
   
      int[] intAra = {4, 11, 18, 27, 83, 96, 101, 113}; 
      
      int found = SortSearchUtil.binarySearch(intAra, 11); 
      
         if (found > -1) { 
         
            System.out.println("Value 11 was found at index " + found); 
         } 
         else { 
            System.out.println("Value 11 was not found in the array. Sad..."); 
         } 
       
   }
}