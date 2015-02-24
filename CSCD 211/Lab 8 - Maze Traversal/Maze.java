public class Maze {

   private static int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1}, 
                            {1,0,1,1,1,0,1,1,1,1,0,0,1}, 
                            {0,0,0,0,1,0,1,0,1,0,1,0,0}, 
                            {1,1,1,0,1,1,1,0,1,0,1,1,1}, 
                            {1,0,1,0,0,0,0,1,1,1,0,0,1}, 
                            {1,0,1,1,1,1,1,1,0,1,1,1,1}, 
                            {1,0,0,0,0,0,0,0,0,0,0,0,0}, 
                            {1,1,1,1,1,1,1,1,1,1,1,1,1}};

   static int xAxis = 0;
   static int yAxis = 0;   
   
   public static void main(String[] args) {
   
      if (travel(yAxis, xAxis)) {
         System.out.print("You've escaped the labyrinth!");
      }
      else {
         System.out.print("You're trapped in the labyrinth!");
      }  
   }
                               
   private static boolean travel(int yAxis, int xAxis) {
         
      if (validMove(yAxis, xAxis) == false) {
      
         return false;
      }
      
      if (yAxis == grid.length - 1 && xAxis == grid[0].length - 1) {
      
         grid[yAxis][xAxis] = 7;
         
         return true; 
      }
      
      grid[yAxis][xAxis] = 3;
      
      if (travel(yAxis + 1, xAxis)) {
         
         grid[yAxis][xAxis] = 7;
         
         return true; 
      }
         
      if (travel(yAxis - 1, xAxis)) {
         
         grid[yAxis][xAxis] = 7;
         
         return true;         
      }
      
      if (travel(yAxis, xAxis + 1)) {
         
         grid[yAxis][xAxis] = 7;
         
         return true;               
      }
        
      if (travel(yAxis, xAxis - 1)) {
         
         grid[yAxis][xAxis] = 7;
            
         return true;
      }      
     
      return false;
   }
   
   private static boolean validMove(int yAxis, int xAxis) {
   
      try {
      
         if (grid[yAxis][xAxis] != 1) 
            return false;
      }
      catch (IndexOutOfBoundsException e) {
         return false;
      }
      return true;
   }
}      