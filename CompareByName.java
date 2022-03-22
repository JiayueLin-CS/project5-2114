// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import java.util.Comparator;

/**
 * This class serves as a comparator for the names of two Race objects.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.02
 */
public class CompareByName implements Comparator<Race> {
    // Methods
    /**
     * Compares the two Race objects based on their names.
     * 
     * @param first
     *            The first Race to be compared by name.
     * @param second
     *            The second Race to be compared by name.
     * @return A negative integer if first is less than second, 0 if they are
     *         equal, and positive if first is greater than second.
     */
    @Override
    public int compare(Race first, Race second) {
        return first.getRace().compareTo(second.getRace());
    }
}
