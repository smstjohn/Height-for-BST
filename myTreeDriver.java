//driver class for MyBinarySearchTree<T>
public class myTreeDriver {

   public static void main(String[] args ) {
      
    MyBinarySearchTree<Integer> testTree = new MyBinarySearchTree<Integer>();
    
    testTree.add(7); testTree.add(5); testTree.add(8); testTree.add(12); 
    testTree.add(2); testTree.add(6); testTree.add(3); testTree.add(9); 
    testTree.add(4); testTree.add(11); testTree.add(1);  
    
    System.out.println("The height of the tree using recursion is: " + (testTree.recHeight(testTree.getRoot())) );
    
    System.out.println("The height of the tree without using recursion is: " + testTree.iterHeight() );

   }
}