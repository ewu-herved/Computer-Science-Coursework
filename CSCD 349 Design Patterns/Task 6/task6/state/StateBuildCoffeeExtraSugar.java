package task6.state; 
import task6.Transaction;
import task6.ingredient.*;

public class StateBuildCoffeeExtraSugar extends A_StateBuildCoffeeExtra {

   public StateBuildCoffeeExtraSugar(Transaction transaction) {
   
      super(transaction);
      
      A_Ingredient extra = new IngredientExtraSugar(getTransaction().getIngredientOuter());
      
      getTransaction().updateIngredientOuter(extra);
   }
}