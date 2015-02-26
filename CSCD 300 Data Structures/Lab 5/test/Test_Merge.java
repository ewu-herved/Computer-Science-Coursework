import java.util.*;
import java.io.*;

public class Test_Merge {

   private static Scanner input = new Scanner(System.in);
   
   private static Scanner[] files;
   
   private static ListQueue list = new ListQueue();

   public static void main(String [] args) {      
      
      ArrayQueue[] fileAra = null;                
      
      boolean continueInput = true;
      
      do {
      
         try {            
      
            int fileNum = args.length; 
            
            if(fileNum < 2) {
            
               throw new InputMismatchException();
            }
            
            fileAra = new ArrayQueue[fileNum];
            
            for(int i = 0; i < fileAra.length; i++) {
      
               fileAra[i] = new ArrayQueue(10);
            }
            
            files = new Scanner[fileNum];
            
            arrayMaker(fileNum, args);
            
            continueInput = false;
         }  
      
         catch (InputMismatchException e) {
            
            System.out.println("You must enter at least 2 files.\n");
            //input.nextLine();
            System.exit(0);
         }
      
         catch (FileNotFoundException f) {
      
             System.out.println("At least one file is invalid.\n");
             //input.nextLine();
             System.exit(0);
         }
      }while(continueInput);      
      
      combine(fileAra, files);
      
      while(list.getSize() > 0) {
      
         System.out.println(list.getHead());
         list.dequeue();
      }       
   }
   
   private static void arrayMaker(int num, String[] args) throws FileNotFoundException {
      
      for(int i = 0; i < num; i++) {
            
         files[i] = new Scanner(new File(args[i]));
      }      
   }
   
   private static boolean isEmpty(Scanner[] files) {
   
      for (int i = 0; i < files.length; i++) {
      
         if(files[i] != null) {
         
            return false;
         }
      }
         
      return true;
   }
   
   private static boolean isEmpty(ArrayQueue[] fileAra) {
      
      for (int i = 0; i < fileAra.length; i++) {
      
         if(fileAra[i].getSize() != 0) {
         
            return false;
         }
      }
         
      return true;
   }
   
   public static void combine(ArrayQueue[] fileAra, Scanner[] files) {     
      
      do {
         
         for(int i = 0; i < fileAra.length; i++) {
            
            for(int j = 0; j < fileAra[i].getCapacity(); j++) {
            
               if (files[i] != null && fileAra[i].getSize() < fileAra[i].getCapacity()) {
               
                  try {
                            
                     if (files[i].hasNextLine()) {
               
                        fileAra[i].enqueue(files[i].nextInt());
                     }
                     else {
               
                        files[i] = null;
                        break;
                     }
                  }
                  catch (NoSuchElementException e) {
                  }
               }
            }
         }
            
         while(isEmpty(fileAra) == false) {
            
            int smallest = 0;
            boolean least1 = false;
            
            for(int i = 0; i < fileAra.length; i++) {
            
               if(fileAra[i].getSize() == 0 && least1 == false) {
               
                  smallest++;
               }
            
               if(fileAra[i].getSize() > 0) {
               
                  least1 = true;
            
                  if (fileAra[i].getData().compareTo(fileAra[smallest].getData()) < 0) {
                  
                     smallest = i;
                  }
               }
            }
            
            if (least1) {
               
               list.enqueue(fileAra[smallest].dequeue());
            }
         }            
      }while(isEmpty(files) == false); 
   }
}