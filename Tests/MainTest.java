import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    /**
     * please use file redirection for this method
     * @throws FileNotFoundException
     */
    @org.junit.jupiter.api.Test
    void main() throws FileNotFoundException {
    Main main = new Main();
    main.main(new String[]{});
    }

    @org.junit.jupiter.api.Test
    void driver() {
    }

    @org.junit.jupiter.api.Test
    void mapBuilder() {
    }
}