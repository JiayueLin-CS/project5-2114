// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Tests the DataReader class to confirm its functionality in reading files and
 * parsing data.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.05
 */
public class DataReaderTest extends TestCase {
    // Fields
    private DataReader reader;

    // Constructor
    /**
     * Creates a new DataReaderTest.
     */
    public DataReaderTest() {
        // Constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called at the start of each test method.
     */
    public void setUp() {
        // initialize reader with a valid file
        try {
            reader = new DataReader("Cases_and_Deaths_CRDT_NEW.csv");
        }
        catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        }
    }


    /**
     * Tests to make sure a FileNotFoundException is thrown when calling the
     * DataReader constructor with an invalid file name.
     */
    public void testDataReader() {
        Exception thrown = null;
        try {
            new DataReader("this_file_does_not_exist.csv");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof FileNotFoundException);
    }


    /**
     * Tests the readStateFile private method by calling the DataReader
     * constructor with a valid file name (which was done in setUp()). Also
     * tests the getStates method.
     */
    public void testGetStates() {
        State[] states = reader.getStates();
        
        // State names
        assertEquals("DC", states[0].getName());
        assertEquals("GA", states[1].getName());
        assertEquals("MD", states[2].getName());
        assertEquals("NC", states[3].getName());
        assertEquals("TN", states[4].getName());
        assertEquals("VA", states[5].getName());
        
        // Check one of the CFRs when a data point is "NA"
        assertEquals(-1, states[0].getRaces().getEntry(2).getCFR(), 0.0);
        
        // when the data is valid
        assertEquals(3.9, states[0].getRaces().getEntry(0).getCFR(), 0.0);
    }
}
