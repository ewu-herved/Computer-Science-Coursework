//Dan Herve
//CSCD 300: Lab 8

public class BST {
   
   Node root; //global root
   
   public BST() {
   
      root = null;
   }
   
   public Node search(int key) {
   
      Node curr = root;
      
      while(curr != null) { //checks for empty tree
      
         if(curr.key == key) {
         
            return curr;
         }
         
         else if(key < curr.key) { //goes left
         
            curr = curr.left;
         }
         else { //goes right
         
            curr = curr.right;
         }
      }      
      
      return curr;
   }
   
   public Node insert(int key) {
   
      Node temp = new Node(key);
   
      Node curr = root;
      Node prev = null;
      
      while(curr != null) { //checks for empty tree
      
         prev = curr;
         if(curr.key == key) {
         
            return null;
         }
         
         else if(key < curr.key) { //looks for leaf nodes
            
            curr = curr.left;
         }
         else {
         
            curr = curr.right; 
         }
      }
      
      temp.parent = prev; //prev will be on the parent of the new key
      
      if(prev == null) //prev is the global root
         root = temp;
      else if(key < prev.key)
         prev.left = temp;
      else
         prev.right = temp;
      
      return temp;
   }
   
   public Node delete(int key) {
   
      Node node = search(key);
      
      if(node != null)
         delete(node);
      
      return node;
   }
   
   private void transplant(Node old_subtree, Node new_subtree) {
   
      if(old_subtree.parent == null) //tree is empty
         root = new_subtree;
      else if(old_subtree == old_subtree.parent.left) //old_subtree is the left child
         old_subtree.parent.left = new_subtree;
      else //old_subtree is the right child
         old_subtree.parent.right = new_subtree;
         
      if(new_subtree != null) //assigns new_subtree's parent
         new_subtree.parent = old_subtree.parent;
   }
   
   private void delete(Node node) {
   
      Node temp = null;
   
      if(node.left == null && node.right == null) //only one node
         transplant(node, null);
      else if(node.left == null) //no left children
         transplant(node, node.right);
      else if(node.right == null) //no right children
         transplant(node, node.left);
      else { //has two children
         temp = min(node.right); //find the successor
         if(temp.parent != node) {
            transplant(temp, temp.right);
            temp.right = node.right;
            temp.right.parent = temp;
         }
         transplant(node, temp);
         temp.left = node.left;
         temp.left.parent = temp;
      }
   }
   
   public void inOrder_traversal(Node subtree_root) {
   
      if(subtree_root != null) {
      
         inOrder_traversal(subtree_root.left);
         System.out.println(subtree_root.key);
         inOrder_traversal(subtree_root.right);
      }   
   }
   
   public void preOrder_traversal(Node subtree_root) {
   
      if(subtree_root != null) {
         
         System.out.println(subtree_root.key);
         inOrder_traversal(subtree_root.left);
         inOrder_traversal(subtree_root.right);
      }
   }
   
   public void postOrder_traversal(Node subtree_root) {
   
      if(subtree_root != null) {
         
         inOrder_traversal(subtree_root.left);
         inOrder_traversal(subtree_root.right);
         System.out.println(subtree_root.key);
      }
   }
   
   public void levelOrder_traversal(Node subtree_root) {
   
      ListQueue q = new ListQueue();
      
      q.enqueue(subtree_root);
      
      while(q.size > 0) {
      
         Node temp = (Node)q.dequeue();
         System.out.println(temp.key);
         if(temp.left != null)
            q.enqueue(temp.left);
         if(temp.right != null)
            q.enqueue(temp.right);
      } 
   }
   
   public Node max(Node subtree_root) {
   
      Node curr = subtree_root;
      
      while(curr.right != null)
         curr = curr.right;
      
      return curr;
   }
   
   public Node min(Node subtree_root) {
   
      Node curr = subtree_root;
      
      while(curr.left != null)
         curr = curr.left;
      
      return curr;
   }
   
   public Node successor(Node node) {
   
      if(node.right != null)
         return min(node.right);
         
      Node temp = node.parent;
      
      while(temp != null && node == temp.right) {        
         node = temp;
         temp = temp.parent;
      }
      
      return temp;
   }
   
   public Node predecessor(Node node) {
   
      if(node.left != null)
         return max(node.left);
         
      Node temp = node.parent;   
         
      while(temp != null && node == temp.left) {
         node = temp;
         temp = temp.parent;
      }   
      
      return temp;
   }   
}