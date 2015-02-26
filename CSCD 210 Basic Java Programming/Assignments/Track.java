//Dan Herve
//Assignment 1 Track
//No shortcomings identified

import java.util.Scanner; //import Scanner

public class Track { //Declare Class
   public static void main(String[] args) { //main method
   //create Scanner
   Scanner input = new Scanner(System.in);
   
   //prompt user to enter a winning race time
   System.out.print("Please enter the winning time of the race: ");
   double winTime = input.nextDouble();
   
   //Call method meterTime to calculate meters/second 
   double meterPSec = meterTime(winTime);
      
   //calculate feet/second
   double feetPSec = 100 * 1.09361 * 3 / winTime;
   //calculate kilometers/hour
   double kiloPHour = 100 * .001 / (winTime / 3600 );
   //calculate miles/hour
   double milePHour = 100 * 0.000621371 / (winTime / 3600);
   //calculate minutes to run a mile
   double mileMin = 1 / milePHour * 60;
   //calculate remainder seconds from minutes to run a mile
   double mileMinSec = mileMin % 1 * 60;
   //calculate time to run 100 yards
   double yardTime = 100 / (100 * 1.09361 / winTime);
   
   //call output method to print data
   output(meterPSec, feetPSec, kiloPHour, milePHour, mileMin, mileMinSec, yardTime);      
   }
   
   public static double meterTime(double win) { //calculation method
       //calculate meters/second
       double meterPSec = 100 / win;
       
       //return value
       return meterPSec;     
       }
   public static void output(double meterPSec, double feetPSec, double kiloPHour, //printmethod
   double milePHour, double mileMin, double mileMinSec, double yardPSec) {
      //print data
      System.out.printf("The person was travelling at a rate of:\n" + 
      "\n %4.2f meters per second,\n %4.2f feet per second,\n %4.2f" +
      " kilometers per hour,\n %4.2f miles per hour,\n\nIt would take" +
      "%2.0f minutes and %3.2f seconds for the person to run\none mile.\n" +
      "It would take %3.2f seconds for the person to run 100 yards.",
       meterPSec, feetPSec, kiloPHour, milePHour, mileMin, mileMinSec, yardPSec);
      }
   }
     