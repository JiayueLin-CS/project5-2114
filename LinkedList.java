// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import list.ListInterface;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represented an implementation of the List interface as a chain of
 * doubly-linked nodes with an Iterator and sort functionality.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.20
 * @param <T>
 *            a generic type representing the type of object this LinkedList
 *            holds.
 */
public class LinkedList<T> implements ListInterface<T> {
    // Fields
    private Node firstNode;
    private Node lastNode;
    private int size;

    // Constructor
    /**
     * Creates a new, empty LinkedList.
     */
    public LinkedList() {
        initializeFields();
    }


    /**
     * Initializes the object to have the firstNode and lastNode.
     */
    private void initializeFields() {
        // initialize sentinel nodes
        firstNode = new Node(null);
        lastNode = new Node(null);
        firstNode.setNext(lastNode);
        lastNode.setPrevious(firstNode);
        size = 0;
    }


    // Methods
    /**
     * Gets the number of nodes in the list.
     * 
     * @return An integer representing the size of the list.
     */
    public int size() {
        return size;
    }


    /**
     * Remove all of the elements from the list.
     */
    @Override
    public void clear() {
        initializeFields();
    }


    /**
     * Check if the list contains the given object.
     * 
     * @param anEntry
     *            The object to search for.
     * @return True if the object is in the list, false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        // Traverse the list to find an instance of the entry
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            }
            else {
                currentNode = currentNode.getNext();
            }
        }

        return found;
    }


    /**
     * Adds a node to the end of the list.
     * 
     * @param anEntry
     *            The entry to be added.
     */
    @Override
    public void add(T anEntry) {
        add(size, anEntry);
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public T get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds the object to the position in the list.
     * 
     * 
     * @param index
     *            is the place to add the object.
     * @param obj
     *            is the object to add.
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size.
     * @throws IllegalArgumentException
     *             if the object is null.
     */
    @Override
    public void add(int index, T obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException();
        }

        // Find the node currently at the index
        Node nodeNext = null;
        if (index == size) {
            nodeNext = lastNode;
        }
        else {
            nodeNext = getNodeAtIndex(index);
        }

        // Add the node at the specified location.
        Node newNode = new Node(obj);
        newNode.setPrevious(nodeNext.getPrevious());
        newNode.setNext(nodeNext);
        nodeNext.getPrevious().setNext(newNode);
        nodeNext.setPrevious(newNode);
        size++;
    }


    /**
     * Gets the position of the node.
     * 
     * @param index
     *            is the position given.
     * @return a reference to the node at the given position.
     * @throws IndexOutOfBoundsException
     *             if the index is not between 0 and size.
     */
    private Node getNodeAtIndex(int index) {
        // Make sure index is in bounds
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }


    /**
     * Gets the data of the node at a given position.
     * 
     * @return The data of the node at the specified index.
     */
    @Override
    public T getEntry(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Gets the size of the list.
     * 
     * @return the number of nodes in the list.
     */
    @Override
    public int getLength() {
        return size;
    }


    /**
     * Check if the list is empty or not.
     * 
     * @return if the number of nodes in the list is zero.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Remove nodes from the list.
     * 
     * @return the data of the removed node at the specified index.
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size, or if there
     *             is no element at the index.
     */
    @Override
    public T remove(int index) {
        T result = null; // Return value

        if (index >= 0 && (index < size)) {
            if (index == 0) // Case 1: Remove first entry
            {
                result = firstNode.getData(); // Save entry to be removed
                firstNode = firstNode.getNext(); // Remove entry
            }
            else // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAtIndex(index - 1);
                Node nodeToRemove = nodeBefore.getNext();
                result = nodeToRemove.getData(); // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNext();
                nodeBefore.setNext(nodeAfter); // Remove entry
            }
            size--; // Update count
            return result; // Return removed entry
        }
        throw new IndexOutOfBoundsException(); // if the index is invalid
    }


    /**
     * Replaces the node with a new node.
     * 
     * @param index
     *            is the index being replaced.
     * @param obj
     *            is the original object.
     * @return the new node replaced.
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size.
     */
    @Override
    public T replace(int index, T obj) {
        if ((index >= 0) && (index < size)) {
            Node desiredNode = getNodeAtIndex(index);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(obj);
            return originalEntry;
        }
        throw new IndexOutOfBoundsException();
    }


    /**
     * Returns an array representation of the list.
     * 
     * @return an array representing the list.
     */
    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[size];

