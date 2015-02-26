//Dan Herve
//Assignment 3: LongInteger Calculator
//No known shortcomings; completed all extra credit

import java.util.*;

public class BinaryInteger extends LongInteger {

   private int[] binary;
   
   private boolean negative = false;
   
   public BinaryInteger() {
   
      binary = new int[1];
   }
   
   public BinaryInteger(long value) {
   
      super(value);
      
      if (value < 0) {
      
         negative = true;
      }
      
      binary = convertToBinary(super.getValue());
   }
   
   public BinaryInteger(String binaryInput) {
   
      if (binaryInput.substring(0, 1).equals("-")) {
      
         binaryInput = binaryInput.substring(1);
         
         negative = true;
      }
      
      binary = new int[binaryInput.length()];
      
      for (int i = 0; i < binary.length; i++) {
      
         binary[i] = binaryInput.charAt(i) - '0';
      }
      
      if (negative) {
      
         for (int i = 0; i < binary.length; i++) {
         
            binary[i] *= -1;
         }
      }
      
      if (validateBinary(binary) == false) {
      
         throw new InputMismatchException("Not a binary number");
      }
      
      value = binaryToDecimal(binary);
   }
   
   public int[] getBinary() {
   
      return binary;
   }
   
   private int[] convertToBinary(long that) { //converts longs to an array representation of a binary
   
      double decimal = that;
      
      if (negative) {
         
         decimal *= -1;
      }
      
      int count = 0;
      
      long power;
      
      long remainder = (long) decimal;
      
      while (decimal >= 1.0) {
      
         decimal /= 2;
         count++;
      }
      
      int[] binaryFormat = new int[count];
      
      if (count == 0) {
      
         binaryFormat = new int[1];
      }
      
      for (int i = 0; i < binaryFormat.length; i++) {
      
         power = (long) (Math.pow(2, binaryFormat.length - i -1));  
         
         if (remainder > 0 && power <= remainder) {
         
            binaryFormat[i] = (int) (remainder / power);
            
            remainder -= (power * binaryFormat[i]) ;
         }
         
         else {
         
            binaryFormat[i] = 0;
         }
      }
      
      if (negative) {
      
         for (int i = 0; i < binaryFormat.length; i++) {
         
            binaryFormat[i] *= -1;
         }
      }
            
      return binaryFormat;        
   }
   
   private long binaryToDecimal(int[] binary) { //converts array representation of a binary to a long
   
      long decimal = 0;
      
      for (int i = 0; i < binary.length; i++) {
      
         if (binary[i] != 0) {
         
            decimal += binary[i] * Math.pow(2, binary.length - i -1);
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
      
      for (int x: binary) {
      
         String number = "" + x;
            
         if (negative && x != 0) {
            
            number = number.substring(1);
         }
          
         string += number;
      }
          
      return string;
   }   
   
   public BinaryInteger addBinary(LongInteger that) {
   
      long decSum = (this.addInt(that)).getValue();
      
      BinaryInteger sum = new BinaryInteger(decSum);
      
      return sum;
   }
   
   public BinaryInteger subBinary(BinaryInteger that) {
   
      long decDiff = (this.subInt(that)).getValue();
      
      BinaryInteger difference = new BinaryInteger(decDiff);
      
      return difference;
   }
   
   public BinaryInteger multBinary(BinaryInteger that) {
   
      long decProd = (this.multInt(that)).getValue();
      
      BinaryInteger product = new BinaryInteger(decProd);
      
      return product;
   }
   
   public BinaryInteger divBinary(BinaryInteger that) {
   
      long decQuo = (this.divInt(that)).getValue();
      
      BinaryInteger quotient = new BinaryInteger(decQuo);
      
      return quotient;
   }
      
   private boolean validateBinary(int[] binary) { //validates binary arrays
   
      for (int i = 0; i < binary.length; i++) {
      
         if (binary[i] > 1 || binary[i] < - 1) {
         
            return false;
         }
      }
      
      return true;
   }
}