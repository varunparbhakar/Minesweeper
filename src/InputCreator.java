import java.io.File;
import java.util.Arrays;

public class InputCreator {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            mapCreator();
        }
        System.out.println("0 0");
    }
    public static void mapCreator() {
        int max = 250;
        int min = 1;
        int range = max - min + 1;
        int myRows = (int)(Math.random() * range) + min;
        int myColumns = (int)(Math.random() * range) + min;

        double bombRatio = 0.5;
        int totalBombs = (int)((myRows * myColumns) * bombRatio);

//        System.out.println("Rows: " + myRows);
//        System.out.println("Columns: " + myColumns);
//        System.out.println("Map Size: " + (myRows * myColumns));
//        System.out.println("Bombs: " + totalBombs);

        char[][] myMap = new char[myRows][myColumns];
        System.out.println(myRows + " " + myColumns);

        while (totalBombs > 0) {
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


        for (char[] row: myMap) {
            for (char character : row)  {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}
