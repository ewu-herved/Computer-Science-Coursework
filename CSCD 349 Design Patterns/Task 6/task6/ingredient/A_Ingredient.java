package task6.ingredient;
import task6.money.Money;
import java.util.*;

public abstract class A_Ingredient {

   private Money cost;
   
   private String description;
   
   private A_Ingredient ingredientWrapped = null;
   
   public A_Ingredient(Money cost, String description) {
   
      this.cost = cost;
      this.description = description;
   }
   
   public A_Ingredient(Money cost, String description, A_Ingredient ingredientWrapped) {
   
      this.cost = cost;
      this.description = description;
      this.ingredientWrapped = ingredientWrapped;
   }
   
   public Money getCost() {
      
      return cost;
   }
   
   public Money getCostTotal() {
   
      if(ingredientWrapped == null) {
      
         return cost;
      }
   
      return cost.add(ingredientWrapped.getCostTotal());
   }
   
   public String getDescription() {
   
      return description;
   }
   
   public List<String> getDescriptionTotal() {
   
      List<String> descriptions = new LinkedList<String>();
      
      descriptions.add(description);
      
      if(ingredientWrapped == null) 
         return descriptions;
   
      descriptions.addAll(ingredientWrapped.getDescriptionTotal());
      
      return descriptions;
   }
   
   public List<A_Ingredient> getIngredients() {
   
      List<A_Ingredient> ingredients = new LinkedList<A_Ingredient>();
      
      if(ingredientWrapped == null) 
         return ingredients;
         
      ingredients.add(ingredientWrapped);
   
      ingredients.addAll(ingredientWrapped.getIngredients());
      
      return ingredients;   
   }
   
   public A_Ingredient getIngredientWrapped() {
   
      if(ingredientWrapped == null) {
      
         throw new NullPointerException("No ingredient wrapped\n");
      }
      
      return ingredientWrapped;
   }
   
   public boolean hasIngredientWrapped() {
   
      if(ingredientWrapped == null)
         return false;
         
      return true;
   }
   
   @Override
   public String toString() {
   
      return "" + getClass().getSimpleName() + "{cost=" + cost.toString() +
      " description=" + description + "}\n";
   }  
}