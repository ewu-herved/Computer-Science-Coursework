public class LinkedList {

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
   int size = 0;
   
   public int getSize() {
   
      return size;
   }
   
   public void addFirst(Comparable data) {
      
      Node temp = new Node(data, head.next);
      head.next = temp;    
      size++;
   }
   
   public void addOrdered(Comparable data) {
   
      if (size == 0)
      
         addFirst(data);
         
      else {
         
         Node curr;
         Node prev = head;
         Node temp = new Node(data);
         
         for (curr = head.next; curr != null; prev = curr, curr = curr.next) {
         
            if(curr.data.compareTo(data) == 0) { //replaces duplicates
         
               temp.next = curr.next;
               prev.next = temp;
               size++;
               break;
            }
         
            else if (curr.data.compareTo(data) > 0) {
            
               temp.next = curr;
               prev.next = temp;
               size++;
               break;
            }
         }
         
         if(curr == null) { //if inserted value is higher than the rest
         
            temp.next = prev.next;
            prev.next = temp;
            size++;
         }
      }
   }
   
   public void removeFirst() {
      
      head.next = head.next.next; 
      size--;
   }
   
   public Comparable removeOrdered(Comparable data) {
   
      if (size == 0)
      
         return null;
         
      else {
         
         Node curr;
         Node prev = head;
         Node temp;
         
         for (curr = head.next; curr != null; prev = curr, curr = curr.next) {
         
            if (curr.data.compareTo(data) == 0) {
               
               temp = curr;
               prev.next = curr.next;
               curr = null;
               size--;
               return temp.data;
            }
         }
         
         return null;
      }   
   }
   
   public Comparable getData(Comparable target) {
   
      Node curr;
      
      for(curr = head.next; curr != null; curr = curr.next) {
      
         if (curr.data.compareTo(target) == 0) {
         
            return curr.data;
         }
      }
         
      return null;
   }
   
   public void printList() {
   
      Node curr;  
   
      for(curr = head.next; curr != null; curr = curr.next) {
      
         if(curr.next == null) 
            System.out.print(curr.data.toString());
         else   
            System.out.print(curr.data.toString()+ " ");
      }
   }
   
   public void clear() {
   
      head.next = null;
      size = 0;
   }   
}