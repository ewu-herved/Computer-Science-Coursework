//Dan Herve
//Assignment 6: Linked Lists
//Extra Credit Completed

public class ListReferenceBased implements ListInterface {

   private Node head;
   private int numItems;
   
   public ListReferenceBased() {
   
      head = null;
      numItems = 0;
   }
   
   @Override
   public boolean isEmpty() {
   
      return numItems == 0;
   }
   
   @Override
   public int getSize() {
   
      return numItems;
   }
   
   public Node getHead() {
   
      return head;
   }
   
   @Override
   public void addNode(Comparable newItem) {
   
      Node newNode = new Node(newItem);
      Node curr;
      
      if(isEmpty())
      {
         this.head = newNode;
      }
      
      else {
      
         for (curr = head; curr.getNext() != null; curr = curr.getNext());
         
         curr.setNext(newNode);
      }
      
      numItems++;
   }
   
   public void addNode(int index, Comparable newItem) {
   
      Node newNode = new Node(newItem);
      
      Node prev;
      
      if (index == 1) {
      
         newNode.setNext(head);
         this.head = newNode;
      }
      
      else {
      
         prev = find(index - 1);
         
         newNode.setNext(prev.getNext());
         
         prev.setNext(newNode);
      }
      
      numItems++;
   }
   
   @Override
   public void removeNode(int index) {
   
      if (index == 1) {
      
         head = head.getNext();
      }
      
      else {
      
         Node prev = find(index - 1);
         Node curr = prev.getNext();
         prev.setNext(curr.getNext());
      }
      
      numItems--;
   }
   
   public void removeNode(Comparable value) {
   
      if (value.equals(head.item)) {
      
         head = head.getNext();
         
         numItems--;
      }
      
      else if (find(value) != -1) {
      
         Node prev = find(find(value) - 1);
         Node curr = prev.getNext();
         prev.setNext(curr.getNext());
         numItems--;
      }
      
      else {
      
         System.out.println("\nThere is no element with that value.\n");
      }
   }
   
   @Override
   public void removeAll() {
   
      this.head = null;
      numItems = 0;
   }
   
   private Node find(int index) {
   
      Node curr = head;
      
      for (int i = 0; i != index; i++) {
      
         curr = curr.getNext();
      }
      
      return curr;
   }
   
   private int find(Comparable value) {
   
      int index = 0;
      
      for (Node curr = head; curr != null; curr = curr.next) {
      
         if (curr.item.equals(value)) {
         
            return index;
         }
         
         index++;
      }
      
      return -1;
   }
   
   @Override
   public String toString() {
   
      String s = "";
      
      for (Node curr = this.head; curr != null; curr = curr.getNext()) {
      
         s += curr.getItem().toString() + "\n";
      }
      
      return s;
   }
   
   public String toString(int nth) {
   
      String s = "";
      
      int index = 0;
      
      for (Node curr = this.head; curr != null; curr = curr.getNext()) {
      
         if ((int) curr.item % nth == 0) {
            
            s += curr.getItem().toString() + "\n";
         }
      }
      
      return s;
   }
   
   public String reversePrint() {
   
      String s = "";
      
      for (Node curr = this.head; curr != null; curr = curr.getNext()) {
      
         s = curr.getItem().toString() + "\n" + s;
      }
      
      return s;
   }
   
   public void sortSelection() {
   
      for (Node curr = head; curr != null; curr = curr.next) {
      
         for (Node smallest = curr; smallest != null; smallest = smallest.next) {
         
            if (curr.getItem().compareTo(smallest.getItem()) > 0) {
            
               Node temp = new Node(curr.getItem());
               
               curr.item = smallest.item;
               
               smallest.item = temp.item;
            }
         }
      }
   }
   
   public ListReferenceBased evenList() {
   
      ListReferenceBased evens = new ListReferenceBased();
   
      for(Node curr = head; curr != null; curr = curr.next) {            
         
         if ((int) curr.item % 2 == 0) {
         
            evens.addNode(curr.item);
         }
      }
      
      return evens;
   }  
}