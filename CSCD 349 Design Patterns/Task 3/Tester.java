public class Tester {

   public static void main(String[] args) {
   
       ShipDestroyer destroyer = new ShipDestroyer("Defiance", new PowerplantGasTurbine("Old Faithful"));
       
       destroyer.move();
       
       System.out.println(destroyer.getPowerplant().getID() + "\n");
       
       A_Powerplant shelf = destroyer.getPowerplant();
       
       System.out.println(shelf.getID() + "\n");
       
       destroyer.removePowerplant();
       
       //System.out.println(shelf.getHost().getID() + "\n");
       
       destroyer.installPowerplant(new PowerplantNuclear("Fat Daddy"));
       
       destroyer.move();
       
       System.out.println(destroyer.getPowerplant().getHost().getID() + "\n");
       
       SubmarineUBoat uboat = new SubmarineUBoat("Dachshund", new PowerplantElectric("Shocker"), new PowerplantTurbofan("Zephyr"));
       
       uboat.move();
       
       uboat.isPrimaryOrSecondary(false);
       
       uboat.move();
       
       System.out.println(uboat.getPowerplantSecondary().getHost().getID() + "\n");
       
       uboat.removePowerplantSecondary();
       
       //uboat.removePowerplantSecondary();
       
       
       
       //uboat.move();
       
       uboat.isPrimaryOrSecondary(true);
       
       uboat.move();
       
       IdentifierSaltManager salter = IdentifierSaltManager.getInstance();
       
       System.out.println("" + salter.getSaltNext());
       
       
   }

}