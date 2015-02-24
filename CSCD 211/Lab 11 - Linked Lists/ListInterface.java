//Dan Herve
//Assignment 6: Linked Lists
//Extra Credit Completed

public interface ListInterface {

   boolean isEmpty();
   
   int getSize();
   
   void addNode(Comparable o);
   
   void addNode(int index, Comparable o);
   
   void removeNode(int index);
   
   void removeAll();
   
   String toString();
   
   public class Node implements Comparable<Node> {
   
      Comparable item;
      
      Node next;
      
      public Node(Comparable item) {
      
         this.item = item;
      }
      
      public Node(Comparable item, Node next) {
      
         this.item = item;
         this.next = next;
      }
      
      public Comparable getItem() {
      
         return item;
      }
      
      public Node getNext() {
      
         return next;
      }
      
      public void setItem(Comparable item) {
         
         this.item = item;
      }
      
      public void setNext(Node next) {
      
         this.next = next;
      }
      
      public String toString() {
      
         return next.toString();
      }
      
      public int compareTo(Node that) {;
      
         return this.getItem().compareTo(that.item);
      } 
   }
}
