//Dan Herve
//Assignment 3: LongInteger Calculator
//No known shortcomings; completed all extra credit

public class LongInteger {

   protected long value;
   
   public LongInteger() {
   
      value = 0;
   }
   
   public LongInteger(long value) {
   
      this.value = value;
   }
   
   public long getValue() {
   
      return value;
   }
   
   public void setValue(long value) {
   
      this.value = value;
   }
   
   @Override
   public String toString() {
   
      return "" + value;
   }

   public LongInteger addInt(LongInteger that) {
   
      long sum = this.value + that.value;
      
      return new LongInteger(sum);
   }
   
   public LongInteger subInt(LongInteger that) {
   
      long difference = this.value - that.value;
      
      return new LongInteger(difference);
   }
   
   public LongInteger multInt(LongInteger that) {
   
      long product = this.value * that.value;
      
      return new LongInteger(product);
   }
   
   public LongInteger divInt(LongInteger that) {
   
      long quotient = this.value / that.value;
      
      return new LongInteger(quotient);
   }
}