public class Link {

   private static int nextIndex = 0;
   
   private int index = -1;
   
   public Link() {
   
      index = nextIndex;
      
      nextIndex++;
   }

   public int getIndex() {
   
      return index;
   }
   
   public boolean isAlive() {
   
      if(index == -1)
         return false;
         
      return true;
   }
   
   public void kill() {
   
      //nextIndex--;
   
      index = -1;
   }
}