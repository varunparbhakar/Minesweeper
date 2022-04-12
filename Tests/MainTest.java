import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

        /**
         * please use file redirection for this method
         * redirection should be input.txt to output.txt
         * @throws FileNotFoundException
         */
        @org.junit.jupiter.api.Test
        void main() throws FileNotFoundException {
            File File1 = new File("output.txt");
            String File2
            assertEquals("The files differ!" ,Files.toString(File1, Charset.forName("UTF-8")), Files.toString("output.txt", Charset.forName("UTF-8")));
        }

        @org.junit.jupiter.api.Test
        void driver() {
        }

        @org.junit.jupiter.api.Test
        void mapBuilder() {
        }

    }