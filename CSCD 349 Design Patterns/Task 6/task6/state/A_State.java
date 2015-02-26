package task6.state;
import task6.Transaction;
import task6.money.*;

public abstract class A_State {

   private Transaction transaction;
   
   public A_State(Transaction transaction) {
   
      if(transaction == null) {
      
         throw new RuntimeException("no transaction given\n");
      }
      
      this.transaction = transaction;
   }
   
   public StateDeliverProduct doDeliverProduct() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateReturnChange doReturnChange() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateReturnRefund doReturnRefund() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateBuildCoffeeBaseDecaf doSelectCoffeeBaseDecaf() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateBuildCoffeeBaseRegular doSelectCoffeeBaseRegular() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateBuildCoffeeExtraCream doSelectExtraCream() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateBuildCoffeeExtraMilk doSelectExtraMilk() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateBuildCoffeeExtraSugar doSelectExtraSugar() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public StateStartTransaction doStartTransaction() {
   
      throw new RuntimeException("Wrong State\n");
   }
   
   public Transaction getTransaction() {
   
      return transaction;
   }
   
   public void insertMoney(A_Currency denomination) {
      
      throw new RuntimeException("Wrong State\n"); 
   }
   
   @Override
   public String toString() {
   
      return getClass().getSimpleName() + "{transaction=" + transaction.toString() + "}";
   }
}