// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import java.io.FileNotFoundException;

/**
 * This class executes the program, printing the data.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.21
 */
public class Input {

    /**
     * Creates a new InputReader to read the file and print the correct data
     * output.
     * 
     * @param args
     *            A String[] array that can represent the filename to read.
     * @throws FileNotFoundException
     *             if the file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) {
            new InputReader(args[0]);
        }
    }
}
