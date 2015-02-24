import java.util.*;

public class TwoDArray {  

   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);
   
      int[][] twoD;
   
      int rows;
   
      int columns;
   
      System.out.print("Please enter two values to create a 2D Array\n# of rows: ");
      
      rows = input.nextInt();
      
      System.out.print("# of columns: ");
      
      columns = input.nextInt();
      
      twoD = create2D(rows, columns);
      
      twoD = init2D(twoD);
      
      printArray(twoD);
      
      System.out.println();
      
      twoD = double2D(twoD);
      
      printArray(twoD);      
   }
   
   private static int[][] create2D(int rows, int columns) {
   
      return new int[rows][columns];
   }
   
   private static int[][] init2D(int[][] twoD) {
   
      for (int r = 0; r < twoD.length; r++) {
      
         for (int c = 0; c < twoD[r].length; c++) {
         
            twoD[r][c] = 1;
         }
      }
      
      return twoD;
   }
   
   private static int[][] double2D(int[][] twoD) {
      
      int[][] temp = new int[twoD.length * 2][twoD[0].length];
      
      for (int r = 0; r < twoD.length; r++) {
      
         for (int c = 0; c < twoD[r].length; c++) {
         
            temp[r][c] = 1;
         }
      }
            
      return temp;
   }
   
   private static void printRow(int[][] twoD, int row) {
   
      System.out.println(Arrays.toString(twoD[row]));
   }
   
   private static void printArray(int[][] twoD) {
   
      for (int r = 0; r < twoD.length; r++) {
      
         printRow(twoD, r);
      }
   }
}
      
         