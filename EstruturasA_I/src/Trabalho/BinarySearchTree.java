package Trabalho;

public class BinarySearchTree<K extends Comparable<K>, V> implements BinarySearchTreeADT<K, V> {

	protected Node root;

	protected class Node {
		private K key;
		private V value;
		private Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public Node next(K other) {
			return other.compareTo(key) < 0 ? left : right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		@Override
		public String toString() {
			return "" + key;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}

	@Override
	public V search(K key) {
		// TODO Auto-generated method stub
		return search(root, key);

	}

	private V search(Node node, K key) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.key) == 0) {
			return node.value;
		}
		return search(node.next(key), key);
	}

	@Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
		root = insert(root, key, value);
	}

	private Node insert(Node node, K key, V value) {
		if (node == null) {
			return new Node(key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = insert(node.right, key, value);
		} else if (key.compareTo(node.key) < 0) {
			node.left = insert(node.left, key, value);
		}

		return node;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return root == null ? "[empty]" : printTree(new StringBuffer());
	}

	private String printTree(StringBuffer sb) {
		if (root.right != null) {
			printTree(root.right, true, sb, "");
		}
		sb.append(root + "\n");
		if (root.left != null) {
			printTree(root.left, false, sb, "");
		}

		return sb.toString();
	}

	private void printTree(Node node, boolean isRight, StringBuffer sb, String indent) {
		if (node.right != null) {
			printTree(node.right, true, sb, indent + (isRight ? "        " : " |      "));
		}
		sb.append(indent + (isRight ? " /" : " \\") + "----- " + node + "\n");
		if (node.left != null) {
			printTree(node.left, false, sb, indent + (isRight ? " |      " : "        "));
		}
	}

	@Override
	public boolean delete(K key) {
		// TODO Auto-generated method stub
		return deleteByCopying(key);

	}

	private boolean deleteByCopying(K key) {
		Node parent = null, current = root;
		for (; current != null && key.compareTo(current.key) != 0; parent = current, current = current.next(key))
			;

		if (current == null)
			return false;
		else if (current.left != null && current.right != null) {
			// Caso 3
			Node tmp = current.left;
			while (tmp.right != null)
				tmp = tmp.right;
			deleteByCopying(tmp.key);
			current.key = tmp.key;
		} else {
			// Caso 1 ou Caso 2
			Node nextNode = current.right == null ? current.left : current.right;
			if (current.equals(root))
				root = nextNode;
			else if (parent.left.equals(current))
				parent.left = nextNode;
			else
				parent.right = nextNode;
		}

		return true;
	}

	@Override
	public void preOrder() {
		// TODO Auto-generated method stub
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	@Override
	public void inOrder() {
		// TODO Auto-generated method stub
		inOrder(root);

	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node + " ");
			inOrder(node.right);
		}
	}

	@Override
	public void postOrder() {
		// TODO Auto-generated method stub
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node + " ");
		}
	}

	@Override
	public void levelOrder() {
		// TODO Auto-generated method stub
		levelOrder(root);
	}

	private void levelOrder(Node node) {
		if (node != null) {

			if (node == root)
				System.out.println(node + " ");

			if (node.left != null) {
				System.out.println(node.left);
			}

			if (node.right != null) {
				System.out.println(node.right);
			}

			levelOrder(node.left);
			levelOrder(node.right);
		}
	}

	@Override
	public int countNodes() {
		// TODO Auto-generated method stub

		return countNodes(root);
	}

	private int countNodes(Node node) {

		int count = 0; 
		
        if (node != null) {  
            count += 1;  
            count += countNodes(node.right);
            count += countNodes(node.left); 
            }
        
        return count;  
    
	}

	@Override
	public int countInternalNodes() {
		// TODO Auto-generated method stub
		return countInternalNodes(root);
	}
	
	private int countInternalNodes(Node node) {
		
		if(root == null) {return 0;}
		
		int count = 0;
		
		if(node != null && (node.right != null || node.left != null)) {
			if(node != root) {count += 1;}
			count += countInternalNodes(node.left);
			count += countInternalNodes(node.right);
		}
		
		
		
		
		return count ;
	}

	@Override
	public int countLeaves() {
		// TODO Auto-generated method stub
		return countLeaves(root);
	}
	
	private int countLeaves(Node node) {
		if(root == null) {return 0;}
		
		int count = 0;
	
		if(node != null ) {
			if(node.isLeaf()) {count += 1;}
			
			count += countLeaves(node.left);
			count += countLeaves(node.right);
		}
		
		
		return count;
	}

	@Override
	public int degree(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int degreeTree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int heightTree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int depth(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String ancestors(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String descendents(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
