//Dan Herve
//Assignment 6: Rational Numbers
//No known shortcomings

public class SortSearchUtil {
     
   public static int linearSearch(int[] numbers, int match) {
      
      int bingo = 0;
         
      for (int i = 0; i < numbers.length; i++) {
         numbers[i] = i + 1; 
         if (numbers[i] == match) {
            bingo = i;
            break;
         }
         else {
            bingo = -1; 
         }                     
      }
      return bingo;           
   }   
  
   public static int binarySearch(int[] numbers, int match) {
   
      int high = numbers.length - 1;
      int low = 0;
      int mid = 0;
      
      while (high >= low) {
      
         mid = (high + low) / 2;
      
         if (numbers[mid] > match) 
            high = mid - 1;
         else if ( numbers[mid] < match) 
            low = mid + 1;
         else 
            return mid;
            
      }
      return -1;
   }
   
   public static int[] sortSelection(int[] numbers) {
   
      for (int i = 0; i < numbers.length - 1; i++) {
      
         int currentMin = numbers[i];
         
         int currentMinIndex = i;
         
         for (int j = i + 1; j < numbers.length; j++) {         
                        
            if (currentMin > numbers[j]) {
               
               currentMin = numbers[j];
               
               currentMinIndex = j;               
            }
         }
         
         if (currentMinIndex != i) {
         
            numbers[currentMinIndex] = numbers[i];
            
            numbers[i] = currentMin;
         }
      }
      return numbers;
   }
   
   public static Comparable[] sortSelection(Comparable[] numbers) {
   
      for (int i = 0; i < numbers.length - 1; i++) {
      
         Comparable currentMin = numbers[i];
         
         int currentMinIndex = i;
         
         for (int j = i + 1; j < numbers.length; j++) {         
                        
            if (currentMin.compareTo(numbers[j]) > 0) {
               
               currentMin = numbers[j];
               
               currentMinIndex = j;               
            }
         }
         
         if (currentMinIndex != i) {
         
            numbers[currentMinIndex] = numbers[i];
            
            numbers[i] = currentMin;
         }
      }
      return numbers;
   }
}
         