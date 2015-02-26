package task6.ingredient;
import task6.money.Money;

public class IngredientExtraSugar extends A_IngredientExtra {

   public IngredientExtraSugar(A_Ingredient ingredientWrapped) {
   
      super(new Money(14), "sugar", ingredientWrapped);
   }
}