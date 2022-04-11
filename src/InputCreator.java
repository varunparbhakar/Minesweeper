import java.io.File;
import java.util.Arrays;
/**
 * Input creating class that creates random minefields for testing purposes.
 * @author Varun Parbhakar
 * @version 04/10/2022
 */
public class InputCreator {
    /**
     * Main method that drives the class.
     * @param args
     */
    public static void main(String[] args) {
        int totalNumberOfInputs = 10;
        for (int i = 0; i < totalNumberOfInputs; i++) {
            mapCreator();
        }
        System.out.println("0 0");
    }

    /**
     * Creates the map within the specified range.
     */
    public static void mapCreator() {
        int max = 250;
        int min = 1;

        int range = max - min + 1;
        int myRows = (int)(Math.random() * range) + min;
        int myColumns = (int)(Math.random() * range) + min;

        double bombRatio = 0.5; // Bomb spawn ratio.
        int totalBombs = (int)((myRows * myColumns) * bombRatio);

        char[][] myMap = new char[myRows][myColumns];
        System.out.println(myRows + " " + myColumns);

        // Keep populating the map until all the bombs have been dispersed.
        while (totalBombs > 0) {

            //Populating the map
            for (int i = 0; i < myRows; i++) {
                for (int j = 0; j < myColumns; j++) {
                    if(Math.random() < bombRatio) {
                        myMap[i][j] = '*';
                        totalBombs--;
                    } else {
                        myMap[i][j] = '.';
                    }
                }
            }
        }


        //Printing the map
        for (char[] row: myMap) {
            for (char character : row)  {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}
//END