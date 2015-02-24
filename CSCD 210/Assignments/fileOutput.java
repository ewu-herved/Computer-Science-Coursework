//Dan Herve
//Assignment 5: Rock, Paper, Scissors
//No known shortcomings

import java.util.*;
import java.io.*; 

public class fileOutput {  

   public static void main(String[] args) throws FileNotFoundException {   
   
      Scanner input = new Scanner(new File("a.txt"));
   
      int rounds = input.nextInt();   
      
      for (int i = 0; i < rounds; i++) { //loop runs for the total rounds played
      
         int playNumber = input.nextInt(); //the number of sets played in a round
         
         int player1wins = 0; //counts sets won in the round
      
         int player2wins = 0;
      
         for (int j = 0; j < playNumber; j++) { //calculates the winner for each set 
         
            String player1 = input.next();
            
            String player2 = input.next();
            
            String winner = outcome(player1, player2); //outcome method determines winner
            
            if (winner.equals("Player 1")) //counter
               player1wins++;
            else if (winner.equals("Player 2"))
               player2wins++;
         }
         
         String theWinner;  //following code block displays the round winner
      
         if (player1wins > player2wins)
            theWinner = "Player 1";
         else if (player2wins > player1wins)
            theWinner = "Player 2";
         else
            theWinner = "TIE";            
                  
         System.out.println(theWinner);
      }
   }            
      
   public static String outcome(String player1, String player2) { //calculates the winner of each match
      
      String rock = "R";
      
      String scissors = "S";
      
      String paper = "P";
      
      String p1V = "Player 1";
      
      String p2V = "Player 2";
      
      String tie = "TIE";
      
      String output;
      
      if ((player1.equals(rock) && player2.equals(scissors)) || (player1.equals(scissors) && 
          player2.equals(paper)) || (player1.equals(paper) && player2.equals(rock))) {        
         
          output = p1V;
      }   
      
      else if ((player1.equals(rock) && player2.equals(paper)) || (player1.equals(scissors) && 
         player2.equals(rock)) || (player1.equals(paper) && player2.equals(scissors))) {
      
         output = p2V;
      }
      
      else {
      
         output = tie;
      }
      
      return output;
   }
}
      
         