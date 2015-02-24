package task6.state; 
import task6.Transaction;
import task6.ingredient.*;

public class StateBuildCoffeeBaseRegular extends A_StateBuildCoffeeBase {

   public StateBuildCoffeeBaseRegular(Transaction transaction) {
   
      super(transaction);
      
      A_Ingredient coffee = new IngredientBaseCoffeeRegular();
      
      getTransaction().updateIngredientOuter(coffee);
   }
}