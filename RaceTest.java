// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import student.TestCase;

/**
 * Tests the Race class to confirm its functionality.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.18
 */
public class RaceTest extends TestCase {
    // Fields
    private Race white;

    // Constructor
    /**
     * Creates a new RaceTest.
     */
    public RaceTest() {
        // Constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called before each test method.
     */
    public void setUp() {
        // Initialize fields
        white = new Race("White", 300, 100);
    }


    /**
     * Tests the Race constructor when cases/deaths is -1.
     */
    public void testRace() {
        // cases is -1
        Race cases = new Race("a", -1, 0);
        assertEquals(-1, cases.getCFR(), 0.0);

        // deaths is -1
        Race deaths = new Race("a", 1, -1);
        assertEquals(-1, deaths.getCFR(), 0.0);
    }


    /**
     * Tests the getRace method to make sure it returns the name of the Race.
     */
    public void testGetRace() {
        assertEquals("White", white.getRace());
    }


    /**
     * Tests the getCases method to make sure it returns the number of COVID
     * cases for the Race.
     */
    public void testGetCases() {
        assertEquals(300, white.getCases(), 0.0);
    }


    /**
     * Tests the getDeaths method to make sure it returns the number of COVID
     * deaths for the Race.
     */
    public void testGetDeaths() {
        assertEquals(100, white.getDeaths(), 0.0);
    }


    /**
     * Tests the getCFR method to make sure it returns the case-fatality ratio
     * for the Race as a percentage rounded to the nearest tenth.
     */
    public void testGetCFR() {
        assertEquals(33.3, white.getCFR(), 0.0);
    }


    /**
     * Tests the toString method to make sure it returns the proper formatted
     * String representation of the Race's data.
     */
    public void testToString() {
        assertEquals("White: 300 cases, 33.3% CFR", white.toString());

        // when CFR is -1:
        Race negativeOne = new Race("negative", 1, -1);
        assertEquals("negative: 1 cases, -1% CFR", negativeOne.toString());
    }


    /**
     * Tests the equals method to make sure it returns the proper boolean value
     * when the other is/is not equal.
     */
    public void testEquals() {
        // obj is null
        Race nullRace = null;
        assertFalse(white.equals(nullRace));

        // obj is this
        assertTrue(white.equals(white));

        // obj has a different class
        Object object = new Object();
        assertFalse(white.equals(object));

        // obj has the same name/cases/deaths
        Race sameRace = new Race("White", 300, 100);
        assertTrue(white.equals(sameRace));

        // obj has the same name/cases, different deaths
        Race differentDeaths = new Race("White", 300, 300);
        assertFalse(white.equals(differentDeaths));

        // obj has the same name/deaths, different cases
        Race differentCases = new Race("White", 600, 100);
        assertFalse(white.equals(differentCases));

        // obj has the same cases/deaths, different name
        Race differentName = new Race("Asian", 300, 100);
        assertFalse(white.equals(differentName));
    }
}
