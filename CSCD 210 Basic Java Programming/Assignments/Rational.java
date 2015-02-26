//Dan Herve
//Assignment 6: Rational Numbers
//No known shortcomings

public class Rational implements Comparable<Rational> { //Rational object with compareTo

   private int num; //Rationals have a numerator and a denomenator

   private int den;

   public Rational() { //DVC
   
      num = 1;
   
      den = 1;   
   }
   
   public Rational(int num, int den) { //EVC
   
      this.num = num;
      
      this.den = den;
      
      reduce(num, den);
   }
   
   public int getNum() { 
   
      return num;
   }
   
   public int getDen() {
   
      return den;
   }
   
   public void setNum(int newNum) {
   
      num = newNum;
   }
   
   public void setDen(int newDen) {
   
      den = newDen;
   }
   
   @Override
   public String toString() {

      return "" + num + "/" + den;
   }
   
   @Override
   public boolean equals(Object obj) {
   
      if (this.getClass().getSimpleName().equals(obj.getClass().getSimpleName())) {
      
         Rational that = (Rational)obj;
         
         if (this.num == that.num && this.den == that.den) {
         
            return true;
         }
      }
         
         return false;
   }
   
   @Override
   public int compareTo(Rational that) { //compares based on the difference of two Rationals
   
      if (this.num == that.num && this.den == that.den)
      
         return 0;
         
      int difference = this.num * that.den - this.den * that.num;
      
      return difference;    
   }
   
   public static Rational addRational(Rational r1, Rational r2) { //Adds rationals together
   
     int newDen = r1.den * r2.den;
     
     int newNum = r1.num * r2.den + r2.num * r1.den; 
     
     Rational newRational = new Rational(newNum, newDen);
      
     return newRational;
     
   }
   
   public static Rational subRational(Rational r1, Rational r2) { //Subtracts rationals
   
     int newDen = r1.den * r2.den;
     
     int newNum = r1.num * r2.den - r2.num * r1.den; 
     
     Rational newRational = new Rational(newNum, newDen);
      
     return newRational;     
   }
   
   private void reduce(int num, int den) { //reduces rationals to lowest values
   
      int temp;
      
      num = Math.abs(num);
      
      den = Math.abs(den);
      
      while (den != 0) {
      
         if (num > den) {
         
            num -= den;  
         }
         
         else 
         
            den -= num;  
         }
               
      this.num /= num;
      
      this.den /= num;           
      }
}