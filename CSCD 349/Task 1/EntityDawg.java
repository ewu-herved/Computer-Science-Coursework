public class EntityDawg extends CorporealEntity {

   public EntityDawg(String id) {
   
      super(id, "walking");
   }
   
   public void initiateAttack(Entity attacked) throws Exception {
   
      if(attacked instanceof EtherealEntity) {
      
         throw new Exception("Invalid attack: cannot attack ethereal entities.\n");
      }
      
      else {
   
         System.out.println(getId() + " initiated biting attack against " + attacked.getId() + "\n");
         receiveAttack(attacked);
      }
   }  
}