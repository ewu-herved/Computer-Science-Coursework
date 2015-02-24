public class Accountant extends Employee{

   private double parkingAllowance;
   
   public Accountant(String name, double parkingAllowance) {
   
      this.name = name;
      
      this.parkingAllowance = parkingAllowance;
   }
   
   @Override
   protected void reportSalary() {
   
      System.out.println("I am an accountant. I make $" + getSalary() + 
                         "K per year plus a parking allowance of $" + String.format("%.2f", getParking()));  
   }
   
   protected double getParking() {
   
      return parkingAllowance;   
   }
}