// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import student.TestCase;

/**
 * Tests the State class and its methods to confirm its functionality.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.19
 */
public class StateTest extends TestCase {
    // Fields
    private State virginia;
    private LinkedList<Race> listOfRaces;

    // Constructor
    /**
     * Creates a new StateTest.
     */
    public StateTest() {
        // Constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called at the start of each test method.
     */
    public void setUp() {
        // Initialize fields
        listOfRaces = new LinkedList<Race>();
        Race white = new Race("white", 200, 100);
        Race asian = new Race("asian", 300, 100);
        Race black = new Race("black", 250, 100);
        listOfRaces.add(white);
        listOfRaces.add(asian);
        listOfRaces.add(black);
        virginia = new State("Virginia", listOfRaces);
    }


    /**
     * Tests the getName method to make sure it returns the name of the state.
     */
    public void testGetName() {
        assertEquals("Virginia", virginia.getName());
    }


    /**
     * Tests the getRaces method to make sure it returns the list of races with
     * COVID cases.
     */
    public void testGetRaces() {
        assertEquals(listOfRaces, virginia.getRaces());
    }
}
