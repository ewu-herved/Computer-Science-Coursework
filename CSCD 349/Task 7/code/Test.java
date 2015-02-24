public class Test {

   public static void main(String[] args) {
   
      Text sentence = new Text();
      
      sentence.addWord(new Word("This"));
      
      System.out.println(sentence.toString());
      
      sentence.unionStyle(new Style(true, false, false), 0);
      
      System.out.println(sentence.generate(true));
      
      System.out.println(sentence.generate(false));
      
      sentence.addWord(new Word("dog"));
      
      System.out.println(sentence.generate(true));
      
      System.out.println(sentence.generate(false));
      
      sentence.addWord(new Word("is"));
      
      sentence.addWord(new Word("a"));
      
      sentence.addWord(new Word("bad"));
      
      sentence.addWord(new Word("dog"));
      
      System.out.println(sentence.generate(true));
      
      System.out.println(sentence.getWordPool().toString());
      
      sentence.removeWord(4);
      
      System.out.println(sentence.generate(true));
      
      sentence.replaceWord(new Word("good"), 3);
      
      System.out.println(sentence.generate(true));
      
      System.out.println(sentence.getWordPool().toString());
      
      sentence.unionStyle(new Style(false, true, false), 0, 1);
      
      System.out.println(sentence.generate(true));
      
      sentence.intersectStyle(new Style(false, true, false), 0, 1);
      
      System.out.println(sentence.generate(true));
      
      sentence.insertWord(new Word("very"), 3);
      
      System.out.println(sentence.generate(false));
      
      System.out.println(sentence.getWordPool().toString());
      
      System.out.println("Compression factor = " + sentence.calculateCompressionFactor());
   }
}