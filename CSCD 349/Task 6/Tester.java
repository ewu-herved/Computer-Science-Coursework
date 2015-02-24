import task6.money.*;
import task6.*;
import task6.state.*;
import java.util.*;

public class Tester {

   public static void main(String[] args) {
   
      A_State machine = new StateStartTransaction();
      
      A_Currency monies = new CurrencyPaperDollar_5();
      
      machine.insertMoney(monies);
      
      machine = machine.doSelectCoffeeBaseRegular();
      
      machine = machine.doSelectExtraCream();
      
      machine = machine.doDeliverProduct();
      
      machine = machine.doReturnChange();
      
      machine = machine.doStartTransaction();
      
      machine.insertMoney(monies);
      
      machine = machine.doSelectCoffeeBaseRegular();
      
      machine = machine.doStartTransaction();
      
      machine = machine.doSelectExtraCream();
      
      machine = machine.doSelectExtraMilk();
      
      machine = machine.doSelectExtraSugar();
      
      machine = machine.doReturnRefund();
      
      machine = machine.doReturnChange();
   }   
}