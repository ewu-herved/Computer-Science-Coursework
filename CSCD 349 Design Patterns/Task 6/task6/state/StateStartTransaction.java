package task6.state; 
import task6.Transaction;
import task6.money.*;
import java.util.List;

public class StateStartTransaction extends A_State {

   public StateStartTransaction() {
   
      super(new Transaction());
   }
   
   @Override
   public StateReturnRefund doReturnRefund() {
      
      CurrencyManager manager = new CurrencyManager();
      
      List refund = manager.makeChange(getTransaction().getMoneyTendered());
      
      for(int i = 0; i < refund.size(); i++) {
      
         System.out.println("[MACHINE] refunded\n -> " + refund.get(i).toString());
      }
      
      return new StateReturnRefund(getTransaction());
   }
   
   @Override
   public StateBuildCoffeeBaseDecaf doSelectCoffeeBaseDecaf() {
   
      return new StateBuildCoffeeBaseDecaf(getTransaction());
   }
   
   @Override
   public StateBuildCoffeeBaseRegular doSelectCoffeeBaseRegular() {
   
      return new StateBuildCoffeeBaseRegular(getTransaction());
   }
   
   @Override
   public void insertMoney(A_Currency denomination) {
      
      if(denomination == null)
         throw new RuntimeException("null value given in method insertMoney\n");
         
      getTransaction().addMoneyTendered(denomination);
   }
}