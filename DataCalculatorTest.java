// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import student.TestCase;

/**
 * Tests the InputCalculator class to confirm its functionality.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.01
 */
public class DataCalculatorTest extends TestCase {
    // Fields
    private DataCalculator calc;
    private State[] states;
    private Race white;
    private Race asian;
    private Race other;
    private State va;

    // Constructor
    /**
     * Creates a new InputCalculatorTest.
     */
    public DataCalculatorTest() {
        // constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called before each test method.
     */
    public void setUp() {
        // Create races and add them to a linked list
        white = new Race("white", 200, 100);
        asian = new Race("asian", 300, 100);
        other = new Race("other", 400, 100);
        LinkedList<Race> races = new LinkedList<Race>();
        races.add(other);
        races.add(asian);
        races.add(white);

        // Initialize states
        va = new State("va", races);
        State dc = new State("dc", races);
        State md = new State("md", races);
        State ga = new State("ga", races);
        State tn = new State("tn", races);
        State nc = new State("nc", races);

        // Initialize and populate states array
        states = new State[6];
        states[0] = va;
        states[1] = dc;
        states[2] = md;
        states[3] = ga;
        states[4] = tn;
        states[5] = nc;

        // Initialize InputCalculator to use for testing
        calc = new DataCalculator(states);
    }


    /**
     * Makes sure an Exception is thrown when trying to instantiate an
     * InputCalculator with a null parameter.
     */
    public void testDataCalculator() {
        State[] nullStates = null;
        Exception thrown = null;
        try {
            new DataCalculator(nullStates);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests the getStates method to make sure it returns the State array field.
     */
    public void testGetStates() {
        assertEquals(6, DataCalculator.getStates().length);
        assertEquals(states[0], DataCalculator.getStates()[0]);
        assertEquals(states[1], DataCalculator.getStates()[1]);
    }


    /**
     * Tests the getRaceForState method to make sure it returns the correct race
     * for each state based on the parameters.
     */
    public void testGetRaceForState() {
        // The raceName given is not found
        assertNull(calc.getRaceForState(0, "latinx"));

        // The raceName given is found
        assertEquals(other, calc.getRaceForState(0, "other"));
    }


    /**
     * Tests the stateByNumber method to make sure it returns the proper state
     * for a valid index.
     */
    public void testStateByNumber() {
        // Index is less than 0
        assertNull(calc.stateByNumber(-1));

        // Index is greater than or equal to NUM_STATES
        assertNull(calc.stateByNumber(DataCalculator.NUM_STATES));

        // Index is >= 0 and < NUM_STATES
        assertEquals(va, calc.stateByNumber(0));
    }


    /**
     * Tests the getStateIndex method to make sure it returns the proper index
     * of the state in the array.
     */
    public void testGetStateIndex() {
        // No match for the provided String state name
        assertEquals(-1, calc.getStateIndex("ny"));

        // String state name matches a State in the array
        assertEquals(1, calc.getStateIndex("dc"));
    }


    /**
     * Tests the sortStateByAlpha method to make sure it properly sorts the
     * state's linked list of races in alphabetical order.
     */
    public void testSortStateByAlpha() {
        calc.sortStateByAlpha(va);
        Race first = DataCalculator.getStates()[0].getRaces().getEntry(0);
        Race second = DataCalculator.getStates()[1].getRaces().getEntry(1);
        Race third = DataCalculator.getStates()[2].getRaces().getEntry(2);
        assertEquals(asian, first);
        assertEquals(other, second);
        assertEquals(white, third);
    }


    /**
     * Tests the sortStateByCFR method to make sure it properly sorts the
     * state's linked list of races in order of descending CFR.
     */
    public void testSortStateByCFR() {
        calc.sortStateByCFR(va);
        Race first = DataCalculator.getStates()[0].getRaces().getEntry(0);
        Race second = DataCalculator.getStates()[0].getRaces().getEntry(1);
        Race third = DataCalculator.getStates()[0].getRaces().getEntry(2);
        assertEquals(white, first);
        assertEquals(asian, second);
        assertEquals(other, third);
    }
}
