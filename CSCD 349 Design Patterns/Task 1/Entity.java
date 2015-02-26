import java.lang.Exception;

abstract class Entity {

   private String id;
   private String mode;
   
   public Entity(String id, String mode) {
   
      this.id = id;
      this.mode = mode;
   }
   
   public String getId() {
   
      return id;
   }
   
   public void move() {
   
      System.out.println(id + " moves by " + mode + "\n");
   }
   
   abstract void initiateAttack(Entity attacked) throws Exception;
   
   public void receiveAttack(Entity attacker) {
   
      System.out.println(attacker.getId() + " received attack from " + getId() + "\n");
   } 
}