//Dan Herve
//Assignment 1: Review
//No known shortcomings

import java.util.*; //import Scanner
import java.io.*; //import input/output

public class PostOffice { //class

   private Scanner input; //create Scanner
   
   private ArrayList<Letter> letters= new ArrayList<>(); //create reference for arraylist
   
   private Letter[] letterAra; //reference for array converted from arraylist
   
   public PostOffice() { //dvc

      this.letters = letters;
   
      this.letterAra = letterAra;
   }
   
   public static void main(String[] args) { //main method
   
      PostOffice postOffice = new PostOffice(); 
   
      postOffice.readLetters("letters.in.txt"); 
   
      postOffice.sortLetters(postOffice.letters); 
   
      postOffice.printLetters();
   }    

   private void readLetters(String fileName) { //reads data from file and inserts it to arraylist
   
      input = inputFile(fileName);
      
      String nameFrom;
      
      String streetFrom;
      
      String cityFrom;
      
      String stateFrom;
      
      String zipFrom;
      
      String nameTo;
      
      String streetTo;
      
      String cityTo;
      
      String stateTo;
      
      String zipTo;
      
      double weight;
      
      int count = 0;
      
      while (input.hasNext()) {
      
         if (count > 0) {
         
            input.nextLine();
         }         
      
         nameFrom = input.nextLine();
         
         streetFrom = input.nextLine();
         
         String temp = input.nextLine();
         
         int commaPos = temp.indexOf(",");
         
         cityFrom = temp.substring(0, commaPos);
         
         stateFrom = temp.substring(commaPos + 2, commaPos + 4);
         
         zipFrom = temp.substring(commaPos + 5);
         
         nameTo = input.nextLine();
         
         streetTo = input.nextLine();
         
         temp = input.nextLine();
         
         commaPos = temp.indexOf(",");
         
         cityTo = temp.substring(0, commaPos);
         
         stateTo = temp.substring(commaPos + 2, commaPos + 4);
         
         zipTo = temp.substring(commaPos + 5);
         
         weight = input.nextDouble();
         
         Letter letter = new Letter(nameFrom, streetFrom, cityFrom, stateFrom, zipFrom,
                         nameTo, streetTo, cityTo, stateTo, zipTo, weight);
         
         letters.add(count, letter);
         
         count++;
      }
      
      closeFile();   
   }
   
   private void sortLetters(ArrayList<Letter> letters) { //sorts letters by zip or street and converts letters to 
   //an array
   
      letterAra = letters.toArray(new Letter[letters.size()]);
      
      SortSearchUtil.sortSelection(letterAra);  
   }
   
   private void printLetters() { //prints letter data to screen
   
      for (int i = 0; i < letterAra.length; i++) {
      
         System.out.println("---------------------------------------------------------------" +
         "---------------------");
      
         System.out.println(letterAra[i]);
      
         System.out.println("---------------------------------------------------------------" +
         "---------------------");
      }   
   }   
   
   private Scanner inputFile(String fileName) { //connects the Scanner to a file
   
      Scanner temp;
      
      try {
      
         File letterData = new File(fileName);
         
         temp = new Scanner(letterData);
         
         return temp;         
      }
      catch (FileNotFoundException fnfe) {
      
         System.out.println("File of letters not found.");
      }
      
      return null;      
   }
   
   private void closeFile() { //closes file
   
      input.close();
   }

   private int letterNum(Scanner input) { //counts the number of letters in the file
   
      int count = 0;
      
      while (input.hasNext()) {
      
         input.nextLine();
         
         count++;
      }
      
      count = count / 4;
      
      return count;   
   }
}