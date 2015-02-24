public class ListQueue {

   Node head = new Node(null);
   Node tail = null; 
   int size = 0;
   
   public int getSize() {
   
      return size;
   }
   
   public Comparable getHead() {
   
      return head.getNext().getData();
   }
      
   public void enqueue(Comparable data) {
      
      if (size == 0) {
      
         Node temp = new Node(data, head.getNext());
         head.setNext(temp);
         tail = head.getNext();
         size++;          
      }
      
      else {
      
         tail.setNext(new Node(data));
         tail = tail.getNext();
         size++;
      }
   }   
   
   public void dequeue() {
      
      head.setNext(head.getNext().getNext()); 
      size--;
   }
   
   public void printList() {
   
      Node curr;  
   
      for(curr = head.getNext(); curr != null; curr = curr.getNext()) {
      
         System.out.println(curr.getData());
      }
   }
   
   public void clear() {
   
      head.setNext(null);
      tail = null;
      size = 0;
   }   
}