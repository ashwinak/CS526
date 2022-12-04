package cs526;

//package LinkedList;

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

/**
 * A basic doubly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

// modified for a course assignment

public class DoublyLinkedList<E> {

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private DoubleLinkNode<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private DoubleLinkNode<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new DoubleLinkNode<>(null, null, null);      // create header
        trailer = new DoubleLinkNode<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    public DoubleLinkNode<E> getHeader() {return header;}
    public DoubleLinkNode<E> getTrailer() {return trailer;}
    public void setHeader(DoubleLinkNode<E> h) {header = h;}
    public void setTrailer(DoubleLinkNode<E> t) {trailer = t;}

    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();   // first element is beyond header
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();    // last element is before trailer
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());    // place just after the header
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) return null;                  // nothing to remove
        return remove(header.getNext());             // first element is beyond header
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if (isEmpty()) return null;                  // nothing to remove
        return remove(trailer.getPrev());            // last element is before trailer
    }

    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor   node just before the location where the new element is inserted
     * @param successor     node just after the location where the new element is inserted
     */
    public void addBetween(E e, DoubleLinkNode<E> predecessor, DoubleLinkNode<E> successor) {
        // create and link a new node
        DoubleLinkNode<E> newest = new DoubleLinkNode<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    public E remove(DoubleLinkNode<E> node) {
        DoubleLinkNode<E> predecessor = node.getPrev();
        DoubleLinkNode<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        DoubleLinkNode<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }


    // added
    // insertion sort


} //----------- end of DoublyLinkedList class -----------
