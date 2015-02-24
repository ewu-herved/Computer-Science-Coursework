import java.awt.Point;
import java.util.*;

public class ShapeDot extends A_Shape {

   private Point origin;
   
   public ShapeDot(String id, Point origin) {
   
      super(id);
      
      if(origin == null)
         throw new NullPointerException("No point given\n");
      
      this.origin = origin;
   }
   
   public Point getOrigin() {
   
      return origin;
   }
   
   public void setOrigin(Point origin) {
   
      if(origin == null)
         throw new NullPointerException("No point given\n");
   
      this.origin = origin;
      getContainer().update();
   }
   
   public List<Point> update() {
   
      List<Point> temp = new LinkedList<Point>();
      
      if(hasContainer()) {
      
         Point absolute = getContainer().calculatePointAbsolute(origin);
         
         if(getContainer().isRenderable(absolute))
            temp.add(absolute);
      }
      
      return temp;
   }
}