import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Test");
        File myFile = new File("input.txt");
        Scanner fileScanner = new Scanner(myFile);
        int counter = 1;
        while (fileScanner.hasNext()) {
            String currentLine = fileScanner.nextLine();
            String[] size = currentLine.split(" ");
            int row = Integer.parseInt(size[0]);
            int column = Integer.parseInt(size[1]);
            if(row == 0 && column == 0) {
                break;
            }
            System.out.println("Field #" + counter + ":");
            driver(fileScanner, row, column);
            counter++;
        }



    }
    public static void driver(final Scanner theScanner,final int theRow, final int theColumn) {
        MineMap myMap = mapBuilder( theRow, theColumn, theScanner);
        myMap.indicatorSetter();
        myMap.printMapWithIndicators();
        System.out.println();


    }
    public static MineMap mapBuilder(final int theRow, final int theColumn, final Scanner theScanner) {
        MineMap myMap = new MineMap(theRow, theColumn);
        int currentRow = 0;
        while (currentRow  < theRow) {
            String currentLine = theScanner.nextLine();

            for (int i = 0; i < theColumn; i++) {
                if(i > currentLine.length()-1) {
                    System.out.println("The length of current line: " + currentLine.length());
                    currentLine = theScanner.next();
                }
                if (currentLine.charAt(i) == '*') {
                    myMap.insertBomb(currentRow, i);

                } else {
                    myMap.insertIndicator(currentRow, i);
                }

            }

                // This while loop is for the pdf version of the input file
//            while (myMap.getElement(currentRow, theColumn-1) == null) {
//
//                if(index == currentLine.length() && myMap.getElement(currentRow, theColumn-1) == null) {
//                    index = index - currentLine.length();
//                    currentLine = theScanner.nextLine();
//                }
//                if (currentLine.charAt(index) == '*') {
//                    myMap.insertBomb(currentRow, currentColumn);
//
//                } else {
//                    myMap.insertIndicator(currentRow, currentColumn);
//                }
//
//                index++;
//                currentColumn++;
//            }

            currentRow++;
        }

        return myMap;
    }
}
