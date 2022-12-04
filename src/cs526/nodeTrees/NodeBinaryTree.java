/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cs526.nodeTrees;

import java.util.Stack;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class NodeBinaryTree<E> extends AbstractBinaryTree<E> {

	
	/** Factory function to create a new node storing element e. */
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}

	// NodeBinaryTree instance variables
	/** The root of the binary tree */
	public Node<E> root = null; // root of the tree

	/** The number of nodes in the binary tree */
//	private int size = 0; // number of nodes in the tree
	protected int size = 0;
			
	// constructor
	/** Constructs an empty binary tree. */
	public NodeBinaryTree() { } // constructs an empty binary tree

	// accessor methods (not already implemented in AbstractBinaryTree)
	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return number of nodes in the tree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the root Node of the tree (or null if tree is empty).
	 * 
	 * @return root Node of the tree (or null if tree is empty)
	 */
	@Override
	public Node<E> root() {
		return root;
	}

	/**
	 * Returns the Node of n's parent (or null if n is root).
	 *
	 * @param n A valid Node within the tree
	 * @return Node of n's parent (or null if n is root)
	 * @throws IllegalArgumentException if n is not a valid Node for this tree.
	 */
	@Override
	public Node<E> parent(Node<E> n) throws IllegalArgumentException {
		return n.getParent();
	}

	/**
	 * Returns the Node of n's left child (or null if no child exists).
	 *
	 * @param n A valid Node within the tree
	 * @return the Node of the left child (or null if no child exists)
	 * @throws IllegalArgumentException if n is not a valid Node for this tree
	 */
	@Override
	public Node<E> left(Node<E> n) throws IllegalArgumentException {
		return n.getLeft();
	}

	/**
	 * Returns the Node of n's right child (or null if no child exists).
	 *
	 * @param n A valid Node within the tree
	 * @return the Node of the right child (or null if no child exists)
	 * @throws IllegalArgumentException if n is not a valid Node for this tree
	 */
	@Override
	public Node<E> right(Node<E> n) throws IllegalArgumentException {
		return n.getRight();
	}

	// update methods supported by this class
	/**
	 * Places element e at the root of an empty tree and returns its new Node.
	 *
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */
	public Node<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Creates a new left child of Node n storing element e and returns its
	 * Node.
	 *
	 * @param n the Node to the left of which the new element is inserted
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalArgumentException if n is not a valid Node for this tree
	 * @throws IllegalArgumentException if n already has a left child
	 */
	public Node<E> addLeft(Node<E> n, E e) throws IllegalArgumentException {
		Node<E> parent = n;
		if (parent.getLeft() != null)
			throw new IllegalArgumentException("n already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	/**
	 * Creates a new right child of Node n storing element e and returns its
	 * Node.
	 *
	 * @param n the Node to the right of which the new element is inserted
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalArgumentException if n is not a valid Node for this tree.
	 * @throws IllegalArgumentException if n already has a right child
	 */
	public Node<E> addRight(Node<E> n, E e) throws IllegalArgumentException {
		Node<E> parent = n;
		if (parent.getRight() != null)
			throw new IllegalArgumentException("n already has a right child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	/**
	 * Replaces the element at Node n with element e and returns the replaced
	 * element.
	 *
	 * @param n the relevant Node
	 * @param e the new element
	 * @return the replaced element
	 * @throws IllegalArgumentException if n is not a valid Node for this tree.
	 */
	public E set(Node<E> n, E e) throws IllegalArgumentException {
		E temp = n.getElement();
		n.setElement(e);
		return temp;
	}

	/**
	 * Attaches trees t1 and t2, respectively, as the left and right subtree of the
	 * leaf Node n. As a side effect, t1 and t2 are set to empty trees.
	 *
	 * @param n  a leaf of the tree
	 * @param t1 an independent tree whose structure becomes the left child of n
	 * @param t2 an independent tree whose structure becomes the right child of n 
	 * @throws IllegalArgumentException if n  is not a valid Node for this tree
	 * @throws IllegalArgumentException if n is not a leaf
	 */
	public void attach(Node<E> n, NodeBinaryTree<E> t1, NodeBinaryTree<E> t2) throws IllegalArgumentException {
		if (isInternal(n))
			throw new IllegalArgumentException("n must be a leaf");
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) { // attach t1 as left subtree of node
			t1.root.setParent(n);
			n.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) { // attach t2 as right subtree of node
			t2.root.setParent(n);
			n.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	/**
	 * Removes the node at Node n and replaces it with its child, if any.
	 *
	 * @param n the relevant Node
	 * @return element that was removed
	 * @throws IllegalArgumentException if n is not a valid Node for this tree.
	 * @throws IllegalArgumentException if n has two children.
	 */
	public E remove(Node<E> n) throws IllegalArgumentException {
		if (numChildren(n) == 2)
			throw new IllegalArgumentException("n has two children");
		Node<E> child = (n.getLeft() != null ? n.getLeft() : n.getRight());
		if (child != null)
			child.setParent(n.getParent()); // child's grandparent becomes its parent
		if (n == root)
			root = child; // child becomes root
		else {
			Node<E> parent = n.getParent();
			if (n == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = n.getElement();
		n.setElement(null); // help garbage collection
		n.setLeft(null);
		n.setRight(null);
		n.setParent(n); // our convention for defunct node
		return temp;
	}

	
	/**
	 * Print a binary tree horizontally
	 * Modified version of https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 * Modified by Keith Gutfreund
	 * @param n Node in tree to start printing from
	 */
	void print(Node<E> n){ 
		print ("", n); 
	}
	
	public void print(String prefix, Node<E> n){
	  if (n != null){
	    print(prefix + "       ", right(n));
	    System.out.println (prefix + ("|-- ") + n.getElement());
	    print(prefix + "       ", left(n));
	  }
	}
	
	
	
} // ----------- end of NodeBinaryTree class -----------
