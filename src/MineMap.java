import java.awt.*;
import java.util.Arrays;
/**
 * Minemap class for the Minesweeper program. This class is an object class
 * for a minemap.
 * @author Varun Parbhakar
 * @version 04/10/2022
 */
public class MineMap {
    private Object[][] myMineMap; //Stores the map.
    private int myTotalBombs; //Stores the total number of Bombs on the map.
    private Point[] myBombLocation; //Stores the location of the bomb.

    //Dimension of the map.
    private int myRow; //Total number of rows of the map
    private int myColumn; //Total number of columns of the map

    /**
     * This method only returns the number of bombs placed.
     * @return
     */
    public int getMyTotalBombs(){
        return myTotalBombs;
    }

    /**
     * This method only returns the mine map as a 2-dimensional array.
     * @return
     */
    public Object[][] getMyMineMap(){
        return myMineMap;
    }

    /**
     * This method only returns the bomb locations in a point array.
     * @return
     */
    public Point[] getMyBombLocation(){
        return myBombLocation;
    }


    /**
     * Constructor for the MineMap.
     * @param theRow
     * @param theColumn
     */
    public MineMap(final int theRow, final int theColumn) {
        myRow = theRow;
        myColumn = theColumn;
        myTotalBombs = 0;
        myMineMap = new Object[theRow][theColumn];
        myBombLocation = new Point[10];
    }

    /**
     * Printing a map with the indicators (indicating the total number of bombs at that times).
     */
    String printMapWithIndicators() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < myRow; i++) {
            for (int j = 0; j < myColumn; j++) {
                if(myMineMap[i][j].getClass() == Indicator.class) {
                    Indicator myIndicator = getIndicator(i, j);
                    result.append(myIndicator.getMyAdjacentBombs());
                } else {
                    result.append(myMineMap[i][j].toString());
                }
            }
            result.append("\n");
        }

        return result.toString();

    }
    /**
     * This method inserts a bombs in a specific location.
     * @param theRow
     * @param theColumn
     */
    void insertBomb(final int theRow, final int theColumn) {
        if(myBombLocation.length == myTotalBombs) {
            myBombLocation = Arrays.copyOf(myBombLocation, myTotalBombs * 2);
        }
        myBombLocation[myTotalBombs] = new Point(theRow, theColumn);
        myMineMap[theRow][theColumn] = new Bomb();
        myTotalBombs++;
    }

    /**
     * This method inserts an indicator in a specific location.
     * @param theRow
     * @param theColumn
     */
    void insertIndicator(final int theRow, final int theColumn) {
        myMineMap[theRow][theColumn] = new Indicator();
    }

    /**
     * This method checks the bombs and updates the indicators accordingly.
     */
    void indicatorSetter() {
        for (int i = 0; i < myTotalBombs; i++) {
            adjacentBombSetter(myBombLocation[i].getLocation());
        }
    }

    /**
     * This method is responsible updating all the indexes in every direction.
     * @param theBombLocation
     */
    private void adjacentBombSetter(final Point theBombLocation) {
        northLocationSet(theBombLocation);
        northWestLocationSet(theBombLocation);
        northEastLocationSet(theBombLocation);
        southLocationSet(theBombLocation);
        southEastLocationSet(theBombLocation);
        southWestLocationSet(theBombLocation);
        eastLocationSet(theBombLocation);
        westLocationSet(theBombLocation);
    }

    /**
     * This method alerts the indicator to the North of the given bomb.
     * @param theBombLocation
     */
    void northLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getX()-1 >= 0) {
            Indicator myIndicator = getIndicator(theBombLocation.x-1, theBombLocation.y);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }

    /**
     * This method alerts the indicator to the NorthWest of the given bomb.
     * @param theBombLocation
     */
    void northWestLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getX()-1 >= 0 && theBombLocation.getY()+1 < myColumn) {
            Indicator myIndicator = getIndicator(theBombLocation.x - 1, theBombLocation.y + 1);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }
    /**
     * This method alerts the indicator to the NorthEast of the given bomb.
     * @param theBombLocation
     */
    void northEastLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getX()-1 >= 0 && theBombLocation.getY()-1 >= 0) {
            Indicator myIndicator = getIndicator(theBombLocation.x - 1, theBombLocation.y - 1);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }
    /**
     * This method alerts the indicator to the SouthWest of the given bomb.
     * @param theBombLocation
     */
    void southWestLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getX()+1 < myRow && theBombLocation.getY()+1 < myColumn) {
            Indicator myIndicator = getIndicator(theBombLocation.x + 1, theBombLocation.y + 1);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }
    /**
     * This method alerts the indicator to the SouthEast of the given bomb.
     * @param theBombLocation
     */
    void southEastLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getX()+1 < myRow && theBombLocation.getY()-1 >= 0) {
            Indicator myIndicator = getIndicator(theBombLocation.x + 1, theBombLocation.y - 1);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }

    /**
     * This method alerts the indicator to the West of the given bomb.
     * @param theBombLocation
     */
    void westLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getY()+1 < myColumn) {
            Indicator myIndicator = getIndicator(theBombLocation.x, theBombLocation.y + 1);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }
    /**
     * This method alerts the indicator to the South of the given bomb.
     * @param theBombLocation
     */
    void southLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getX()+1 < myRow) {
            Indicator myIndicator = getIndicator(theBombLocation.x + 1, theBombLocation.y);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }
    /**
     * This method alerts the indicator to the East of the given bomb.
     * @param theBombLocation
     */
    void eastLocationSet(final Point theBombLocation) {
        //Checking if location is out of bounds
        if (theBombLocation.getY()-1 >= 0) {
            Indicator myIndicator = getIndicator(theBombLocation.x, theBombLocation.y-1);

            // There is a bomb at that location
            if(myIndicator != null) {
                myIndicator.bombNearBy();
            }

        }
    }


    /**
     * This method only returns the indicator from the map.
     * @param theRow
     * @param theColumn
     * @return
     */
    private Indicator getIndicator(final int theRow, final int theColumn) {
        if(myMineMap[theRow][theColumn].getClass() == Indicator.class) {
            return (Indicator)myMineMap[theRow][theColumn];
        } else {
            return null;
        }
    }
}

//END