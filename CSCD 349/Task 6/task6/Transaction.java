package task6;
import task6.money.*;
import task6.ingredient.*;
import java.util.*;

public class Transaction {

   private Money moneyTendered;
   
   private A_Ingredient ingredientOuter = null;
   
   public Transaction() {
   
      moneyTendered = new Money(0);
   }
   
   public Transaction(Money moneyTendered) throws NullPointerException {
      
      if(moneyTendered == null) {
      
         throw new NullPointerException("No Money ojbect given\n");
      }
      
      this.moneyTendered = moneyTendered;
   }
   
   public Money addMoneyTendered(A_Currency money) {
   
      moneyTendered = money.getValue().add(moneyTendered);
      
      return moneyTendered;
   }
   
   public A_Ingredient getIngredientOuter() throws RuntimeException {
   
      if(ingredientOuter == null) {
      
         throw new RuntimeException("no outer ingredient\n");
      }
      
      return ingredientOuter;
   }
   
   public Money getMoneyTendered() {
      
      return moneyTendered;
   }
   
   public Money getProductCost() throws RuntimeException {
   
      if(ingredientOuter == null) {
      
         throw new RuntimeException("no product is currently being built\n");
      }
   
      return ingredientOuter.getCostTotal();
   }
   
   public boolean hasIngredientOuter() {
   
      if(ingredientOuter == null)
         return false;
         
      return true;
   }
   
   @Override
   public String toString() {
   
      if(ingredientOuter == null)
         return "moneyTendered=" + moneyTendered.toString() + " ingredientOuter=null";
   
      return "moneyTendered=" + moneyTendered.toString() + " ingredientOuter=" + ingredientOuter.toString();
   }
   
   public List<A_Ingredient> unrollProduct() {
   
      if(ingredientOuter == null)
         throw new RuntimeException("no product has been given\n");
         
      return ingredientOuter.getIngredients();
   }
   
   public void updateIngredientOuter(A_Ingredient ingredient) {
   
      ingredientOuter = ingredient;
   }
}