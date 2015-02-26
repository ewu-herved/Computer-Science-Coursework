//Dan Herve
//Assignment 3: LongInteger Calculator
//No known shortcomings; completed all extra credit

import java.util.*;

public class OctalInteger extends LongInteger {

   private int[] octal;
   
   private boolean negative = false;
   
   public OctalInteger() {
   
      octal = new int[1];
   }
   
   public OctalInteger(long value) {
   
      super(value);
      
      if (value < 0) {
      
         negative = true;
      }
      
      octal = convertToOctal(super.getValue());
   }
   
   public OctalInteger(String octalInput) {
      
      if (octalInput.substring(0, 1).equals("-")) {
      
         octalInput = octalInput.substring(1);
         
         negative = true;
      }
      
      octal = new int[octalInput.length()];
      
      for (int i = 0; i < octal.length; i++) {
      
         octal[i] = octalInput.charAt(i) - '0';
      }
      
      if (negative) {
      
         for (int i = 0; i < octal.length; i++) {
         
            octal[i] *= -1;
         }
      }
      
      if (validateOctal(octal) == false) {
      
         throw new InputMismatchException("Not an octal number");
      }
      
      value = octalToDecimal(octal);
   }
   
   public int[] getOctal() {
   
      return octal;
   }
   
   private int[] convertToOctal(long that) { //converts longs to an array representation of an octal
   
      double decimal = that;
      
      if (negative) {
         
         decimal *= -1;
      }
      
      int count = 0;
      
      long power;
      
      long remainder = (long) decimal;
      
      while (decimal >= 1.0) {
      
         decimal /= 8;
         count++;
      }
      
      int[] octalFormat = new int[count];
      
      if (count == 0) {
      
         octalFormat = new int[1];
      }
      
      for (int i = 0; i < octalFormat.length; i++) {
      
         power = (long) (Math.pow(8, octalFormat.length - i -1));  
         
         if (remainder > 0 && power <= remainder) {
         
            octalFormat[i] = (int) (remainder / power);
            
            remainder -= (power * octalFormat[i]) ;
         }
         
         else {
         
            octalFormat[i] = 0;
         }
      }
      
      if (negative) {
      
         for (int i = 0; i < octalFormat.length; i++) {
         
            octalFormat[i] *= -1;
         }
      }
            
      return octalFormat;  
   }
   
   private long octalToDecimal(int[] octal) { //converts array representation of an octal to a long
   
      long decimal = 0;
      
      for (int i = 0; i < octal.length; i++) {
      
         if (octal[i] != 0) {
         
            decimal += octal[i] * Math.pow(8, octal.length - i - 1);
         }            
      }
      
      super.value = decimal;
      
      return super.value;
   }
   
   @Override
   public String toString() {
   
      String string = "";
      
      if (negative) {
      
         string += "-";
      }
      
      for (int x: octal) {
          
         String number = "" + x;
            
         if (negative && x != 0) {
            
            number = number.substring(1);
         }
          
         string += number;
      }
          
      return string;
   }   
   
   public OctalInteger addOctal(LongInteger that) {
   
      long decSum = (this.addInt(that)).getValue();
      
      OctalInteger sum = new OctalInteger(decSum);
      
      return sum;
   }
   
   public OctalInteger subOctal(OctalInteger that) {
   
      long decDiff = (this.subInt(that)).getValue();
      
      OctalInteger difference = new OctalInteger(decDiff);
      
      return difference;
   }
   
   public OctalInteger multOctal(OctalInteger that) {
   
      long decProd = (this.multInt(that)).getValue();
      
      OctalInteger product = new OctalInteger(decProd);
      
      return product;
   }
   
   public OctalInteger divOctal(OctalInteger that) {
   
      long decQuo = (this.divInt(that)).getValue();
      
      OctalInteger quotient = new OctalInteger(decQuo);
      
      return quotient;
   }
   
   private boolean validateOctal(int[] octal) { //validates octal arrays
   
      for (int i = 0; i < octal.length; i++) {
      
         if (octal[i] > 7 || octal[i] < - 7) {
         
            return false;
         }
      }
      
      return true;
   }
}