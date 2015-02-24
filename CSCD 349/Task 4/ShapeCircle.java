import java.awt.Point;
import java.util.*;
import java.lang.Math;

public class ShapeCircle extends A_Shape {

   private Point center;
   
   private double radius;
   
   public ShapeCircle(String id, Point center, double radius) {
   
      super(id);
      
      if(center == null)
         throw new NullPointerException("No point given\n");
      
      this.center = center;
      
      if(radius <= 0)
         throw new NullPointerException("Incorrect format for radius\n");
      
      this.radius = radius;
   }
   
   public Point getCenter() {
   
      return center;
   }
   
   public double getRadius() {
   
      return radius;
   }
   
   public void setCenter(Point center) {
   
      if(center == null)
         throw new NullPointerException("No point given\n");
   
      this.center = center;
      getContainer().update();
   }
   
   public void setRadius(double radius) {
   
      if(radius <= 0)
         throw new NullPointerException("Incorrect format for radius\n");
   
      this.radius = radius;
      getContainer().update();
   }
   
   public List<Point> update() {
   
      List<Point> temp = new LinkedList<Point>();
      
      if(hasContainer()) {
      
         Point absolute = getContainer().calculatePointAbsolute(center);
         
         double degree = 0;
         
         while (degree <= 360) {
         
            Point curr = new Point((int)Math.round(radius * Math.cos(degree) + absolute.getX()), 
            (int)Math.round(radius * Math.sin(degree) + absolute.getY()));         
         
            if(getContainer().isRenderable(curr))
               temp.add(curr);
            
            degree = degree + 1.0;
         }
      }
      
      return temp;
   }
}