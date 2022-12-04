package cs526.nodeTrees;
// make sure all files in nodeTrees package are accessible
// some files in nodeTrees may need files from net.datastructures

public class Hw3_p7 {

	public static void main(String[] args) {

		IntBST t = new IntBST();

		int[] a1 = {10};
		int[] a2 = {10, 20, 30};
		int[] a3 = {10, 20, 30, 40, 50, 60, 70};
		int[] a4 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150};

		/** Input for edge case with even elements. The task is to create complete binary tree with internal nodes
		 * having 2 children. Array with even elements cannot have complete binary tree. The below logic
		 * ensures array input with even size will not attempt to build a complete binary tree.
		 *
		 *
		 */
		int[] a5 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140};
		int[] a6 = {10, 20, 30, 40, 50, 60};
		/**
		 * Edge case input with odd elements in the array, but even elements in the left and right
		 * sub array after removing the root element from the array. This will create an incomplete binary tree.
		 *
		 * For cases with n = 1,3,7,15 a complete binary tree will be built.
		 */
		int[] a7 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160,170};
		int[] a8 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};


		int[] arr = a4; // test with other arrays too
		t = IntBST.makeBinaryTree(arr);
		t.setSize(arr.length);
		if (t.size%2 == 0){
			System.out.println("Cannot build a complete binary tree. Array size is even");
		}
		else {
			System.out.println("Tree size: " + t.size());
			System.out.println("Tree height: " + t.height(t.root));
			System.out.println("");
			t.print(t.root);
		}
	}
}
