public class palindrometester {

public static void main(String[] args) {

   if (isPal("tacocat")) {
   
      System.out.println("Palindrome");
   }
   
   else {
   
      System.out.println("Not a palindrome");
   }
   
   System.out.println(GCD(42, 35));
   
}

public static boolean isPal(String string) {

   if (string.length() <= 1) {
   
      return true;
   }
   
   else if (string.charAt(0) == string.charAt(string.length() - 1)) {
   
      return isPal(string.substring(1, string.length() - 1));
   }
   
   return false;
}


private static int GCD(int num1, int num2) {
   
   if (num2 == 0) {
   
      return num1;
   }
   
   int remainder = num1 % num2;
   
   return GCD(num2, remainder);
}
}