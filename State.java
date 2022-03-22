// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

/**
 * This class represents a US State being affected by COVID-19, containing data
 * fields for the COVID cases/deaths/CFR by race.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.19
 */
public class State {
    // Fields
    private String name;
    private LinkedList<Race> races;

    // Constructor
    /**
     * Creates a new State object with the specified name and races with data.
     * 
     * @param nameOfState
     *            The name of the state.
     * @param racesWithData
     *            A LinkedList of Race objects containing COVID data for each
     *            race in that state.
     */
    public State(String nameOfState, LinkedList<Race> racesWithData) {
        // Initialize fields
        name = nameOfState;
        races = racesWithData;
    }


    // Methods
    /**
     * Gets the name of the State.
     * 
     * @return a String representing the State's name.
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the races (and their individual data) of the State.
     * 
     * @return a LinkedList of Race objects containing each Race's COVID data.
     */
    public LinkedList<Race> getRaces() {
        return races;
    }
}
