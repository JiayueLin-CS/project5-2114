// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ali Yeganeh (aliyeg), Aniketh Pranay (anikethp), Jiayue Lin (jiayuelin)

package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * This class creates a GUI that has all the functionality listed in
 * the output section.
 * 
 * @author Jiayue Lin (jiayuelin)
 * @author Ali Yeganeh (aliyeg)
 * @author Aniketh Pranay (anikethp)
 * @version 2020.12.04
 */
public class GUIWindow {
    // Fields
    private Window window;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;
    private Button sortByAlpha;
    private Button sortByCFR;
    private Button quit;
    private String stateName;
    private DataCalculator calculator;
    /**
     * The width of each CFR bar shape.
     */
    public static final int BAR_WIDTH = 30;
    /**
     * The multiplication factor for the CFR bar height.
     */
    public static final int BAR_HEIGHT_FACTOR = 12;
    /**
     * The y coordinate of the bottom of the CFR bar.
     */
    public static final int BAR_MAX_Y = 180;
    /**
     * The offset (space between) the TextShapes for percentage and race and the
     * bar.
     */
    public static final int TEXT_OFFSET = 13;

    // Constructor
    /**
     * Creates a new GUIWindow with the specified InputCalculator to help
     * display the data.
     * 
     * @param InputCalculator
     *            the InputCalculator to prepare the data for display.
     */
    public GUIWindow(DataCalculator input) {
        window = new Window();
        window.setTitle("aliyeg jiayuelin anikethp");
        calculator = input;

        // Initialize buttons
        representDC = new Button("Represent DC");
        representDC.onClick(this, "clickedRepresentDC");

        representGA = new Button("Represent GA");
        representGA.onClick(this, "clickedRepresentGA");

        representMD = new Button("Represent MD");
        representMD.onClick(this, "clickedRepresentMD");

        representNC = new Button("Represent NC");
        representNC.onClick(this, "clickedRepresentNC");

        representTN = new Button("Represent TN");
        representTN.onClick(this, "clickedRepresentTN");

        representVA = new Button("Represent VA");
        representVA.onClick(this, "clickedRepresentVA");

        sortByAlpha = new Button("Sort By Alpha");
        sortByAlpha.onClick(this, "clickedSortByAlpha");

        sortByCFR = new Button("Sort By CFR");
        sortByCFR.onClick(this, "clickedSortByCFR");

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        // Add buttons to window
        window.addButton(representDC, WindowSide.SOUTH);
        window.addButton(representGA, WindowSide.SOUTH);
        window.addButton(representMD, WindowSide.SOUTH);
        window.addButton(representNC, WindowSide.SOUTH);
        window.addButton(representTN, WindowSide.SOUTH);
        window.addButton(representVA, WindowSide.SOUTH);
        window.addButton(sortByAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortByCFR, WindowSide.NORTH);

        // Initialize stateName with an empty string (this is a "flag" variable
        // used for the sorting methods)
        stateName = "";
    }


