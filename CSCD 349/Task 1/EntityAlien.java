public class EntityAlien extends EtherealEntity {

   public EntityAlien(String id) {
   
      super(id, "teleporting");
   }
   
   public void initiateAttack(Entity attacked) {
      
      System.out.println(getId() + " initiated raygun attack against " + attacked.getId() + "\n");
      receiveAttack(attacked);      
   }
}  