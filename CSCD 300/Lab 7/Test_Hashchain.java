//Dan Herve
//Program 7

import java.io.*;
import java.util.*;

public class Test_Hashchain {

   private static Hashchain table = new Hashchain(5);

   public static void main(String[] args) {
   
   int idk = 123135;
   
   double test = (double)(idk) / 100000;
   
      try {
      
         Scanner input = new Scanner(new File(args[0])); //grab input file 
      
         while(input.hasNext()) { //navigate file for student data
      
            String temp = input.nextLine();
            if (temp.equals("")); //for empty lines
            else {      
               int id = Integer.parseInt(temp.substring(0, 4)); //grab id
               String name = temp.substring(5); //grab name
               Student student = new Student(id, name);
               table.put(id, student); //student to hashtable
            }
         }
      }
      
      catch (FileNotFoundException e) {
      
         System.out.println("Not a valid file.");
         System.exit(0);
      }
      
      menu();   
   }
   
   public static void menu() {
   
      Scanner input = new Scanner(System.in);
      
      int choice = 0;
   
      do {
         
         try {                    
         
            System.out.print("Choose one of the following options.\n" +
                               "====================================\n" +
                               "1) insert/update a new student record\n" +
                               "2) delete a student record\n" +
                               "3) search for a student record\n" +
                               "4) print all the student records\n" +
                               "5) quit\n\n" +
                               "Your choice: ");
            
            choice = input.nextInt();
            
            System.out.print("\n");
            
            switch(choice) {
            
               case 1: newID(input);
                       break;
               case 2: delete(input);
                       break;
               case 3: search(input);
                       break;
               case 4: table.printAll();
                       break;
               case 5: System.out.print("Have a nice day!\n");
                       break;
               default: System.out.println("That is not a valid menu choice.\n");
            }      
         }
         
         catch (InputMismatchException e) {
      
            System.out.println("\nThat is not a valid menu choice.\n");
            input.nextLine(); //clear input buffer
         }   
      }while(choice != 5);     
   }
   
   public static void newID(Scanner input) {
   
      int id = 0;
      String name = "";
      boolean continueInput = true;
      
      do {
         
         try {                    
         
            System.out.print("Input the student id: ");
                        
            id = input.nextInt();
            
            if((double)id / 10000 > 1 || id < 0) { //limits id's to 4 digits
            
               throw new InputMismatchException();
            }
            
            System.out.print("\n");
            
            input.nextLine();
            
            System.out.print("Input the student name: ");
                        
            name = input.nextLine();
            
            System.out.print("\n");
            
            table.put(id, new Student(id, name));
            
            continueInput = false;           
         }
         
         catch (InputMismatchException e) {
      
            System.out.println("\nThat is not a valid id.\n");
            input.nextLine();
         }   
      }while(continueInput);
   }
   
   public static void delete(Scanner input) {
   
      int id = 0;
      boolean continueInput = true;
      
      do {
         
         try {                    
         
            System.out.print("Input the student id: ");
                        
            id = input.nextInt();
            
            if((double)id / 10000 > 1 || id < 0) {
            
               throw new InputMismatchException();
            }
            
            System.out.print("\n");
            
            input.nextLine();
            
            Student temp = (Student) table.remove(id, new Student(id, "temp"));
            
            continueInput = false;
            
            if (temp != null)
               System.out.println("The student has been deleted successfully.\n");
            else
               System.out.println("No such student.\n");
                        
         }
         
         catch (InputMismatchException e) {
      
            System.out.println("\nThat is not a valid id.\n");
            input.nextLine();
         }   
      }while(continueInput);
   }
   
   public static void search(Scanner input) {
   
      int id = 0;
      boolean continueInput = true;
      
      do {
         
         try {                    
         
            System.out.print("Input the student id: ");
                        
            id = input.nextInt();
            
            if((double)id / 10000 > 1 || id < 0) {
            
               throw new InputMismatchException();
            }
            
            System.out.print("\n");
            
            input.nextLine();
            
            Student temp = (Student) table.get(id, new Student(id, "temp"));
            
            continueInput = false;
            
            if (temp != null)
               System.out.printf("%s\n\n", temp.toString2());
            else
               System.out.println("No such student.\n");                        
         }
         
         catch (InputMismatchException e) {
      
            System.out.println("\nThat is not a valid id.\n");
            input.nextLine();
         }   
      }while(continueInput);
   }
}