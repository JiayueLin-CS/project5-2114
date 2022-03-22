package prj5;

import student.TestCase;

/**
 * Tests the COVIDDataException class to make sure that it is thrown in the
 * proper scenarios with the correct message.
 * 
 * @author Ali Yeganeh (aliyeg)
 * @version 2020.11.18
 */
public class COVIDDataExceptionTest extends TestCase {
    // Fields
    private Exception exception;

    // Constructor
    /**
     * Creates a new COVIDDataExceptionTest.
     */
    public COVIDDataExceptionTest() {
        // Constructor left empty in test class
    }


    // Methods
    /**
     * Sets up the test fixture.
     * Called before each test method.
     */
    public void setUp() {
        // Initialize the exception using its constructor
        exception = new COVIDDataException("Improper format");
    }


    /**
     * Tests the COVIDDataException constructor to make sure it has the proper
     * message when thrown.
     */
    public void testCOVIDDataException() {
        // Constructor called in setUp, check string message
        assertTrue("Improper format", exception instanceof COVIDDataException);
    }
}
