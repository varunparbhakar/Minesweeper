import java.io.File;

public class InputCreator {
    public static void main(String[] args) {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int myRows = (int)(Math.random() * range) + min;
        int myColumns = (int)(Math.random() * range) + min;

        double bombRatio = 0.5;
        int totalBombs = (int)((myRows * myColumns) * bombRatio);
        System.out.println("Rows: " + myRows);
        System.out.println("Columns: " + myColumns);
        System.out.println("Map Size: " + (myRows * myColumns));
        System.out.println("Bombs: " + totalBombs);



    }
}
