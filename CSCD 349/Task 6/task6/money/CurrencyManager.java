package task6.money;

import java.util.*;

public class CurrencyManager {

   private int profit = 0;

   public CurrencyManager() {
   }
   
   public Money getExchangeProfit() {
   
      return new Money(profit);
   }
   
   public List<A_Currency> makeChange(Money amount) {
   
      List<A_Currency> money = new LinkedList<A_Currency>();
      
      int remainingChange = amount.getCentsTotal();
      
      if(remainingChange >= 100) {
         
         for(int count = remainingChange / 100; count > 0; count--) {
         
            money.add(new CurrencyCoinDollar_1());
            
            remainingChange -= 100;
         }         
      }
      
      if(remainingChange >= 25) {
         
         for(int count = remainingChange / 25; count > 0; count--) {
         
            money.add(new CurrencyCoinCent_25());
            
            remainingChange -= 25;
         }         
      }
      
      if(remainingChange >= 10) {
         
         for(int count = remainingChange / 10; count > 0; count--) {
         
            money.add(new CurrencyCoinCent_10());
            
            remainingChange -= 10;
         }         
      }
      
      if(remainingChange >= 5) {
         
         for(int count = remainingChange / 5; count > 0; count--) {
         
            money.add(new CurrencyCoinCent_5());
            
            remainingChange -= 5;
         }         
      }
      
      if (remainingChange < 0)
         remainingChange = 0;
      
      profit += remainingChange;
      
      return Collections.unmodifiableList(money);
   }
   
   public Money sumCurrency(List<A_Currency> denominations) {
   
      Money sum = new Money(0);
      
      for(int i = 0; i < denominations.size(); i++) {
      
         sum = sum.add(denominations.get(i).getValue());
      }
      
      return sum;
   }
}