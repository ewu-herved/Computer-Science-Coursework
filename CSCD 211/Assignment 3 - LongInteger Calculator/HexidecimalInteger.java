//Dan Herve
//Assignment 3: LongInteger Calculator
//No known shortcomings; completed all extra credit

import java.util.*;

public class HexidecimalInteger extends LongInteger {

   private int[] hexidecimal;
   
   private boolean negative = false;
   
   public HexidecimalInteger() {
   
      hexidecimal = new int[1];
   }
   
   public HexidecimalInteger(long value) {
   
      super(value);
      
      if (value < 0) {
      
         negative = true;
      }
      
      hexidecimal = convertToHexidecimal(super.getValue());
   }
   
   public HexidecimalInteger(String hexidecimalInput) {
      
      if (hexidecimalInput.substring(0, 1).equals("-")) {
      
         hexidecimalInput = hexidecimalInput.substring(1);
         
         negative = true;
      }
      
      hexidecimal = new int[hexidecimalInput.length()];
      
      for (int i = 0; i < hexidecimal.length; i++) {
      
         if (hexidecimalInput.charAt(i) == 'A' || hexidecimalInput.charAt(i) == 'a') {
         
            hexidecimal[i] = 10;
         }
         
         else if (hexidecimalInput.charAt(i) == 'B' || hexidecimalInput.charAt(i) == 'b') {
         
            hexidecimal[i] = 11;
         }
         
         else if (hexidecimalInput.charAt(i) == 'C' || hexidecimalInput.charAt(i) == 'c') {
         
            hexidecimal[i] = 12;
         }
         
         else if (hexidecimalInput.charAt(i) == 'D' || hexidecimalInput.charAt(i) == 'd') {
         
            hexidecimal[i] = 13;
         }
         
         else if (hexidecimalInput.charAt(i) == 'E' || hexidecimalInput.charAt(i) == 'e') {
         
            hexidecimal[i] = 14;
         }
         
         else if (hexidecimalInput.charAt(i) == 'F' || hexidecimalInput.charAt(i) == 'f') {
         
            hexidecimal[i] = 15;
         }
            
         else {   
            
            hexidecimal[i] = hexidecimalInput.charAt(i) - '0';
         }
      }
      
      if (negative) {
      
         for (int i = 0; i < hexidecimal.length; i++) {
         
            hexidecimal[i] *= -1;
         }
      }
      
      if (validateHexidecimal(hexidecimal) == false) {
      
         throw new InputMismatchException("Not an hexidecimal number");
      }
      
      value = hexidecimalToDecimal(hexidecimal);
   }
   
   public int[] getHexidecimal() {
   
      return hexidecimal;
   }
   
   private int[] convertToHexidecimal(long that) { //converts longs to an array representation of an hexidecimal
   
      double decimal = that;
      
      if (negative) {
         
         decimal *= -1;
      }
      
      int count = 0;
      
      long power;
      
      long remainder = (long) decimal;
      
      while (decimal >= 1.0) {
      
         decimal /= 16;
         count++;
      }
      
      int[] hexidecimalFormat = new int[count];
      
      if (count == 0) {
      
         hexidecimalFormat = new int[1];
      }
      
      for (int i = 0; i < hexidecimalFormat.length; i++) {
      
         power = (long) (Math.pow(16, hexidecimalFormat.length - i -1));  
         
         if (remainder > 0 && power <= remainder) {
         
            hexidecimalFormat[i] = (int) (remainder / power);
            
            remainder -= (power * hexidecimalFormat[i]) ;
         }
         
         else {
         
            hexidecimalFormat[i] = 0;
         }
      }
      
      if (negative) {
      
         for (int i = 0; i < hexidecimalFormat.length; i++) {
         
            hexidecimalFormat[i] *= -1;
         }
      }
            
      return hexidecimalFormat;  
   }
   
   private long hexidecimalToDecimal(int[] hexidecimal) { //converts array representation of an hexidecimal to a long
   
      long decimal = 0;
      
      for (int i = 0; i < hexidecimal.length; i++) {
      
         if (hexidecimal[i] != 0) {
         
            decimal += hexidecimal[i] * Math.pow(16, hexidecimal.length - i - 1);
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
      
      for (int x: hexidecimal) {
          
          if (x == 15 || x == -15) {
          
             string += "F";
          }
          
          else if (x == 14 || x == -14) {
          
             string += "E";
          }
          
          else if (x == 13 || x == -13) {
          
             string += "D";
          }
          
          else if (x == 12 || x == -12) {
          
             string += "C";
          }
          
          else if (x == 11 || x == -11) {
          
             string += "B";
          }
          
          else if (x == 10 || x == -10) {
          
             string += "A";
          }
          
          else {
          
            String number = "" + x;
            
            if (negative && x != 0) {
            
               number = number.substring(1);
            }
          
            string += number;
          }
      }
          
      return string;
   }   
   
   public HexidecimalInteger addHexidecimal(LongInteger that) {
   
      long decSum = (this.addInt(that)).getValue();
      
      HexidecimalInteger sum = new HexidecimalInteger(decSum);
      
      return sum;
   }
   
   public HexidecimalInteger subHexidecimal(HexidecimalInteger that) {
   
      long decDiff = (this.subInt(that)).getValue();
      
      HexidecimalInteger difference = new HexidecimalInteger(decDiff);
      
      return difference;
   }
   
   public HexidecimalInteger multHexidecimal(HexidecimalInteger that) {
   
      long decProd = (this.multInt(that)).getValue();
      
      HexidecimalInteger product = new HexidecimalInteger(decProd);
      
      return product;
   }
   
   public HexidecimalInteger divHexidecimal(HexidecimalInteger that) {
   
      long decQuo = (this.divInt(that)).getValue();
      
      HexidecimalInteger quotient = new HexidecimalInteger(decQuo);
      
      return quotient;
   }
   
   private boolean validateHexidecimal(int[] hexidecimal) { //validates hexidecimal arrays
   
      for (int i = 0; i < hexidecimal.length; i++) {
      
         if (hexidecimal[i] > 15 || hexidecimal[i] < - 15) {
         
            return false;
         }
      }
      
      return true;
   }
}