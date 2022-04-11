/**
 * Indicator class that handles the Indicator object.
 * @author Varun Parbhakar
 * @version 04/10/2022
 */
public class Indicator {

    private int myAdjacentBombs; // Keeps track of neighboring bombs.

    /**
     * Constructor for Indicator Object.
     */
    public Indicator() {
        myAdjacentBombs = 0;
    }

    /**
     * Updates the myAdjacentBombs counter.
     */
    protected void bombNearBy() {
        myAdjacentBombs++;
    }

    /**
     * Returns the total number of bomb nearby.
     * @return
     */
    public int getMyAdjacentBombs() {
        return myAdjacentBombs;
    }

    /**
     * To string method for Indicator.
     * @return
     */
    @Override
    public String toString() {
        return ".";
    }
}
//END
