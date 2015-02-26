public class ListQueue {

   private class Node implements Comparable<Node>{
   
      private Comparable data;
      private Node next;
   
      public Node(Comparable data) {
   
         this.data = data;
      }
   
      public Node(Comparable data, Node next) {
   
         this.data = data;
         this.next = next;
      }
   
      public void setNext(Node next) {
   
         this.next = next;
      }
   
      public void setData(Comparable data) {
   
         this.data = data;
      }
   
      public Node getNext() {
   
         return next;
      }
   
      public Comparable getData() {
   
         return data;
      }
   
      @Override
      public int compareTo(Node that) {
   
         return this.data.compareTo(that.data);
      }
   
      @Override
      public String toString() {
   
         return "" + data;
      }
   }

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
   
   public Comparable dequeue() {
   
      Node temp = head.getNext();
      
      head.setNext(head.getNext().getNext()); 
      size--;
      return temp.getData();
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