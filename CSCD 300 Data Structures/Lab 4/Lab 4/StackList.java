public class StackList {

   private Node head;
   private int size = 0;
   
   public Comparable getHead() {
      
      return head.getData();
   }
   
   public boolean isEmpty() {
   
      if (size == 0) {
      
         return true;
      }
      
      return false;
   }
   
   public void push(Comparable data) {
   
      if (size == 0) {
      
         head = new Node(data);
         
         size++;
      }
      
      else {
      
         Node temp = new Node(data, head);
         
         head = temp;
         
         size++;
      }
   }
   
   public Comparable pop() {
   
      if (size == 0) {
      
         return null;
      }
      
      else {
      
         Comparable temp = head.getData();
         
         head = head.getNext();
         
         size--;
         
         return temp;
      }
   }
}