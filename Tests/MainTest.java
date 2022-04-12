import org.junit.jupiter.api.Test;

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
        @Test
        void main() throws FileNotFoundException {
            File File1 = new File("output.txt");
            File File2 = new File("output1.txt");
            //assertEquals("The files differ!" ,FileUtils.read, Files.toString("output.txt", Charset.forName("UTF-8")));
        }

        @Test
        void driver() {
        }

        @Test
        void mapBuilder() {
        }

    }