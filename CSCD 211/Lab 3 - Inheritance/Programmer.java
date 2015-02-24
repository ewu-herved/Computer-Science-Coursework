public class Programmer extends Employee{

   private boolean busPass;
   
   public Programmer(String name, boolean busPass) {
   
      this.name = name;
      
      this.busPass = busPass;
   }
   
   @Override
   protected void reportSalary() {
   
      System.out.println("I am a programmer. I make $" + (getSalary() + 20) + "K per year and I" + 
      ((getBusPass())?" get a bus pass.":" do not get a bus pass."));   
   }
   
   protected boolean getBusPass() {
   
      return busPass;   
   }
}