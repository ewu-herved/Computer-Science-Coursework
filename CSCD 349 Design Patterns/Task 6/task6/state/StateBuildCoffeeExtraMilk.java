package task6.state; 
import task6.Transaction;
import task6.ingredient.*;

public class StateBuildCoffeeExtraMilk extends A_StateBuildCoffeeExtra {

   public StateBuildCoffeeExtraMilk(Transaction transaction) {
   
      super(transaction);
      
      A_Ingredient extra = new IngredientExtraMilk(getTransaction().getIngredientOuter());
      
      getTransaction().updateIngredientOuter(extra);
   }
}