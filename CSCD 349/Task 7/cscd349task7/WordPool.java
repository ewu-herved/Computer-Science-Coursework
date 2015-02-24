import java.util.*;

public class WordPool implements Cloneable{

   private List<Link> links = new LinkedList<Link>();
   
   private List<Word> words = new LinkedList<Word>();

   public Link addWord(Word word) {
   
      if(hasWord(word) == false) {
      
         words.add(word);
      
         Link temp = new Link();
      
         links.add(temp);
         
         return temp;         
      }
      
      return links.get(linkIndex(words.indexOf(word)));
   }
   
   private int linkIndex(int index) {
   
      for(int i = 0; i < links.size(); i ++) {
      
         if(index == links.get(i).getIndex())
            return i;
      }
      
      throw new IndexOutOfBoundsException("No link exists with this index");
   }
   
   public List<Link> getLinks() {
   
      return Collections.unmodifiableList(links);
   }
   
   public int getSize() {
   
      int count = 0;
      
      for(int i = 0; i < words.size(); i++) {
      
         if(words.get(i).getLexeme().equals("") == false)
            count++;
      }
   
      return count;
   }
   
   public Word getWord(Link link) {
   
      if(links.contains(link) && link.isAlive()) {
      
         return words.get(link.getIndex());
      }
      
      if (link.isAlive() == false)
         throw new IllegalArgumentException("link is dead\n");
      
      throw new IllegalArgumentException("word is not listed");
   }
   
   public List<Word> getWords() {
   
      return Collections.unmodifiableList(words);
   }
   
   public boolean hasLink(Link link) {
   
      return links.contains(link);
   }
   
   public boolean hasWord(Word word) {
   
      for(int i = 0; i < words.size(); i ++) {
      
         if(words.get(i).equals(word))
            return true;
      }
      
      return false; 
   }
   
   public Word removeWord(Link link) {
   
      if(link.isAlive() == false)
         throw new IllegalArgumentException("broken link\n");
         
      if(links.contains(link)) {
      
         Word temp = words.get(link.getIndex());
         
         words.set(link.getIndex(), new Word(""));
         
         link.kill();
         
         links.remove(link);
         
         return temp;
      }
      
      throw new IllegalArgumentException("word is not listed\n");
   }
   
   @Override
   public String toString() {
   
      String string = "WordPool{entries=[\n";
      
      for(int i = 0; i < words.size(); i++) {
      
         if(i == words.size() - 1)
            string += words.get(i).getLexeme() + "]}";
            
         else if(words.get(i).getLexeme().equals(""));
            
         else         
            string += words.get(i).getLexeme() + "\n";
      }
      
      return string;
   }
   
   @Override
   public WordPool clone() {
   
      try {
      
         return (WordPool)super.clone();
      }
      
      catch(CloneNotSupportedException e) {
      
         System.out.println("Cannot return WordPool");
      }
      
      throw new RuntimeException("Could not clone WordPool\n");
   }
}