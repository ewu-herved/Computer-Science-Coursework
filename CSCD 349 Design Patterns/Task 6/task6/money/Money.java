package task6.money;

public class Money implements Comparable<Money>{

   private int cents = 0;
   
   private boolean isPositive = true;   
   
   public Money() {}
   
   public Money(int cents) {
   
      this.cents = cents;
      
      if(cents < 0)
         isPositive = false;
   }
   
   public Money(int dollars, int cents) {
   
      this.cents = dollars * 100 + cents;
      
      if(cents < 0)
         isPositive = false;
   }
   
   public Money(int dollars, int cents, boolean isPositive) {
   
      this.cents = dollars * 100 + cents;
      this.isPositive = isPositive;
      if(isPositive == false)
         cents *= -1;
   }
   
   public Money add(Money money) {
   
      return new Money(this.getCentsTotal() + money.getCentsTotal());
   }
   
   @Override
   public int compareTo(Money money) {
   
      return this. getCentsTotal() - money.getCentsTotal();
   }
   
   public boolean equals(Money money) {
   
      if(this.getCentsTotal() == money.getCentsTotal())
         return true;
         
      return false;
   }
   
   public int getCentsOfDollar() {
   
      return cents % 100;
   }
   
   public int getCentsTotal() {
   
      return cents;
   }
   
   public int getDollars() {
   
      return cents / 100;
   }

   public int hashcode() {
   
      return cents * (cents + 3) % 7;
   }
   
   public boolean isNegative() {
   
      if(isPositive() || cents == 0)
         return false;
      
      return true;
   }
   
   public boolean isPositive() {
   
      if(cents == 0)
         return false;
   
      return isPositive;
   }
   
   public boolean isZero() {
   
      if(cents == 0)
         return true;
         
      return false;
   }
   
   public Money subtract(Money money) {
   
      return new Money(cents - money.getCentsTotal());   
   }
   
   @Override
   public String toString() {
   
      String tempCents = "0" + getCentsOfDollar();
         
      return String.format("$%d.%s", getDollars(), tempCents.substring(tempCents.length() - 2));
   }
}

