public class SubmarineUBoat extends A_Vehicle {

   private A_Powerplant secondaryPlant;
   
   private boolean primeActive;

   public SubmarineUBoat(String id, A_Powerplant primaryPlant, A_Powerplant secondaryPlant) {
   
      super(id, primaryPlant);
      
      installPowerplantSecondary(secondaryPlant);
      
      primeActive = true; 
   }
   
   public A_Powerplant getPowerplantPrimary() {
   
      return getPowerplant();   
   }
   
   public A_Powerplant getPowerplantSecondary() {
   
      if(hasPowerplantSecondary() == false)    
         throw new RuntimeException("no installed secondary powerplant\n");
   
      return secondaryPlant;
   } 
   
   public void isPrimaryOrSecondary(boolean primeOrSecond) {
   
      if(primeOrSecond)
         primeActive = true;   
      
      else {
      
         primeActive = false;
      }
   }
   
   public boolean isPrimaryOrSecondary() {
   
      return primeActive;   
   }
   
   public void removePowerplantPrimary() {
   
      removePowerplant(); 
   }
   
   public void removePowerplantSecondary() {
   
      if(hasPowerplantSecondary() == false)      
         throw new RuntimeException("No installed secondary powerplant\n");
         
      secondaryPlant.removeHost();
      secondaryPlant = null;     
   }
   
   public boolean hasPowerplantPrimary() {
   
      return hasPowerplant();
   }
   
   public boolean hasPowerplantSecondary() {
   
      if(secondaryPlant != null)
         return true;
         
      return false;
   }
   
   public void installPowerplantPrimary(A_Powerplant powerplant) {
   
      installPowerplant(powerplant);
   }
   
   public void installPowerplantSecondary(A_Powerplant secondaryPlant) {
   
      if(hasPowerplantSecondary())      
         throw new RuntimeException("powerplant " + secondaryPlant.getID() + " already installed\n");
         
      secondaryPlant.setHost(this);
      this.secondaryPlant = secondaryPlant;
   }
   
   @Override
   public void move() {
   
      if(isPrimaryOrSecondary()) {
      
         if (hasPowerplantPrimary() ==  false)
            System.out.println("no powerplant\n");
            
         else
            System.out.println(getIDSalted() + ": " + getPowerplantPrimary().generate() + "\n");
         
      }
      
      else {
      
         if (hasPowerplantSecondary() == false)
            System.out.println("no powerplant\n");
            
         else            
            System.out.println(getIDSalted() + ": " + secondaryPlant.generate() + "\n");
      }
   }      
}