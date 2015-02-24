public class PowerplantElectric extends A_Powerplant {

   public PowerplantElectric(String id) {
   
      super(id);
   }
      
   public String generate() {
   
      return "generating electricity\n";
   }
}