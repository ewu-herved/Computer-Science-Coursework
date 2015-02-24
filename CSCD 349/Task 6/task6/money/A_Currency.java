package task6.money;

public abstract class A_Currency implements Comparable<A_Currency> {

   private Money money;
   
   private String description;
   
   public A_Currency(Money money, String description) {
   
      this.money = money;
      this.description = description;
   }
   
   public Money add(A_Currency amount) {
   
      return money.add(amount.getValue());
   }
   
   public Money add(Money amount) {
   
      return money.add(amount);
   }
   
   @Override
   public int compareTo(A_Currency money) {
   
      return money.getValue().getCentsTotal() - this.money.getCentsTotal();
   }
   
   public String getDescription() {
   
      return description;
   }
   
   public Money getValue() {
   
      return money;
   }
   
   public Money subtract(A_Currency amount) {
   
      return money.subtract(amount.getValue());
   }
   
   public Money subtract(Money amount) {
   
      return money.subtract(amount);
   }
   
   @Override
   public String toString() {
   
      return money.toString() + "/" + description;
   }
}