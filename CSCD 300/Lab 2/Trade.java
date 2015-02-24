public class Trade {

   public int in;
   
   public int out;
   
   public int profit;
   
   public Trade() {
   
      in = 0;
      
      out = 0;
      
      profit = 0;
   }
   
   public Trade(int in, int out, int profit) {
   
      this.in = in;
      
      this.out = out;
      
      this.profit = profit;
   }
   
   @Override
   public String toString() {
   
      return "[" + in + ", " + out + ", " + profit + "]";
   }
}