//design and implement a method height for BinarySearchTree, the returns the height of the tree
//using recursion
//does not use recursion

import ch07.trees.*;
import support.*;
import java.util.*;   // Iterator, Comparator
import support.BSTNode;  
import ch04.queues.*;
import ch02.stacks.*;

public class MyBinarySearchTree<T> extends BinarySearchTree<T> {

   public BSTNode<T> getRoot() {
      return root;
   }

   //returns the height of a tree using recursion
   public int recHeight (BSTNode<T> node) {
      int lHeight;
      int rHeight;
      int recHeight = 0;
      
      //start at the root
      //go to the left node << recursion
      //until no more left nodes
      //go back up one level
      //for each level increment the height variable     
      if (root == null) {
         return 0; 
      } else { 
         // compute the depth of each subtree 
         if (node != null) {
            lHeight = recHeight(node.getLeft());
            rHeight = recHeight(node.getRight());
            
            if (lHeight > rHeight){
               recHeight = lHeight + 1;
            }else{
               recHeight = rHeight + 1;
            }
         }
         return recHeight;
      }
   }

   //returns the height of a tree w/o recursion
   public int iterHeight() {
      
      if (root == null)
         return 0;

      // Create an empty BSTQueue for traversal
      Queue<BSTNode> BSTQ = new LinkedList();
      
      // add BSTQueue Root and initialize height
      BSTNode<T> currNode;
      int height = 0;
      BSTQ.add(root);

         while (true) {
            int nodeSum = BSTQ.size();
            if (nodeSum == 0)
            return height;
            height++;

            while (nodeSum > 0) {
               BSTNode newNode = BSTQ.peek();
               BSTQ.remove();
               if (newNode.getLeft() != null){
                  BSTQ.add(newNode.getLeft());
               }
               if (newNode.getRight() != null){
                  BSTQ.add(newNode.getRight());
               }
               nodeSum--;
            }
         } 
   }
   //added this method to override book file
   //book file seemed to have a typo(?) 
   public boolean add (T element) {
   // Adds element to this BST. The tree retains its BST property.
  
    BSTNode<T> newNode = new BSTNode<T>(element);
    BSTNode<T> prev = null, curr = null;
    
    if (root == null)
      root = newNode;
    else
    {
      curr = root;
      while (curr != null)
      {
        if (comp.compare(element, curr.getInfo()) <= 0)
        {
          prev = curr;
          curr = curr.getLeft();
        }
        else
        {
          prev = curr;
          curr = curr.getRight();
        }
      }
      if (comp.compare(element, prev.getInfo()) <= 0)
        prev.setLeft(newNode);
      else
        prev.setRight(newNode);//setRight?, previously said 'setLeft'
    }
    return true;
  }   
}