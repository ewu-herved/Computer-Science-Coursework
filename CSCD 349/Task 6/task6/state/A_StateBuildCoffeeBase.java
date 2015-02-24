package task6.state; 
import task6.Transaction;

public abstract class A_StateBuildCoffeeBase extends A_State {

   public A_StateBuildCoffeeBase(Transaction transaction) {
   
      super(transaction);
   }
   
   @Override
   public StateDeliverProduct doDeliverProduct() {
   
      if(getTransaction().getMoneyTendered().compareTo(getTransaction().getProductCost()) < 0)
         throw new RuntimeException("Money tendered is less than product cost\n");
   
      return new StateDeliverProduct(getTransaction());
   }
   
   @Override
   public StateReturnRefund doReturnRefund() {
   
      return new StateReturnRefund(getTransaction());
   }
   
   @Override
   public StateBuildCoffeeExtraCream doSelectExtraCream() {
   
      return new StateBuildCoffeeExtraCream(getTransaction());
   }
   
   @Override
   public StateBuildCoffeeExtraMilk doSelectExtraMilk() {
   
      return new StateBuildCoffeeExtraMilk(getTransaction());
   }
   
   @Override
   public StateBuildCoffeeExtraSugar doSelectExtraSugar() {
   
      return new StateBuildCoffeeExtraSugar(getTransaction());
   }
}