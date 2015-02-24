//Dan Herve
//CSCD 300: Lab 3

public class RoundRobin_Processing {

   private class Node { //Nested class for easy access within Linked List
   
      private Node next;
      
      private int pID; //process id
      
      private int data; //data from process
      
      public Node (int pID, int data) { //EVC
      
         this.pID = pID;
         
         this.data = data;
      }
      
      @Override
      public String toString() { //toString
      
         return "pid: " + pID + ", data: " + data;
      }
   }
   
   Node head;
   Node tail; //circular linked list
   int size = 0;
   
   private void addEmpty(int pID, int data) { //add method for an empty list
   
      head = new Node(pID, data);
      tail = head;
      head.next = tail;
      tail.next = head;
      size++;
   }
      
      
   
   public void addFirst(int pID, int data) { //adds a node at the beginning of the list
   
      if (size ==0) {
      
         addEmpty(pID, data);
      }
      
      else {
      
         Node temp = new Node(pID, data);
      
         tail.next = temp;
         temp.next = head;
         head = temp;
      }
      
      size++;
   }
   
   public void add(int pID, int data) { //adds node ordered by the pID
   
      Node curr;
      Node prev;
      
      if (size == 0) {
      
         addEmpty(pID, data);
      }
      
      else if (size == 1) {
      
         Node temp = new Node(pID, data);
         
         if (temp.pID < head.pID) {
            
            addFirst(pID, data);
         }
         
         else {
         
            temp.next = head.next;
            head.next = temp;
            tail = head.next;
            size++;
         }
      }
      
      else {
      
         Node temp = new Node(pID, data);
      
         for(prev = head, curr = head; prev.next != head; prev = curr, curr = curr.next) {
            
            if (temp.pID < curr.pID && temp.pID > prev.pID) {
            
               temp.next = curr;
               prev.next = temp;
               
            }
            
            else if (temp.pID > curr.pID && temp.pID < curr.next.pID) {
            
               temp.next = curr.next;
               curr.next = temp;
               
            }
            
            else if (curr.next == head && temp.pID > curr.pID) {
            
               temp.next = curr.next;
               curr.next = temp;
            }
         }
         
         if (temp.next == head) {
         
            tail = temp;
         }
         
         size++;
      }
   }
   
   public void remove(int pID) { //removes a node by the pID
      
      Node curr;
      Node prev;
      
      if (size == 0);
      
      else {
      
         for(prev = tail, curr = head; curr.next != head; prev = curr, curr = curr.next) {
         
            if(curr.pID == pID) {
            
               prev.next = curr.next;
               
               if (head == curr) {
               
                  head = curr.next;
               }
            }
         }
      }
      
      size--;
   }
   
   public void process(int serviceTime) { //cycles through nodes subtracting service time.
   
      Node curr;
   
      for (curr = head; size > 0; curr = curr.next) {
      
         curr.data -= serviceTime;
         
         if (curr.data <= 0) { //at 0 or less, removes the node
         
            if (size == 1) {
            
               System.out.print(curr.pID); //this prints the last process, no "," after
            }
            
            else {
            
               System.out.print(curr.pID + ","); //prints the process when it finishes
            }
            
            int temp = curr.pID;
            
            remove(temp);
         }
      }
   }
   
   public int getSize() {
   
      return size;
   }
   
   @Override
   public String toString() { //toString method
   
      String s = "";
      
      Node curr;
      
      if(size == 0) {
         
         return "There are no processes";
      }
      
      else {
      
         int i = 0;
      
         for(curr = head; i < size; curr = curr.next, i++) {
      
            s += curr.toString() + "\n";
         }
      }
      
      return s;      
   }        
}