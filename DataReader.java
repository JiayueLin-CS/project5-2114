// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class reads the input and store the data.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.20
 */
public class DataReader {
    // Fields
    private State[] states;

    // Constructor
    /**
     * Creates a new InputReader to read the specified file.
     * 
     * @param fileName
     *            the name of the file to read.
     * @throws FileNotFoundException
     *             if the file name is not found in the repository.
     */
    public DataReader(String fileName) throws FileNotFoundException {
        // Initialize states array
        states = new State[DataCalculator.NUM_STATES];

        // Populate states array
        states = readStateFile(fileName);

        // Instantiate a new GUIWindow with this states array as its parameter.
        new GUIWindow(new DataCalculator(states));
    }


    // Methods
    /**
     * Reads the specified file and returns the states inside the file.
     * 
     * @param fileName
     *            The name of the file to read.
     * @return An array of State objects from the file.
     * @throws FileNotFoundException
     *             if the fileName is not found in the root directory.
     */
    private State[] readStateFile(String fileName)
        throws FileNotFoundException {
        State[] sixStates = new State[DataCalculator.NUM_STATES];
        Scanner file = new Scanner(new File(fileName));
        file.nextLine(); // skip headers

        // loop through the next 6 lines of the file and convert information
        for (int i = 0; i < 6; i++) {
            // Parse the line of text
            String[] stateData = file.nextLine().split(",");

            // Check for NA values
            for (int j = 0; j < stateData.length; j++) {
                if (stateData[j].equals("NA")) {
                    stateData[j] = String.valueOf(-1);
                }
            }

            // Create Race objects for the state, add to a linked list
            Race white = new Race("white", Integer.parseInt(stateData[1]),
                Integer.parseInt(stateData[6]));
            Race black = new Race("black", Integer.parseInt(stateData[2]),
                Integer.parseInt(stateData[7]));
            Race latinx = new Race("latinx", Integer.parseInt(stateData[3]),
                Integer.parseInt(stateData[8]));
            Race asian = new Race("asian", Integer.parseInt(stateData[4]),
                Integer.parseInt(stateData[9]));
            Race other = new Race("other", Integer.parseInt(stateData[5]),
                Integer.parseInt(stateData[10]));
            LinkedList<Race> races = new LinkedList<Race>();
            races.add(asian);
            races.add(black);
            races.add(latinx);
            races.add(other);
            races.add(white);

            // Create State
            sixStates[i] = new State(stateData[0], races);
        }
        return sixStates;
    }

    /**
     * Gets the array of State objects read from the file (if the file was
     * valid).
     */
    public State[] getStates() {
        return states;
    }
}
