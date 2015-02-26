package task6.state; 
import task6.Transaction;

public class StateDeliverProduct extends A_State {

   public StateDeliverProduct(Transaction transaction) {
   
      super(transaction);
      
      System.out.println("[Machine] delivered\n -> " + transaction.getIngredientOuter().getDescriptionTotal());
   }
   
   @Override
   public StateReturnChange doReturnChange() {
   
      return new StateReturnChange(getTransaction());
   }
}