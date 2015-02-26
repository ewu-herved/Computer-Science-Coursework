public class ArrayQueue {  
   
   private int head = 0;
   private int tail = 0;
   private Comparable[] queue;
   private int size = 0;
   private int capacity;
   
   public ArrayQueue(int capacity) {
   
      queue = new Comparable[capacity];
      this.capacity = capacity;
   }
   
   public ArrayQueue(Comparable[] array) {
   
      queue = array;
      tail = queue.length - 1;
      capacity = array.length - 1;
   }
   
   public int getSize() {
   
      return size;
   }
   
   public int getCapacity() {
   
      return capacity;
   }
   
   public int getHead() {
   
      return head;
   }
   
   public int getTail() {
   
      return tail;
   }
   
   public Comparable getData() {
   
      return queue[head];
   }
   
   public void enqueue(Comparable data) {
   
      if (size == capacity) {
      
         System.out.print("Queue is full.");
      }
      
      else if (size == 0) {
      
         queue[head] = data;
         size++;
      }
      
      else {
      
         queue[(tail + 1) % capacity] = data;
         tail = (tail + 1) % capacity;
         size++;
      }
   }
   
   public Comparable dequeue() {
   
      if (size == 0) {
      
         System.out.println("Queue is empty");
         return null;
      }
      
      else if (size == 1) {
         
         Comparable temp = queue[head];
         queue[head] = null;
         head = 0;
         tail = 0;
         size--;
         return temp;
      }
      
      else {
      
         Comparable temp = queue[head];
         queue[head] = null;
         head = (head + 1) % capacity;
         size--;
         return temp;
      }
   }  
}
   
      
   