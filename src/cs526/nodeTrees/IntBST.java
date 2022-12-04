package cs526.nodeTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// binary search tree storing integers
public class IntBST extends NodeBinaryTree<Integer> {

	//private int size = 0;

	public IntBST() {	}

	public int size() {
		return size;
	}

	public void setSize(int s) { size = s; }

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Places element e at the root of an empty tree and returns its new Node.
	 *
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */

	public Node<Integer> addRoot(Integer e) throws IllegalStateException {
		if (size != 0)
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Print a binary tree horizontally Modified version of
	 * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 * Modified by Keith Gutfreund
	 *
	 * @param n Node in tree to start printing from
	 */

	public void print(Node<Integer> n){ print ("", n); }

	public void print(String prefix, Node<Integer> n){
		if (n != null){
			print(prefix + "       ", right(n));
			System.out.println (prefix + ("|-- ") + n.getElement());
			print(prefix + "       ", left(n));
		}
	}


	public void inorderPrint(Node<Integer> n) {
		if (n == null)
			return;
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}


	public Iterable<Node<Integer>> children(Node<Integer> n) {
		List<Node<Integer>> snapshot = new ArrayList<>(2); // max capacity of 2
		if (left(n) != null)
			snapshot.add(left(n));
		if (right(n) != null)
			snapshot.add(right(n)); return snapshot;
	}

	public int height(Node<Integer> n) throws IllegalArgumentException {
		if (isExternal(n)) { return 0; }
		int h = 0; // base case if p is external
		for (Node<Integer> c : children(n)) h = Math.max(h, height(c)); return h + 1;
	}

	public static IntBST binTreeBuilder (int [] a) {
		IntBST subtree = new IntBST();
		/**
		 * This is the base case when the size of input array is zero, recursion stops and returns the subtree built so far.
		 */
		if (a.length ==0 ) {
			return subtree;
		}

		/** The below section of the code will be used when subarray element size is even, but the
		 * main array size is odd. For inputs such as a7 and a8 in the hw_3_p7.java.
		 *
		 * If the subarry size is odd, then the else block of the code will be used. For inputs a1 to a4.
		 *
		 * The root will be the mid-point index -1. The array is further subdivided using
		 * copyOfRange method from Arrays such that it does not include the root element in
		 * either left or right subarray. The attach method will attach the root node to the left and right sub array.
		 * The attach method's t1 and t2 tree is built recursively, while n(root node) remains same. The above steps
		 * will continue recursively until the base case is hit where the input array size is zero, the method exits
		 * and returns the subtree to the calling method. The Array is chopped evenly during every recursively call
		 * using the copyOfRange method. Eventually, the array becomes empty and the base case is hit.
		 *
		 */
		if (a.length%2 == 0) {
			int root = a[(a.length/2)-1];
			Node n = subtree.addRoot(root);
			int[] leftSubArr = Arrays.copyOfRange(a,0,(a.length/2)-1);
			int[] rightSubArr = Arrays.copyOfRange(a,(a.length/2),a.length);
			subtree.attach(n,binTreeBuilder(leftSubArr),binTreeBuilder(rightSubArr));
		}
		else {
			int root = a[(a.length/2)];
			Node n = subtree.addRoot(root);
			int[] leftSubArr = Arrays.copyOfRange(a,0,(a.length/2));
			int[] rightSubArr = Arrays.copyOfRange(a,(a.length/2)+1,a.length);
			subtree.attach(n,binTreeBuilder(leftSubArr),binTreeBuilder(rightSubArr));
		}
		return subtree;
	}
	public static IntBST makeBinaryTree(int[] a){
		/**
		 * This is the main method which uses a helper method binTreeBuilder which is invoked recursively
		 * in its own method. First the mid-point index value of the original array is stored as root.
		 * The array is divided into left and right sub array using mid-point as reference.
		 * The left and right sub array are given
		 * as input argument to the helper method binTreeBuilder. The helper method recursively creates the subtree
		 * using the middle node as root from its input array. The attach method in binTreeBuilder then attaches the resulting
		 * root node and output of the recursive method binTreeBuilder.
		 * The helper method returns two subtrees. The attach method below uses those two subtress and the root node to creat
		 * a full complete binary tree. This complete binary tree btree is returned to the main method.
		 *
		 *
		 *
		 */

		IntBST btree = new IntBST();
		int root = a[(a.length/2)];
		Node n = btree.addRoot(root);
		int[] left = Arrays.copyOfRange(a,0,(a.length/2));
		int[] right = Arrays.copyOfRange(a,(a.length/2)+1,a.length);
		btree.attach(n,binTreeBuilder(left),binTreeBuilder(right));
		return btree;
	}
}