    // Methods
    /**
     * Handles displaying the data for DC when the button is clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedRepresentDC(Button button) {
        stateName = "DC";
        State dc = DataCalculator.getStates()[0];
        LinkedList<Race> races = dc.getRaces();

        // Clear out any previous data from the window
        window.removeAllShapes();

        // State title
        TextShape title = new TextShape((window.getWidth() / 2) - 105, 15,
            "DC Case Fatality Ratios by Race");
        window.addShape(title);

        // Display the text for race name and CFR percentage
        displayRace(races);
        displayPercentage(races);

        // Create the shapes and add them to the window:
        int height = 0;
        int x = 0;

        for (int i = 0; i < races.getLength(); i++) {
            if (races.getEntry(i).getCFR() != -1) {
                height = (int)(races.getEntry(i).getCFR() * BAR_HEIGHT_FACTOR);
                x = ((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6;
                window.addShape(new Shape(x, BAR_MAX_Y - height, BAR_WIDTH,
                    height, Color.BLUE));
            }
        }
    }


    /**
     * Handles displaying the data for GA when the button is clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedRepresentGA(Button button) {
        stateName = "GA";
        State ga = DataCalculator.getStates()[1];
        LinkedList<Race> races = ga.getRaces();

        // Clear out any previous data from the window
        window.removeAllShapes();

        // State title
        TextShape title = new TextShape((window.getWidth() / 2) - 105, 15,
            "GA Case Fatality Ratios by Race");
        window.addShape(title);

        // Display the text for race name and CFR percentage
        displayRace(races);
        displayPercentage(races);

        // Create the shapes and add them to the window:
        int height = 0;
        int x = 0;

        for (int i = 0; i < races.getLength(); i++) {
            if (races.getEntry(i).getCFR() != -1) {
                height = (int)(races.getEntry(i).getCFR() * BAR_HEIGHT_FACTOR);
                x = ((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6;
                window.addShape(new Shape(x, BAR_MAX_Y - height, BAR_WIDTH,
                    height, Color.BLUE));
            }
        }
    }


    /**
     * Handles displaying the data for MD when the button is clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedRepresentMD(Button button) {
        stateName = "MD";
        State md = DataCalculator.getStates()[2];
        LinkedList<Race> races = md.getRaces();

        // Clear out any previous data from the window
        window.removeAllShapes();

        // State title
        TextShape title = new TextShape((window.getWidth() / 2) - 105, 15,
            "MD Case Fatality Ratios by Race");
        window.addShape(title);

        // Display the text for race name and CFR percentage
        displayRace(races);
        displayPercentage(races);

        // Create the shapes and add them to the window:
        int height = 0;
        int x = 0;

        for (int i = 0; i < races.getLength(); i++) {
            if (races.getEntry(i).getCFR() != -1) {
                height = (int)(races.getEntry(i).getCFR() * BAR_HEIGHT_FACTOR);
                x = ((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6;
                window.addShape(new Shape(x, BAR_MAX_Y - height, BAR_WIDTH,
                    height, Color.BLUE));
            }
        }
    }


    /**
     * Handles displaying the data for NC when the button is clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedRepresentNC(Button button) {
        stateName = "NC";
        State nc = DataCalculator.getStates()[3];
        LinkedList<Race> races = nc.getRaces();

        // Clear out any previous data from the window
        window.removeAllShapes();

        // State title
        TextShape title = new TextShape((window.getWidth() / 2) - 105, 15,
            "NC Case Fatality Ratios by Race");
        window.addShape(title);

        // Display the text for race name and CFR percentage
        displayRace(races);
        displayPercentage(races);

        // Create the shapes and add them to the window:
        int height = 0;
        int x = 0;

        for (int i = 0; i < races.getLength(); i++) {
            if (races.getEntry(i).getCFR() != -1) {
                height = (int)(races.getEntry(i).getCFR() * BAR_HEIGHT_FACTOR);
                x = ((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6;
                window.addShape(new Shape(x, BAR_MAX_Y - height, BAR_WIDTH,
                    height, Color.BLUE));
            }
        }
    }


    /**
     * Handles displaying the data for TN when the button is clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedRepresentTN(Button button) {
        stateName = "TN";
        State tn = DataCalculator.getStates()[4];
        LinkedList<Race> races = tn.getRaces();

        // Clear out any previous data from the window
        window.removeAllShapes();

        // State title
        TextShape title = new TextShape((window.getWidth() / 2) - 105, 15,
            "TN Case Fatality Ratios by Race");
        window.addShape(title);

        // Display the text for race name and CFR percentage
        displayRace(races);
        displayPercentage(races);

        // Create the shapes and add them to the window:
        int height = 0;
        int x = 0;

        for (int i = 0; i < races.getLength(); i++) {
            if (races.getEntry(i).getCFR() != -1) {
                height = (int)(races.getEntry(i).getCFR() * BAR_HEIGHT_FACTOR);
                x = ((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6;
                window.addShape(new Shape(x, BAR_MAX_Y - height, BAR_WIDTH,
                    height, Color.BLUE));
            }
        }
    }


    /**
     * Handles displaying the data for VA when the button is clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedRepresentVA(Button button) {
        stateName = "VA";
        State va = DataCalculator.getStates()[5];
        LinkedList<Race> races = va.getRaces();

        // Clear out any previous data from the window
        window.removeAllShapes();

        // State title
        TextShape title = new TextShape((window.getWidth() / 2) - 105, 15,
            "VA Case Fatality Ratios by Race");
        window.addShape(title);

        // Display the text for race name and CFR percentage
        displayRace(races);
        displayPercentage(races);

        // Create the shapes and add them to the window:
        int height = 0;
        int x = 0;

        for (int i = 0; i < races.getLength(); i++) {
            if (races.getEntry(i).getCFR() != -1) {
                height = (int)(races.getEntry(i).getCFR() * BAR_HEIGHT_FACTOR);
                x = ((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6;
                window.addShape(new Shape(x, BAR_MAX_Y - height, BAR_WIDTH,
                    height, Color.BLUE));
            }
        }
    }


    /**
     * Handles sorting the display data by alphabetical order when the button is
     * clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedSortByAlpha(Button button) {
        // Sort each state's race data in alphabetical order
        for (int i = 0; i < DataCalculator.getStates().length; i++) {
            calculator.sortStateByAlpha(DataCalculator.getStates()[i]);
        }

        // Display the proper state's data
        if (stateName.equals("DC")) {
            clickedRepresentDC(representDC);
        }
        else if (stateName.equals("GA")) {
            clickedRepresentGA(representGA);
        }
        else if (stateName.equals("MD")) {
            clickedRepresentMD(representMD);
        }
        else if (stateName.equals("NC")) {
            clickedRepresentNC(representNC);
        }
        else if (stateName.equals("TN")) {
            clickedRepresentTN(representTN);
        }
        else if (stateName.equals("VA")) {
            clickedRepresentVA(representVA);
        }
    }


    /**
     * Handles sorting the display data in order of descending CFR when the
     * button is clicked.
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedSortByCFR(Button button) {
        // Sort each state's race data in descending CFR order
        for (int i = 0; i < DataCalculator.getStates().length; i++) {
            calculator.sortStateByCFR(DataCalculator.getStates()[i]);
        }

        // Display the proper state's data
        if (stateName.equals("DC")) {
            clickedRepresentDC(representDC);
        }
        else if (stateName.equals("GA")) {
            clickedRepresentGA(representGA);
        }
        else if (stateName.equals("MD")) {
            clickedRepresentMD(representMD);
        }
        else if (stateName.equals("NC")) {
            clickedRepresentNC(representNC);
        }
        else if (stateName.equals("TN")) {
            clickedRepresentTN(representTN);
        }
        else if (stateName.equals("VA")) {
            clickedRepresentVA(representVA);
        }
    }


    /**
     * Event handler for when the Quit button is clicked. Exits the program
     * (closing the window).
     * 
     * @param button
     *            The button that was clicked.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Helper method that adds a TextShape for each race to the window.
     * 
     * @param races
     *            A LinkedList of Race objects to be displayed.
     */
    private void displayRace(LinkedList<Race> races) {
        String name = "";
        int x = 0;
        int y = 0;

        // Add text for each race to the window
        for (int i = 0; i < races.getLength(); i++) {
            name = races.getEntry(i).getRace();
            x = (((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6)
                - 5;
            y = BAR_MAX_Y + TEXT_OFFSET;

            TextShape shape = new TextShape(x, y, name, Color.BLACK);
            window.addShape(shape);
        }
    }


    /**
     * Helper method that adds a TextShape for each race's CFR percentage to the
     * window.
     * 
     * @param races
     *            A LinkedList of Race objects to be displayed.
     */
    private void displayPercentage(LinkedList<Race> races) {
        Double cfr = 0.0;
        int x = 0;
        int y = 0;

        // Add CFR for each race to the window
        for (int i = 0; i < races.getLength(); i++) {
            cfr = races.getEntry(i).getCFR();
            x = (((window.getWidth() * (i + 1)) + (BAR_WIDTH * (i - 5))) / 6)
                - 5;
            if (cfr == -1) { // handles case where CFR is N/A
                y = BAR_MAX_Y - 16;
                TextShape shape = new TextShape(x + 5, y, "N/A", Color.BLACK);
                window.addShape(shape);
            }
            else {
                y = BAR_MAX_Y + 16 + (2 * TEXT_OFFSET);
                TextShape shape = new TextShape(x, y, Double.toString(cfr)
                    + "%", Color.BLACK);
                window.addShape(shape);
            }
        }
    }
}
