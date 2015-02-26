package task6.state; 
import task6.Transaction;
import task6.ingredient.*;

public class StateBuildCoffeeBaseDecaf extends A_StateBuildCoffeeBase {

   public StateBuildCoffeeBaseDecaf(Transaction transaction) {
   
      super(transaction);
      
      A_Ingredient coffee = new IngredientBaseCoffeeDecaf();
      
      getTransaction().updateIngredientOuter(coffee);
   }
}