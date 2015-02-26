//Dan Herve
//CSCD 300: Lab 3

import java.util.*;
import java.io.*;

public class Test_RoundRobin {

   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner input = new Scanner(new File("data.txt")); //reads a file from the command line
      
      RoundRobin_Processing cpu = new RoundRobin_Processing(); //Linked List Object
      
      while (input.hasNextLine()) { // reads the file for lines with pairs of ints with format x,y
      
         String temp = input.nextLine();
         
         int pID = Integer.parseInt((String)temp.substring(0, temp.indexOf(',')));
         
         int data = Integer.parseInt((String)temp.substring(temp.indexOf(',') + 1));
         
         cpu.add(pID, data); //add a node 
      }
      
      int cpuService = Integer.parseInt("5"); 
      
      cpu.process(cpuService); //call to processing method
         
   }
}