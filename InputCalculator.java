package prj5;

/**
 * 
 * This class does most of the operations to link back-end data to front-end
 * display
 * 
 * @author anikethp
 * @version 2020.11.19
 *
 */
public class InputCalculator {
    public static final int NUM_STATES = 5;

    private static State[] states;
    private static Race[] races;

    /**
     * Creates a new InputCalculator with the specified state name
     * 
     * @param nameOfState
     *            name of the state
     */
    public InputCalculator(State[] nameOfState) {

        states = nameOfState;

    }


    /**
     * gets the state name
     * 
     * @return A state with the name of the state
     */
    public State[] getState() {
        return states;
    }


    /**
     * 
     * @param state
     *            name of the state
     * @param race
     *            group name
     * @return the race of the state
     */
    public LinkedList<Race> getRaceForState(State state, String race) {
        return state.getRaces();
    }


    public State stateByNumber(int index) {
        if (index < InputCalculator.NUM_STATES && index >= 1) {
            return InputCalculator.states[index];
        }

        else {
            return null;
        }
    }


    public int getStateIndex(String string) {

        for (int i = 1; i < InputCalculator.states.length; i++) {
            if (InputCalculator.states[i].getName().contentEquals(string)) {
                return i;
            }
        }

        return 0;

    }


    public Race raceByNumber(int num) {
        if (num < InputCalculator.NUM_STATES && num >= 1) {
            return InputCalculator.races[num];
        }

        else {
            return null;
        }
    }


    public int getRaceIndex(String string) {
        for (int i = 1; i < InputCalculator.races.length; i++) {
            if (InputCalculator.races[i].getRace().contentEquals(string)) {
                return i;
            }
        }

        return 0;
    }


    public void sortByAlpha(State state) {

    }


    public LinkedList<Race> sortByCFR() {
        if (txt.getLength() == 0) {
            throw new IllegalArgumentException("Empty list");
        }

        Race[] raceArray = this.toArray();
        for (int i = 1; i < raceArray.length; i++) {
            for (int j = i; (j > 0) && (raceArray[j].compareTo(raceArray[j - 1]) >= 0); j--) {
                
            }
        }
        
    }

}
