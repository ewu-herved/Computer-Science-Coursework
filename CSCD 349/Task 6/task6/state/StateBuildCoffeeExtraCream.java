package task6.state; 
import task6.Transaction;
import task6.ingredient.*;

public class StateBuildCoffeeExtraCream extends A_StateBuildCoffeeExtra {

   public StateBuildCoffeeExtraCream(Transaction transaction) {
   
      super(transaction);
      
      A_Ingredient extra = new IngredientExtraCream(getTransaction().getIngredientOuter());
      
      getTransaction().updateIngredientOuter(extra);
   }
}