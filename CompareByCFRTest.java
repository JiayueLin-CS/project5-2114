// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import student.TestCase;

/**
 * Tests the CompareByCFR class to confirm its functionality.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.02
 */
public class CompareByCFRTest extends TestCase {
    // Fields
    private CompareByCFR comparator;

    // Constructor
    /**
     * Creates a new CompareByCFRTest.
     */
    public CompareByCFRTest() {
        // Constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called before each test method.
     */
    public void setUp() {
        // Initialize field
        comparator = new CompareByCFR();
    }


    /**
     * Tests the compare method to confirm its functionality with various
     * scenarios.
     */
    public void testCompare() {
        // Create Race objects for testing
        Race white = new Race("white", 300, 100);
        Race asian = new Race("asian", 200, 100);
        Race other = new Race("other", 300, 100);

        // Same CFR, greater name
        assertTrue(comparator.compare(white, other) > 0);

        // Same CFR, lower name
        assertTrue(comparator.compare(other, white) < 0);

        // Same CFR, same name
        assertEquals(0, comparator.compare(white, white));

        // Greater CFR
        assertTrue(comparator.compare(asian, white) < 0);

        // Lower CFR
        assertTrue(comparator.compare(white, asian) > 0);
    }
}
