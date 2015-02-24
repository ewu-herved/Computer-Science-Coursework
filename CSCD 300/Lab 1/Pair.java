//Dan Herve

public class Pair { //Checks the extreme boundaries of the searched-for element
   
   private int left = -1;
      
   private int right = -1;
      
   public Pair(int[] ara, int target) {
      
      int high = ara.length - 1;
      int low = 0;
      
      while(high >= low && left == -1) { //binary search for the leftmost eleemnt
      
         int mid = (high + low) / 2;
           
         if (ara[low] != target && ara[low + 1] == target) {
            
            left = low + 1;
         }
         
         if (high == low && ara[low] == target) {
         
            left = low;
         }
         
         if (ara[mid] == target) {
         
            high = mid - 1;
         }
        
         if (ara[mid] < target) {
        
            low = mid + 1;
         }
        
         if (ara[mid] > target) {
         
            high = mid - 1;
         }             
      }
      
      high = ara.length - 1;
      low = 0;
         
      while(high >= low && right == -1) { //binary search for the rightmost element
      
         int mid = (high + low) / 2;
           
         if (ara[high] != target && ara[high] - 1 == target) {
            
            right = high - 1;
         }
         
         if (high == low && ara[low] == target) {
         
            right = low;
         }
                  
         if (ara[mid] == target) {
         
            low = mid + 1;
         }
         
         if (ara[mid] < target) {
         
            low = mid + 1;
         }
         
         if (ara[mid] > target) {
         
            high = mid - 1;
         }             
      }
   }
      
   public int[] getPair() {
      
      int[] result = {left, right};
      
      return result;
   }
      
   @Override
   public String toString() {
      
      return "[" + left + ", " + right + "]";
   }
}