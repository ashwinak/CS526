package cs526;
//package LinkedList;

/**
 * Node of a doubly linked list, which stores a reference to its
 * element and to both the previous and next node in the list.
 */
public class DoubleLinkNode<E> {

    /** The element stored at this DoubleLinkNode */
    private E element;               // reference to the element stored at this DoubleLinkNode

    /** A reference to the preceding DoubleLinkNode in the list */
    private DoubleLinkNode<E> prev;            // reference to the previous DoubleLinkNode in the list

    /** A reference to the subsequent DoubleLinkNode in the list */
    private DoubleLinkNode<E> next;            // reference to the subsequent DoubleLinkNode in the list

    /**
     * Creates a DoubleLinkNode with the given element and next DoubleLinkNode.
     *
     * @param e  the element to be stored
     * @param p  reference to a DoubleLinkNode that should precede the new DoubleLinkNode
     * @param n  reference to a DoubleLinkNode that should follow the new DoubleLinkNode
     */
    public DoubleLinkNode(E e, DoubleLinkNode<E> p, DoubleLinkNode<E> n) {
        element = e;
        prev = p;
        next = n;
    }

    // public accessor methods
    /**
     * Returns the element stored at the DoubleLinkNode.
     * @return the element stored at the DoubleLinkNode
     */
    public E getElement() { return element; }

    /**
     * Returns the DoubleLinkNode that precedes this one (or null if no such DoubleLinkNode).
     * @return the preceding DoubleLinkNode
     */
    public DoubleLinkNode<E> getPrev() { return prev; }

    /**
     * Returns the DoubleLinkNode that follows this one (or null if no such DoubleLinkNode).
     * @return the following DoubleLinkNode
     */
    public DoubleLinkNode<E> getNext() { return next; }

    // Update methods
    /**
     * Sets the DoubleLinkNode's previous reference to point to DoubleLinkNode n.
     * @param p    the DoubleLinkNode that should precede this one
     */
    public void setPrev(DoubleLinkNode<E> p) { prev = p; }

    /**
     * Sets the DoubleLinkNode's next reference to point to DoubleLinkNode n.
     * @param n    the DoubleLinkNode that should follow this one
     */
    public void setNext(DoubleLinkNode<E> n) { next = n; }
}
