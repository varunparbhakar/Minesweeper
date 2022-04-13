import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This test class tests the Bomb class.
 * @author Austin luu
 * @version 04/12/2022
 */
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