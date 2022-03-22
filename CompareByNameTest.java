// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import student.TestCase;

/**
 * Tests the CompareByName class to confirm its functionality.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.02
 */
public class CompareByNameTest extends TestCase {
    // Fields
    private CompareByName comparator;

    // Constructor
    /**
     * Creates a new CompareByNameTest.
     */
    public CompareByNameTest() {
        // Constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called before each test method.
     */
    public void setUp() {
        // Initialize field
        comparator = new CompareByName();
    }


    /**
     * Tests the compare method to confirm its functionality with various
     * scenarios.
     */
    public void testCompare() {
        // Create Race objects for testing
        Race white = new Race("white", 1, 1);
        Race same = new Race("white", 1, 1);
        Race less = new Race("a", 1, 1);
        Race greater = new Race("z", 1, 1);

        // first is greater
        assertTrue(comparator.compare(white, less) > 0);

        // first is less
        assertTrue(comparator.compare(white, greater) < 0);

        // equal
        assertEquals(0, comparator.compare(white, same));
    }
}
