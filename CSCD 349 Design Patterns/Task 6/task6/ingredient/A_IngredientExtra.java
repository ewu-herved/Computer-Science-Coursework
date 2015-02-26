package task6.ingredient;
import task6.money.Money;

public abstract class A_IngredientExtra extends A_Ingredient {

   public A_IngredientExtra(Money cost, String description, A_Ingredient ingredientWrapped) {
   
      super(cost, description, ingredientWrapped);
   }
}