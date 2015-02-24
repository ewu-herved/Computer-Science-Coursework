public class EntityDawg extends CorporealEntity {

   public EntityDawg(String id) {
   
      super(id, "walking");
   }
   
   public void initiateAttack(Entity attacked) {
   
      if(attacked instanceof EtherealEntity) {
      
         System.out.println("Although " + getId() + " sees a malevolent presence before him, " +
         "he bites in vain as " + attacked.getId() + " exists beyond the corporeal world...");
      }
      
      else {
   
         System.out.println(getId() + " initiated biting attack against " + attacked.getId());
         receiveAttack(attacked);
      }
   }  
}