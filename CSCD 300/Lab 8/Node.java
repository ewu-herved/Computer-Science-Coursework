public class Node implements Comparable<Node> {

   int key;
   Node left;
   Node right;
   Node parent;

   public Node(int key) {
      this.key = key;
      parent = left = right = null;
   }
   
   @Override
   public int compareTo(Node that) {
   
      return this.key - that.key;
   }
}