        int index = 0;
        Node currentNode = firstNode;
        while (index < size) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }

        return result;
    }


    /**
     * Sorts the linked list in order based on the sorting order given by the
     * comparator.
     * 
     * @param comparator
     *            The comparator providing the sorting order to use.
     */
    public void sort(Comparator<? super T> comparator) {
        // Create an array with the same entries/order as the list
        @SuppressWarnings("unchecked")
        T[] array = (T[])new Object[size];
        for (int index = 0; index < array.length; index++) {
            array[index] = getEntry(index);
        }

        // Sort the array (insertion sort)
        for (int i = 1; i < size; i++) {
            for (int j = i; (j > 0) && (comparator.compare(array[j], array[j
                - 1]) < 0); j--) {
                // swap lesser values to the left
                T swap = array[j];
                array[j] = array[j - 1];
                array[j - 1] = swap;
            }
        }

        // Reset the list and populate it with the proper values in order
        initializeFields();
        for (int k = 0; k < array.length; k++) {
            add(array[k]);
        }
    }


    /**
     * Creates a new iterator for this linked list.
     * 
     * @return a ForwardIterator inside this list.
     */
    public Iterator<T> forwardIterator() {
        return new ForwardIterator<T>();
    }

    // Node private class
    /**
     * This represents a node in a doubly linked list. This node stores data, a
     * pointer to the node before it in the list, and a pointer to the node
     * after it in the list.
     * 
     * @author Ali Yeganeh (aliyeg)
     * @version 2020.11.18
     */
    private class Node {
        // Fields
        private T data;
        private Node previous;
        private Node next;

        // Constructors
        /**
         * Creates a new Node with the specified data.
         * 
         * @param dataField
         *            The data to be stored in the Node.
         */
        public Node(T dataField) {
            this(null, dataField, null);
        }


        /**
         * Creates a new Node with the specified data and previous/next
         * references.
         * 
         * @param previous
         *            The Node before this Node.
         * @param dataField
         *            The data to be stored in this Node.
         * @param next
         *            The Node after this Node.
         */
        public Node(Node previous, T dataField, Node next) {
            data = dataField;
            this.previous = previous;
            this.next = next;
        }


        // Methods
        /**
         * Gets the data stored in this Node.
         * 
         * @return this Node's data
         */
        public T getData() {
            return data;
        }


        /**
         * Sets this Node's data to the specified value.
         * 
         * @param newData
         *            The new data of the Node.
         */
        public void setData(T newData) {
            data = newData;
        }


        /**
         * Gets the previous node (node before this node).
         * 
         * @return This node's previous node
         */
        public Node getPrevious() {
            return previous;
        }


        /**
         * Sets this Node's previous node to the specified Node.
         * 
         * @param newPrevious
         *            The new Node before this Node.
         */
        public void setPrevious(Node newPrevious) {
            previous = newPrevious;
        }


        /**
         * Gets the next node (node after this node).
         * 
         * @return This node's next node
         */
        public Node getNext() {
            return next;
        }


        /**
         * Sets this Node's next node to the specified Node.
         * 
         * @param newNext
         *            The new Node after this Node.
         */
        public void setNext(Node newNext) {
            next = newNext;
        }
    }


    // Iterator private class
    /**
     * This represents a forwards-moving iterator in a doubly-linked list.
     * 
     * @author Ali Yeganeh (aliyeg)
     * @version 2020.11.18
     * @param <E>
     *            a generic type representing the data type the Iterator
     *            iterates through
     */
    private class ForwardIterator<E> implements Iterator<T> {
        // Fields
        private Node nextNode;

        // Constructor
        /**
         * Creates a new ForwardIterator starting at the first node in the list.
         */
        public ForwardIterator() {
            nextNode = firstNode;
        }


        /**
         * Checks if there are more elements in the list.
         * 
         * @return true if there are more elements in the list, false if not.
         */
        @Override
        public boolean hasNext() {
            return nextNode.getNext() != lastNode;
        }


        /**
         * Gets the next value in the list.
         * 
         * @return The data of the next node in the list.
         * @throws NoSuchElementException
         *             if there are no nodes left in the list.
         */
        @Override
        public T next() {
            // Check if at the end of the list
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            // Move to next space and return data
            nextNode = nextNode.getNext();
            return nextNode.getData();
        }


        /**
         * Removes the last object returned with next() from the list.
         * 
         * @throws IllegalStateException
         *             if next has not been called yet and if the element has
         *             already been removed.
         */
        @Override
        public void remove() {
            // Make sure next has been called
            if (nextNode == firstNode) {
                throw new IllegalStateException(
                    "next() has not been called yet");
            }

            // Remove node from the linked chain
            Node removed = nextNode;
            nextNode = nextNode.getPrevious();
            removed.getNext().setPrevious(removed.getPrevious());
            removed.getPrevious().setNext(removed.getNext());
            size--;
        }
    }

}
