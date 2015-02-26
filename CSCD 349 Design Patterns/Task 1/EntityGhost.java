public class EntityGhost extends EtherealEntity {

   public EntityGhost(String id) {
   
      super(id, "floating");
   }
   
   public void initiateAttack(Entity attacked) throws Exception {
   
      if(attacked instanceof EtherealEntity) {
      
         throw new Exception("Invalid attack: cannot attack ethereal entities.\n");
      }
      
      else {
   
         System.out.println(getId() + " initiated supernatural attack against " + attacked.getId() + "\n");
         receiveAttack(attacked);
      }
   }
}  