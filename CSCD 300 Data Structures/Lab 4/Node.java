public class Node implements Comparable<Node> {

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