import java.awt.Point;
import java.awt.Dimension;
import java.util.*;

abstract class A_Container extends A_Entity {

    private Point origin;

    private Dimension size;
    
    private List<A_Entity> children = new LinkedList<A_Entity>();

    public A_Container(String id, Point origin, Dimension size) {

        super(id);
        
        if(origin == null) {
        
           throw new NullPointerException("No point of origin given\n");
        }

        this.origin = origin;
        
        if(size == null) 
           throw new NullPointerException("No dimensions given\n");

        this.size = size;
    }
    
    public Point getOrigin() {
    
      return origin;
   }
   
   public Dimension getSize() {
   
      return size;
   }
   
   public void addEntity(A_Entity child) {
   
      if(child == null)
         throw new NullPointerException("No entity given\n");
   
      children.add(child);
      child.setContainer(this);
   }
   
   public void removeEntity(String id) {
   
      for(int i = 0; i < children.size(); i++) {
      
         if(children.get(i).getID().compareTo(id) == 0)
            children.get(i).releaseContainer();
            children.remove(i);            
      }
   }
   
   public boolean hasEntity(String id) {
   
      for(int i = 0; i < children.size(); i++) {
      
         if(children.get(i).getID().compareTo(id) == 0)
            return true;
      }
      
      return false;
   }
   
   public A_Entity getEntity(String id) {
   
      for(int i = 0; i < children.size(); i++) {
      
         if(children.get(i).getID().compareTo(id) == 0)
            return children.get(i);
      }
      
      return null;
   }

   public List<A_Entity> getEntities() {
   
      return children;
   }
   
   public void setOrigin(Point origin) {
   
      if(origin == null)
         throw new NullPointerException("No point given\n");
   
      this.origin = origin;
      if (hasContainer())
         update();
   }
   
   public void setSize(Dimension size) {
   
      if(size == null)
         throw new NullPointerException("No dimension given\n");
   
      this.size = size;
      if (hasContainer())
         update();
   }
   
   public List<Point> update() {
   
      List<Point> points = new LinkedList<Point>();
   
      for(int i = 0; i < children.size(); i++) {
            
         points.addAll(children.get(i).update());         
      }
      
      return points;
   }
   
   public boolean isRenderable(Point point) {
   
      if (origin.getX() <= point.getX() && (size.getWidth() + origin.getX()) >= point.getX()
      && origin.getY() <= point.getY() && (size.getHeight() + origin.getY()) >= point.getY())
         return true;
      
      return false;
   }
   
   public Point calculatePointAbsolute(Point point) {
   
      if(point == null)
         throw new NullPointerException("No point given\n");
   
      if(hasContainer() == false) {
      
         return new Point((int)(point.getX() - origin.getX()), (int)(point.getY() - origin.getY()));
      }
      
      return getContainer().calculatePointAbsolute(new Point((int)(point.getX() + getOrigin().getX()), (int)(point.getY() + origin.getY())));
   }
}
