import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Main class for the Minesweeper program.
 * @author Varun Parbhakar
 * @version 04/10/2022
 */
public class Main {
    /**
     * This method prints different maps as separate fields.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File myFile = new File("team_minesweeper_input.txt");
        Scanner fileScanner = new Scanner(myFile);
        int counter = 1;

        while (fileScanner.hasNext()) {
            String currentLine = fileScanner.nextLine();
            String[] size = currentLine.split(" ");
            int row = Integer.parseInt(size[0]);
            int column = Integer.parseInt(size[1]);
            //Checking if we have reached the end of the input file.
            if(row == 0 && column == 0) {
                break;
            }
            System.out.println("Field #" + counter + ":");
            MineMap myMap = mapBuilder( row, column, fileScanner);
            myMap.indicatorSetter();
            myMap.printMapWithIndicators();
            System.out.println();
            counter++;
        }



    }


    /**
     * This method builds the map from the user input.
     * @param theRow
     * @param theColumn
     * @param theScanner
     * @return
     */
    public static MineMap mapBuilder(final int theRow, final int theColumn, final Scanner theScanner) {
        MineMap myMap = new MineMap(theRow, theColumn);

        int currentRow = 0;

        while (currentRow  < theRow) {
            String currentLine = theScanner.nextLine();

            for (int i = 0; i < theColumn; i++) {
                if (currentLine.charAt(i) == '*') {
                    myMap.insertBomb(currentRow, i);

                } else {
                    myMap.insertIndicator(currentRow, i);
                }

            }
            currentRow++;
        }

        return myMap;
    }
}
//END