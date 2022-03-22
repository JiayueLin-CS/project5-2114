// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

/**
 * InputCalculator performs the operations to link the back-end data to the
 * front-end display.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.01
 */
public class DataCalculator {
    // Fields
    /**
     * The number of states with data.
     */
    public static final int NUM_STATES = 6;
    private static State[] states = new State[NUM_STATES];

    // Constructor
    /**
     * Creates a new InputCalculator for the specified states.
     * 
     * @param statesArray
     *            An array of State objects with COVID data.
     */
    public DataCalculator(State[] statesArray) {
        // Check for null states
        if (statesArray == null) {
            throw new IllegalArgumentException();
        }

        // Initialize values of states field
        for (int i = 0; i < NUM_STATES; i++) {
            states[i] = statesArray[i];
        }
    }


    // Methods
    /**
     * Gets the array of states.
     * 
     * @return An array of State objects.
     */
    public static State[] getStates() {
        return states;
    }


    /**
     * Gets the specified Race object (with data) for the State specified.
     * 
     * @param stateIndex
     *            The state to look in.
     * @param raceName
     *            The name of the race.
     * @return The specified Race object for that State.
     */
    public Race getRaceForState(int stateIndex, String raceName) {
        State state = stateByNumber(stateIndex);
        LinkedList<Race> races = state.getRaces();

        // Search for the specified race
        for (int i = 0; i < races.getLength(); i++) {
            if (races.getEntry(i).getRace().equals(raceName)) {
                // if found, return that Race
                return races.getEntry(i);
            }
        }

        // if not found, return null
        return null;
    }


    /**
     * Gets the State object from the states array corresponding to the index
     * provided.
     * 
     * @param index
     *            The index of the State in the array.
     * @return The State object at that index.
     */
    public State stateByNumber(int index) {
        // Check if index is in bounds
        if (index < 0 || index >= NUM_STATES) {
            return null;
        }
        return states[index];
    }


    /**
     * Gets the index of the specified state in the array if it exists.
     * 
     * @param state
     *            The name of the state to find an index for.
     * @return An integer representing the index of the state in the array
     *         (returns -1 if not found).
     */
    public int getStateIndex(String state) {
        // Search for the State with matching name
        for (int i = 0; i < NUM_STATES; i++) {
            if (states[i].getName().equals(state)) {
                // if a match is found, return the state's index
                return i;
            }
        }
        // if no match is found, return -1 (invalid index)
        return -1;
    }


    /**
     * Sorts the races for the specified state by alphabetical order.
     * 
     * @param state
     *            The state whose data is to be sorted.
     */
    public void sortStateByAlpha(State state) {
        state.getRaces().sort(new CompareByName());
    }


    /**
     * Sorts the races for the specified state in order of descending CFR.
     * 
     * @param state
     *            The state whose data is to be sorted.
     */
    public void sortStateByCFR(State state) {
        state.getRaces().sort(new CompareByCFR());
    }
}
