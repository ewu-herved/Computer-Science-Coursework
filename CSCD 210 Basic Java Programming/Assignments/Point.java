//Dan Herve
//Assignment 7: Line Composition
//No known shortcomings

public class Point { 

   private int x;

   private int y;
   
   public Point() { //dvc
   
      x = 0;
      
      y = 0;
   }
   
   public Point(int x, int y) { //evc
   
      if (x >= 0 && y >= 0) {
      
         this.x = x;
      
         this.y = y;
      }
   }
   
   public int getX() { //get methods
   
      return x;
   }
   
   public int getY() {
   
      return y;
   }
   
   public void setX(int x) { //set methods
   
      this.x = x;
   }
   
   public void setY(int y) {
   
      this.y = y;
   }
   
   @Override
   public String toString() { //toString method
   
      return "(" + x + ", " + y + ")";
   }
   
   @Override
   public boolean equals(Object obj) { //equals method compares coordinate equality
   
      if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
      
         Point that = (Point)obj;
      
         if (this.x == that.x && this.y == that.y) {
      
            return true;
         }
      }
      
      return false;
   }   
}
      
      