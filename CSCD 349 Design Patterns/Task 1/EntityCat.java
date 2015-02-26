public class EntityCat extends CorporealEntity {

   public EntityCat(String id) {
   
      super(id, "slinking");
   }
   
   public void initiateAttack(Entity attacked) throws Exception {
   
      if(attacked instanceof EtherealEntity) {
      
         throw new Exception("Invalid attack: cannot attack ethereal entities.\n");
      }
      
      else {
   
         System.out.println(getId() + " initiated clawing attack against " + attacked.getId() + "\n");
         receiveAttack(attacked);
      }
   }  
}