public class Word {

   private String lexeme;
   
   public Word(String lexeme) {
   
      if (lexeme == null) 
         throw new RuntimeException("No word given\n");
         
      this.lexeme = lexeme;
   }
   
   public String getLexeme() {
   
      return lexeme;
   }
   
   @Override
   public boolean equals(Object word) {
   
      if(lexeme.equals(((Word)word).getLexeme()))
         return true;
      
      return false;
   }
}