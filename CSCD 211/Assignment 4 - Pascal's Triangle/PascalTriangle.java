public class PascalTriangle {
   
   private int size;
   
   private int[][] triangle; 
   
   public PascalTriangle (int size) {
   
      this.size = size;
      
      triangle = new int[size + 1][1];
      
      for (int r = 0; r < triangle.length; r++) {
      
         triangle[r] = new int[r + 2];
      }
      
      triangle[1][1] = 1;
      
      for (int r = 2; r < size + 1; r++) {
         
         for (int c = 0; c < triangle[r].length; c++) {
         
            if (c == triangle[r][0] || c == triangle[r].length - 1) {
            
               triangle[r][c] = 0;
            }
            
            else {

               triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
            }
         }
      }  
   }
   
   @Override
   public String toString() {
   
      String tri = "";
      
      for (int r = 0; r < size + 1; r++) {
      
         
         for (int i = 0; i < size - r; i++) {
         
            int test = size - r;
            tri += " ";
         } 
         
         for (int c = 0; c < triangle[r].length; c++) {
         
            if (triangle[r][c] != 0)
               
               tri += triangle[r][c] + " ";
         }
         
         tri += "\n";
      }
      
      return tri;
   }          
}