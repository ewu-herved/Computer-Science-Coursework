//Dan Herve
//Assignment 1: Review
//No known shortcomings

public class Letter implements Comparable<Letter> { //class name

   private String toName;
   
   private Address toAddr;
   
   private String fromName;
   
   private Address fromAddr;
   
   private double weight;
   
   public Letter(String fromName, String fromStreet, String fromCity, String fromState, String fromZip, //evc
                 String toName, String toStreet, String toCity, String toState, String toZip, 
                 double weight) {
                 
      this.fromName = fromName;
      fromAddr = new Address(fromStreet, fromCity, fromState, fromZip);
      this.toName = toName;
      toAddr = new Address(toStreet, toCity, toState, toZip);
      this.weight = weight;
   }
   
   @Override
   public String toString() {
   
      int enter = toAddr.toString().indexOf("\n");
   
      return "From: " + fromName + "\t\t\t\t\t\t\t\t" + getPostage(weight) + "\n" + fromAddr.toString() +
             "\n\n\t\t\t\t" + toName + "\n\t\t\t\t" + toAddr.toString().replace("\n", "\n\t\t\t\t");
   }
   
   @Override
   public int compareTo(Letter that) { //compares by zip, then street
      
      if (this.toAddr.getZip().compareTo(that.toAddr.getZip()) == 0) {
      
         return this.toAddr.getStreet().compareTo(that.toAddr.getStreet());
      }
      
      return this.toAddr.getZip().compareTo(that.toAddr.getZip());      
   }
   
   private String getPostage(double weight) { //calculates the cost in stamps
   
      double postage = (int) (weight + 0.99) * .46;
      
      return String.format("%.2f", postage);
   } 
}