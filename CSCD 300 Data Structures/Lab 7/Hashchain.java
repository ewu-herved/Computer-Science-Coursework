public class Hashchain {

   int tableSize = 0;
   int elements = 0;
   LinkedList[] table;
   
   public Hashchain(int tableSize) {
   
      table = new LinkedList[tableSize];
      
      this.tableSize = tableSize;
      
      for(int i = 0; i < tableSize; i++) {
         
         table[i] = new LinkedList();
      }
   }
   
   public int getSize(){
   
      return elements;
   }
   
   public Comparable get(int key, Comparable data) {
   
      int index;
      
      index = (7 * key + 29) % 5;
      
      return table[index].getData(data);
   }
   
   public void put(int key, Comparable data) {
      
      int index;
      
      index = (7 * key + 29) % 5;
      
      table[index].addOrdered(data);
      elements++;
   }
   
   public Comparable remove(int key, Comparable data) {
   
      int index;
      
      index = (7 * key + 29) % 5;
      
      return table[index].removeOrdered(data);
   }
   
   public void printAll() {
   
      for(int i = 0; i < tableSize; i++) {
      
         if(table[i].size == 0)
            System.out.println("(Empty)");
         else {
            table[i].printList();
            System.out.println();
         }
      }
      
      System.out.println();
   }
}