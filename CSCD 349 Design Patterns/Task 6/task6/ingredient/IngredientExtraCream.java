package task6.ingredient;
import task6.money.Money;

public class IngredientExtraCream extends A_IngredientExtra {

   public IngredientExtraCream(A_Ingredient ingredientWrapped) {
   
      super(new Money(20), "cream", ingredientWrapped);
   }
}