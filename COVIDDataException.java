package prj5;

/**
 * This exception is thrown if the data is incorrect in the input file.
 * 
 * @author Ali Yeganeh (aliyeg)
 * @version 2020.11.18
 */
@SuppressWarnings("serial")
public class COVIDDataException extends Exception {
    // Constructor
    /**
     * Creates a new COVIDDataException with the specified message.
     * 
     * @param message
     *            The message to be thrown with the exception
     */
    public COVIDDataException(String message) {
        super(message);
    }
}
