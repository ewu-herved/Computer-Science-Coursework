import java.util.*;

public class Text {

   private List<LinkStyled> text = new LinkedList<LinkStyled>();
   
   private WordPool pool = new WordPool(); 
   
   public Text() {}
   
   public Text(List<Word> words) {
   
      for(int i = 0; i < words.size(); i++) 
         text.add(new LinkStyled(pool.addWord(words.get(i))));      
   }
   
   public LinkStyled addWord(Word word) {
   
      LinkStyled temp = new LinkStyled(pool.addWord(word));
   
      text.add(temp);
      
      return temp;
   }
   
   public double calculateCompressionFactor() {
   
      return (double)pool.getSize() / (double)text.size();
   }
   
   public String generate(boolean isStyled) {
   
      String result = "";
      
      if(isStyled) {
      
         for(int i = 0; i < text.size(); i++) {
         
            LinkStyled temp = text.get(i);
            
            if(i == text.size() - 1)
               result += temp.getStyle().generateTagOpen() + pool.getWord(temp.getLink()).getLexeme()
               + temp.getStyle().generateTagClose();
            
            else
               result += temp.getStyle().generateTagOpen() + pool.getWord(temp.getLink()).getLexeme()
               + temp.getStyle().generateTagClose() + " ";
         }
      }
      else {
      
         for(int i = 0; i < text.size(); i++) {
         
            LinkStyled temp = text.get(i);
            
            if(i == text.size() - 1)
               result += pool.getWord(temp.getLink()).getLexeme();
            else
               result += pool.getWord(temp.getLink()).getLexeme() + " ";
         }
         
      }
      
      return result;
   }
   
   public List<LinkStyled> getLinkStyled(int... positions) {
   
      List<LinkStyled> subset = new LinkedList<LinkStyled>();
      
      for(int position : positions) {
      
         for(int i = 0; i < text.size(); i++) {
      
            if(text.get(i).getLink().getIndex() == position)
               subset.add(text.get(i));
         }
      }
      
      return subset;
   }
   
   public Word getWord(int position) {     
      
      return pool.getWord(text.get(position).getLink());
   }
   
   public Word getWord(Link link) {     
      
      return pool.getWord(link);
   }
   
   public WordPool getWordPool() {
   
      return pool.clone();
   }
   
   public LinkStyled insertWord(Word word, int position) {
   
      LinkStyled temp = new LinkStyled(pool.addWord(word));
   
      text.add(position, temp);
      
      return temp;
   }
   
   public void intersectStyle(Style style, int... positions) {
   
      for(int position : positions) {
      
         text.get(position).getStyle().intersect(style);
      }
   }
   
   public Word removeWord(int position) {
   
      LinkStyled temp = text.remove(position);
      
      Word tempWord = pool.getWord(temp.getLink());
      
      boolean contains = false;
  
      for(int i = 0; i < text.size(); i++) {
      
         if(pool.getWord(text.get(i).getLink()).equals(tempWord))
            contains = true;
      }
      
      if(contains == false)
         pool.removeWord(temp.getLink());
         
      return tempWord;
   }
   
   public Word replaceWord(Word word, int position) {
   
      LinkStyled temp = text.set(position, new LinkStyled(pool.addWord(word)));
      
      Word tempWord = pool.getWord(temp.getLink());
      
      boolean contains = false;
   
      for(int i = 0; i < text.size(); i++) {
      
         if(pool.getWord(text.get(i).getLink()).equals(tempWord))
            contains = true;
      }
      
      if(contains == false)
         pool.removeWord(temp.getLink());
         
      return tempWord;
   }
   
   public String toString() {
   
      return "{" + generate(true) + "}";
   }
   
   public void unionStyle(Style style, int... positions) {
   
      for(int position : positions) {
      
         text.get(position).getStyle().union(style);
      }   
   }
}