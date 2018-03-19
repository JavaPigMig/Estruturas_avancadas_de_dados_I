package Trabalho;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTreeADT<Integer, Integer> tree = new BinarySearchTree<>();
		
		tree.insert(4, 10);
		tree.insert(2,20);
		tree.insert(6,30);
		tree.insert(8,40);
		tree.insert(3,100);
		tree.insert(5,2);
		tree.insert(7,32);
		
		
		System.out.println( tree.toString());
		
		 //tree.preOrder();
		 //tree.levelOrder();
		 
		 System.out.println(tree.countNodes());
		 
		 System.out.println(tree.countInternalNodes());
		 
		 System.out.println(tree.countLeaves());
	}

}
