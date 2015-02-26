import java.util.Scanner;

public class quizPractice {
   public static void main(String[] args) {   
      
      Scanner kb = new Scanner(System.in);
   
      System.out.print("Which problem would you like to demo:\n1: Number Averages\n2: "+
      "Larger of Two Numbers\n");
      
      int[] ara = new int[0];
      
      switch (kb.nextInt()) {
         case 1: ara = createArray(); average(ara); break;
         case 2: ara = createArray(); intOrder(ara); System.out.print(ara[0] + ", " + ara[1]); break;
      }      
   }
   
   public static int[] createArray() {
   
      Scanner kb = new Scanner(System.in);
   
      System.out.print("How many numbers are you considering? ");
      
      int[] ara = new int[kb.nextInt()];
      
      System.out.print("Type the numbers, pressing enter after each one: " );
      
      for (int i = 0; i < ara.length; i++) 
         ara[i] = kb.nextInt();
         
      return ara;
   }
   
   public static void average(int[] ara) {
      
      int sum = 0;
      for (int i = 0; i < ara.length; i++) 
         
         sum += ara[i];
      
      System.out.println("The average is " + sum / ara.length);
   }
   
   public static int[] intOrder(int[] ara) {
   
      
      
      for (int i = 0; i < ara.length; i++) {
         for (int j = 1; j < ara.length; j++) {
            if (ara[i] > ara[j]) {
               int temp = ara[i];
               ara[i] = ara[j];
               ara[j] = temp;
            }
         }
      }
      return ara;
   } 
}    