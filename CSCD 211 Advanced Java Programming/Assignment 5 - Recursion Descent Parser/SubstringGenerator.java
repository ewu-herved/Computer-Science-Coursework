/**
* This class uses recursion to generate all possible substrings for a given string
*
* @author  Dan Herve
*/

public class SubstringGenerator {

   String word;   

   /**
   * The constructer will invoke the parser method with the given String.
   *
   * @param   s - represents the given String
   * @exception   none - no exception thrown
   */
   
   public SubstringGenerator(String s) {
   
      this.word = s;
   
      parser(s); 
   }
   
   /**
   * <pre>
   * The parser method performs the recursion operation which prints all 
   * possible substrings of the given string
   * </pre>
   *
   * @param   s - represents the given String
   * @exception   none - no exception thrown
   */   
   
   public void parser(String s) {
   
      if (word.length() <= 1) {         
      }
      
      else {         
         
         if (s.length() <= 0) {
         
            word = word.substring(1);
            s = word;
         }
         System.out.println(s); 
         
         parser(s.substring(0, s.length() - 1));         
      }
   } 
}

