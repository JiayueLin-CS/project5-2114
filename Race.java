// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import java.text.DecimalFormat;

/**
 * This class represents a race being affected by COVID-19 in a certain state,
 * containing data fields for number of cases, deaths, and case fatality ratio.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.11.18
 */
public class Race {
    // Fields
    private String name;
    private int cases;
    private int deaths;
    private double caseFatalityRatio;

    // Constructor
    /**
     * Creates a new Race object with the specified name and COVID statistics.
     * 
     * @param nameOfRace
     *            The name of the race (white, Asian, etc.)
     * @param numberOfCases
     *            The number of COVID cases the race has.
     * @param numberOfDeaths
     *            The number of COVID deaths the race has.
     */
    public Race(String nameOfRace, int numberOfCases, int numberOfDeaths) {
        // Initialize fields
        name = nameOfRace;
        cases = numberOfCases;
        deaths = numberOfDeaths;

        // CFR = (cases/deaths)*100%, rounded to the nearest tenth
        if (numberOfCases == -1 || numberOfDeaths == -1) {
            caseFatalityRatio = -1;
        }
        else {
            caseFatalityRatio = (double)Math.round((((double)deaths
                / (double)cases) * 100) * 10) / 10;
        }
    }


    // Methods
    /**
     * Gets the name of the race.
     * 
     * @return A String representing the name of the race.
     */
    public String getRace() {
        return name;
    }


    /**
     * Gets the number of COVID cases the race has.
     * 
     * @return An integer representing the number of COVID cases.
     */
    public int getCases() {
        return cases;
    }


    /**
     * Gets the number of COVID deaths the race has.
     * 
     * @return An integer representing the number of COVID deaths.
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Gets the case-fatality ratio of COVID for this race.
     * 
     * @return A double, rounded to the nearest tenth, representing the
     *         percentage of COVID cases resulting in deaths for this race.
     */
    public double getCFR() {
        return caseFatalityRatio;
    }


    /**
     * This method returns a String representation of this Race object's data,
     * in the following format, example:
     * 
     * "white: 1234 cases, 1.2% CFR"
     * 
     * @return A String representation of this Race's data.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Add the name of the Race
        builder.append("");
        builder.append(name);

        // Add the number of cases
        builder.append(": ");
        builder.append(cases);
        builder.append(" cases, ");

        // Add the CFR
        if (caseFatalityRatio == -1) {
            builder.append("-1");
        }
        else {
            DecimalFormat df = new DecimalFormat("0.#");
            String cfr = df.format(caseFatalityRatio);
            builder.append(cfr);
        }
        builder.append("% CFR");

        return builder.toString();
    }


    /**
     * This method returns whether another object is equal to this one. Two
     * Races are equal if they have the same name, cases, and deaths.
     * 
     * @param obj
     *            The object being compared to this Race.
     * @return True if they are equal, false if not.
     */
    public boolean equals(Object obj) {
        // If obj is null, they are not equal
        if (obj == null) {
            return false;
        }

        // If obj is this Race, they are equal
        if (obj == this) {
            return true;
        }

        // If obj has a different class (not Race), they are not equal
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        // If obj has the same name/cases/deaths, they are equal
        Race other = (Race)obj;
        return name == other.getRace() && cases == other.getCases()
            && deaths == other.getDeaths();
    }
}
