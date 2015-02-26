package task6.ingredient;
import task6.money.Money;

public class IngredientExtraMilk extends A_IngredientExtra {

   public IngredientExtraMilk(A_Ingredient ingredientWrapped) {
   
      super(new Money(55), "milk", ingredientWrapped);
   }
}