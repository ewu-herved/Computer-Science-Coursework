public class EntityTree extends CorporealEntity{

   public EntityTree(String id) {
   
      super(id, "swaying");
   }
   
   public void initiateAttack(Entity attacked) throws Exception {
   
      throw new Exception(getId() + " cannot attack. It is a tree...\n");        
   } 
}