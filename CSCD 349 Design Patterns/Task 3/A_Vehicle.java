//prototype for all vehicles 

public abstract class A_Vehicle extends A_Entity{
   
   protected String idSalted;//unique identifier created on instantiation by program
   
   protected A_Powerplant powerplant;//object responsible for allowing vehicle to move
      
   public A_Vehicle(String id, A_Powerplant powerplant) {
   
      super(id);
      
      IdentifierSaltManager salter = IdentifierSaltManager.getInstance();
      
      idSalted = salter.getIDSalted(id);
      
      installPowerplant(powerplant);
   }
   
   public String getIDSalted() {      
      
      return idSalted;
   }
   
   public A_Powerplant getPowerplant() {
   
      if(hasPowerplant() == false)    
         throw new RuntimeException("no installed primary powerplant\n");
   
      return powerplant;
   }
   
   public void removePowerplant() {
   
      if(hasPowerplant() == false)      
         throw new RuntimeException("No installed primary powerplant\n");
         
      powerplant.removeHost();
      powerplant = null;  
   }
   
   public void installPowerplant(A_Powerplant powerplant) {
   
      if(hasPowerplant())      
         throw new RuntimeException("powerplant " + powerplant.getID() + " already installed\n");
         
      powerplant.setHost(this);
      this.powerplant = powerplant;
   }
   
   public boolean hasPowerplant() {
   
      if(powerplant != null)
         return true;
         
      return false;
   }
   
   public void move() {
   
      if (hasPowerplant() == false)
            System.out.println("no powerplant\n");
            
      else
            
         System.out.println(getIDSalted() + ": " + powerplant.generate() + "\n");
   }
}