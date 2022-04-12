import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

        /**
         * please use file redirection for this method
         * redirection should be input.txt to output.txt
         * output1.txt is the solution text file
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


        @Test
        void mapBuilder() {
        }

    }