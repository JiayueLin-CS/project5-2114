// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import java.util.Comparator;

/**
 * This class serves as a comparator for the CFR's of two Race objects.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.01
 */
public class CompareByCFR implements Comparator<Race> {
    // Methods
    /**
     * Compares the two Race objects based on their COVID case-fatality ratios
     * (CFR).
     * 
     * @param first
     *            The first Race to be compared by CFR.
     * @param second
     *            The second Race to be compared by CFR.
     * @return A negative integer if first is GREATER than second, 0 if they are
     *         equal, and positive if first is LESS than second.
     */
    @Override
    public int compare(Race first, Race second) {
        double cfrDifference = second.getCFR() - first.getCFR();

        // Tie breaker for when the CFR's are equal
        if (cfrDifference == 0) {
            return first.getRace().compareTo(second.getRace());
        }
        else if (cfrDifference < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
