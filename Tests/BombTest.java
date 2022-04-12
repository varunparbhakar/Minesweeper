
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BombTest {
    /**
     * tests if the bomb object is the correct class
     */
    @Test
    void testBombConstructor(){
        Bomb bomb = new Bomb();
        assertEquals(Bomb.class, bomb.getClass());
    }

    /**
     * checks to see if the ToString method outputs the string * when called
     */
    @Test
    void testToString() {
        Bomb bomb = new Bomb();
        assertEquals("*", bomb.toString());
    }
}