//Dan Herve
//Assignment 7: Line Composition
//No known shortcomings

public class Line {

   private Point p1 = new Point(); //member variables

   private Point p2 = new Point();
   
   private String color;
   
   private int width;
   
   public Line() { //dvc
   
      p1.setX(0); 
      
      p1.setY(0);
      
      p2.setX(0);
      
      p2.setY(0);
      
      color = "black";
      
      width = 1;
   }
   
   public Line(int x1, int y1, int x2, int y2, String color, int width) { //evc
   
      p1.setX(x1); 
      
      p1.setY(y1);
      
      p2.setX(x2);
      
      p2.setY(y2);
      
      this.color = color;
      
      this.width = width;      
   }
   
   public Line(int x1, int y1, int x2, int y2) { //evc
   
      p1.setX(x1); 
      
      p1.setY(y1);
      
      p2.setX(x2);
      
      p2.setY(y2);
      
      color = "black";
      
      width = 1;
   }
   
   public String getColor() { //get methods
   
      return color;
   }
   
   public int getWidth() {
   
      return width;
   }
   
   public double getLength() {
   
      return length(p1, p2);
   }
   
   public void setColor(String color) { //set methods
   
      this.color = color;
   }
   
   public void setWidth(int width) {
   
      this.width = width;
   }
   
   public void setP1(int x, int y) {
   
      p1.setX(x);
      
      p1.setY(y);
   }
   
   public void setP2(int x, int y) {
   
      p2.setX(x);
      
      p2.setY(y);
   }
   
   @Override
   public String toString() { //toString method
   
      return "\nCoordinates: " + p1.toString() + ", " + p2.toString() +
      "\nLength: " + String.format("%.2f", length(p1, p2)) +
      "\nWidth: " + width + "\nColor: " + color + "\n";
   }
   
   @Override
   public boolean equals(Object obj) { //equals method compares all member variables for equality
   
      if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
      
         Line that = (Line)obj;
      
         if (this.p1.equals(that.p1) && this.p2.equals(that.p2) && this.width == that.width
         && this.color.equals(that.color)) {
      
            return true;
         }
         
         if (this.p1.equals(that.p2) && this.p2.equals(that.p1) && this.width == that.width
         && this.color.equals(that.color)) {
      
            return true;
         }
      }
      
      return false;
   }
   
   public static double length(Point p1, Point p2) { //calculates the length given two points
   
      double length = Math.sqrt(Math.pow(Math.abs(p1.getX() - p2.getX()), 2) + 
      Math.pow(Math.abs(p1.getY() - p2.getY()), 2));
      
      return length;   
   }
   
   public static boolean validateLine(Line l1) { //returns false with negative coordinates, width, or equal points
   
      if (l1.p1.getX() < 0) {
         
         return false;
      }
      
      if (l1.p1.getY() < 0) {
         
         return false;
      }
      
      if (l1.p2.getX() < 0) {
               
         return false;
      }
      
      if (l1.p2.getY() < 0) {
         
         return false;
      }
      
      if (l1.width < 0) {
         
         return false;
      }
      
      if (l1.p1.equals(l1.p2)) {
      
         return false;
      }
      
      return true;           
   }   
}
      
      