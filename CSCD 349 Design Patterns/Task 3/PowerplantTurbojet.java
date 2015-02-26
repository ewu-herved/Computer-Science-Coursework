public class PowerplantTurbojet extends A_Powerplant {

   public PowerplantTurbojet(String id) {
      
      super(id);
   }
      
   public String generate() {
   
      return "exhausting a jet\n";
   }
}