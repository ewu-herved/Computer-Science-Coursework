public class Lawyer extends Employee{

   private int stockShares;
   
   public Lawyer(String name, int stockShares) {
   
      this.name = name;
      
      this.stockShares = stockShares;
   }
   
   @Override
   protected void reportSalary() {
   
      System.out.println("I am a lawyer. I get $" + (getSalary() + 30) + "K per year, and I have " + 
                         getOptions() + " shares of stock."); 
   }
   
   protected int getOptions() {
   
      return stockShares;   
   }
}