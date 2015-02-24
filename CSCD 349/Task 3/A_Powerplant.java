public abstract class A_Powerplant extends A_Entity {

   private A_Vehicle host;
   
   public A_Powerplant (String id) {
   
      super(id);   
   }
   
   public void setHost(A_Vehicle vehicle) {
   
      if(hasHost())     
         throw new RuntimeException(getID() + " already installed in " + getHost().getID() + "\n");
   
      host = vehicle;
   }
   
   public A_Vehicle getHost() {
   
      if(hasHost() == false)      
         throw new RuntimeException(getID() + " has not been installed.\n");
         
      return host;
   }
   
   public void removeHost() {
   
      if(hasHost() == false)      
         throw new RuntimeException(getID() + " has not been installed.\n");
      
      host = null;
   }
   
   public boolean hasHost() {
   
      if(host != null)      
         return true;
      
      return false;   
   }
   
   public abstract String generate();
}