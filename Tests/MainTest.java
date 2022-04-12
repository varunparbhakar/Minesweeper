import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

        /**
         * please use file redirection for this method
         * redirection should be input.txt to output.txt
         * output1.txt is the solution text file.
         * this tests whether the output of the main is correct using file redirection.
         * it is unable to take from console so has to check via file redirection
         * @throws FileNotFoundException
         */
        @Test
        void main() throws IOException {
            Path path1 = Paths.get("src/output.txt");
            Path path2 = Paths.get("src/output1.txt");
            byte[] f1 = Files.readAllBytes(path1);
            byte[] f2 = Files.readAllBytes(path2);
            assertArrayEquals(f1,f2);
        }

    /**
     * verifies correct row/ column
     * but the only working part in this method is the
     * creation of rows and columns of mineMap array
     */
        @Test
        void mapBuilder() throws FileNotFoundException {
            File myFile = new File("input.txt");
            Scanner fileScanner = new Scanner(myFile);
            MineMap mineMap = Main.mapBuilder(4,4,fileScanner);
            mineMap.printMapWithIndicators();

            assertEquals(4,mineMap.getMyMineMap().length);
            assertEquals(4,mineMap.getMyMineMap()[0].length);
        }

    }