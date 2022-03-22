// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import student.TestCase;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Tests the LinkedList class to confirm its functionality.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.18
 */
public class LinkedListTest extends TestCase {
    // Fields
    private LinkedList<String> list;
    private Iterator<String> forward;

    // Constructor
    /**
     * Creates a new LinkedListTest
     */
    public LinkedListTest() {
        // Constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called before each test method.
     */
    public void setUp() {
        list = new LinkedList<String>();
        forward = list.forwardIterator();

    }


    // List method tests:
    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Test the replace method.
     */
    public void testReplace() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(list.replace(2, "D"), "C");
        assertEquals(list.getLength(), 3);

        // index < 0
        Exception thrownLess = null;
        try {
            list.replace(-1, "D");
        }
        catch (Exception exception) {
            thrownLess = exception;
        }
        assertNotNull(thrownLess);
        assertTrue(thrownLess instanceof IndexOutOfBoundsException);

        // index > size
        Exception thrownMore = null;
        try {
            list.replace(500, "D");
        }
        catch (Exception e) {
            thrownMore = e;
        }
        assertNotNull(thrownMore);
        assertTrue(thrownMore instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the remove method.
     */
    public void testRemove() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.remove(0);
        assertEquals(list.getLength(), 4);
        assertEquals(list.getEntry(0), "B");
        list.remove(3);
        assertEquals(list.getLength(), 3);
        assertEquals(list.getEntry(2), "D");

        list.clear();
        Exception exception = null;
        try {
            list.remove(1);
        }
        catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);

    }


    /**
     * Test the replace method.
     */
    public void testReplaceTwo() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        assertEquals(list.replace(0, "a"), "A");
        assertEquals(list.getLength(), 5);
        assertEquals(list.getEntry(0), "a");

        assertEquals(list.replace(1, "b"), "B");
        assertEquals(list.getLength(), 5);
        assertEquals(list.getEntry(1), "b");

        assertEquals(list.replace(2, "c"), "C");
        assertEquals(list.getLength(), 5);
        assertEquals(list.getEntry(2), "c");

        assertEquals(list.replace(4, "e"), "E");
        assertEquals(list.getLength(), 5);
        assertEquals(list.getEntry(4), "e");

    }


    /**
     * Test the replace method if it throws an exception.
     */
    public void testReplaceException() {
        Exception exception = null;
        try {
            list.replace(10, "A");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {
        Object[] oriArray = { "A", "B", "C" };
        assertFalse(Arrays.equals(list.toArray(), oriArray));
        Object[] oneItemArray = { "D" };
        list.add("D");
        assertFalse(Arrays.equals(list.toArray(), oneItemArray));
    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(list.toArray(), emptyArray));
    }


    /**
     * Tests the sort method to confirm its functionality.
     */
    public void testSort() {
        CompareByName comparator = new CompareByName();
        LinkedList<Race> races = new LinkedList<Race>();
        Race white = new Race("white", 200, 100);
        Race other = new Race("other", 150, 100);
        Race asian = new Race("asian", 300, 100);
        Race black = new Race("black", 500, 100);
        Race latinx = new Race("latinx", 400, 100);
        races.add(white);

        // sort when list size = 1
        races.sort(comparator);
        assertEquals(1, races.getLength());
        assertEquals(white, races.getEntry(0));

        // when size > 1
        races.add(other);
        races.add(asian);
        races.add(black);
        races.add(latinx);
        races.sort(comparator);
        assertEquals(5, races.getLength());
        assertEquals(asian, races.getEntry(0));
        assertEquals(black, races.getEntry(1));
        assertEquals(latinx, races.getEntry(2));
        assertEquals(other, races.getEntry(3));
        assertEquals(white, races.getEntry(4));
    }


    // Iterator tests:
    /**
     * Tests the ForwardIterator class and its methods to confirm its
     * functionality.
     */
    public void testForwardIterator() {
        // hasNext() when there is no next entry
        assertFalse(forward.hasNext());

        // hasNext() when there is a next entry
        list.add("one");
        assertTrue(forward.hasNext());

        // remove() before calling next()
        Exception thrownInRemove = null;
        try {
            forward.remove();
        }
        catch (Exception illegalStateException) {
            thrownInRemove = illegalStateException;
        }
        assertNotNull(thrownInRemove);
        assertTrue("next() has not been called yet",
            thrownInRemove instanceof IllegalStateException);

        // next() when there is a next entry
        assertEquals("one", forward.next());

        // next() when there is not a next entry
        Exception thrownInNext = null;
        try {
            forward.next();
        }
        catch (Exception noSuchElementException) {
            thrownInNext = noSuchElementException;
        }
        assertNotNull(thrownInNext);
        assertTrue(thrownInNext instanceof NoSuchElementException);

        // remove() after calling next()
        forward.remove();
        assertFalse(list.contains("one"));
    }

}
