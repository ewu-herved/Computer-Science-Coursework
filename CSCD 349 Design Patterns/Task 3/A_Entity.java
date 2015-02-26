import java.lang.Exception;

public abstract class A_Entity {

   private String id; //non-unique identifier specified on creation by user
   
   public A_Entity(String id) {
   
      this.id = id;   
   }
   
   public String getID() {
   
      return id;
   }
}