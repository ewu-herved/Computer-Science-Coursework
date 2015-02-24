public class LinkedList {

   private class Node implements Comparable<Node> {

      private Comparable data;
      private Node next;
   
      public Node(Comparable data) {
   
         this.data = data;
      }
   
      public Node(Comparable data, Node next) {
   
         this.data = data;
         this.next = next;
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
   
   public void addFirst(Comparable data) {
      
      Node temp = new Node(data, head.next);
      head.next = temp;
      if (size == 0) {
      
         tail = head.next;
      }     
      size++;
   }
   
   public void addLast(Comparable data) {
      
      if (size == 0) {
      
         addFirst(data); 
      }
      
      else {
      
         tail.next = new Node(data);
         tail = tail.next;
         size++;
      }
   }   
   
   public void removeFirst() {
      
      head.next = head.next.next; 
      size--;
   }
   
   public void printList() {
   
      Node curr;  
   
      for(curr = head.next; curr != null; curr = curr.next) {
      
         System.out.println(curr.data);
      }
   }
   
   public void clear() {
   
      head.next = null;
      tail = null;
      size = 0;
   }   
}