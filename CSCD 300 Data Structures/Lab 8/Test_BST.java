//Dan Herve
//CSCD 300: Lab 8

import java.util.*;
import java.io.*;

public class Test_BST {

   public static void main(String[] args) {
   
      try {
   
         Scanner input = new Scanner(new File(args[0]));
         BST tree = new BST();         
      
         while(input.hasNextInt()) {
         
            tree.insert(input.nextInt());
         }
         
         Scanner kb = new Scanner(System.in);
         
         char choice = '0'; //for menu choices
         Node answer = null; //Where Nodes returned by switch are stored temporarily
         
         do {
         
            try {
            
               System.out.print("Choose one of the following options.\n" +
                                  "====================================\n" +
                                  "1) Search for a key\n" +
                                  "2) Insert a new key\n" +
                                  "3) Delete an existing key\n" +
                                  "4) Inorder traversal of the BST\n" +
                                  "5) Preorder traversal of the BST\n" +
                                  "6) Postorder traversal of the BST\n" +
                                  "7) Lever-order traversal of the BST\n" +
                                  "8) Find the smallest key\n" +
                                  "9) Find the largest key\n" +
                                  "a) Find the successor of a given key\n" +
                                  "b) Find the predecessor of a given key\n" +
                                  "x) quit\n\n" +
                                  "Your choice: ");
                                  
               choice = kb.next().charAt(0);
               
               System.out.println("");
         
               switch(choice) {
               
                  case '1': System.out.print("Enter a key: ");
                            answer = tree.search(kb.nextInt());
                            System.out.println("");
                            if(answer != null)
                              System.out.println("The given key exists.\n");
                            else 
                              System.out.println("The given key does not exist.\n");
                            break;
                          
                  case '2': System.out.print("Enter a key: ");
                            answer = tree.insert(kb.nextInt());
                            System.out.println("");
                            if(answer == null)
                              System.out.println("The given key already exists.\n");
                            else 
                              System.out.println("The given key has been inserted successfully.\n");
                            break;
                          
                  case '3': System.out.print("Enter a key: ");
                            answer = tree.delete(kb.nextInt());
                            System.out.println("");
                            if(answer == null)
                              System.out.println("The given key does not exist.\n");
                            else 
                              System.out.println("The given key has been successfully deleted.\n");
                            break;
                          
                  case '4': tree.inOrder_traversal(tree.root);
                            System.out.println("");
                            break;
                          
                  case '5': tree.preOrder_traversal(tree.root);
                            System.out.println("");
                            break;
                          
                  case '6': tree.postOrder_traversal(tree.root);
                            System.out.println("");
                            break;
                          
                  case '7': tree.levelOrder_traversal(tree.root);
                            System.out.println("");
                            break;
                          
                  case '8': answer = tree.min(tree.root);
                            if(answer == null)
                              System.out.println("The tree is empty.\n");
                            else 
                              System.out.println(answer.key + "\n");
                            break;
                          
                  case '9': answer = tree.max(tree.root);
                            if(answer == null)
                              System.out.println("The tree is empty.\n");
                            else 
                              System.out.println(answer.key + "\n");
                            break;
                            
                  case 'a': System.out.print("Enter a key: ");
                            answer = tree.search(kb.nextInt());
                            System.out.println("");
                            if(answer == null)
                              System.out.println("The given key does not exist.\n");
                            else {
                              answer = tree.successor(answer);
                              if(answer == null)
                                 System.out.println("The given key exists but does not have a successor.\n");
                              else 
                                 System.out.println("The successor is " + answer.key + "\n");
                            }     
                            break;
                            
                  case 'b': System.out.print("Enter a key: ");
                            answer = tree.search(kb.nextInt());
                            System.out.println("");
                            if(answer == null)
                              System.out.println("The given key does not exist.\n");
                            else {
                              answer = tree.predecessor(answer);
                              if(answer == null)
                                 System.out.println("The given key exists but does not have a predecessor.\n");
                              else 
                                 System.out.println("The successor is " + answer.key + "\n");
                            } 
                            break;
                            
                  case 'x': System.out.println("Thank you and have a nice day!\n");
                            break;
                  
                  default: System.out.println("That is not a valid menu choice.\n");                       
               }
            }
            
            catch(InputMismatchException ex) { //for bad menu choices
            
               System.out.println("That is not a valid input.\n");
               kb.nextLine();
            }
            catch(NoSuchElementException ex) { //""
            
               System.out.println("That is not a valid input.\n");
               kb.nextLine();
            }
         } while(choice != 'x');   
      }
      
      catch(FileNotFoundException e) { //for a bad file
      
         System.out.println("File Not Found.");
         System.out.println("");
      }    
   }
}