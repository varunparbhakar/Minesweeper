
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class tests the Indicator class.
 * @author Austin luu
 * @version 04/12/2022
 */
class IndicatorTest {
    /**
     * checks to see if the created indicator is the same class as Indicator.
     * the checking of bombs nearby is in the bombNearBy test
     */
    @Test
    void indicator(){
        Indicator indicator = new Indicator();
        assertEquals(Indicator.class, indicator.getClass());
    }
    /**
     * tests if the bombsNearBy method adds another bomb to the myAdjacentBombs field
     */
    @Test
    void bombNearBy() {
        Indicator indicator = new Indicator();
        assertEquals(0,indicator.getMyAdjacentBombs());
        indicator.bombNearBy();
        assertEquals(1,indicator.getMyAdjacentBombs());
    }
    /**
     * tests if the getMyAdjacentBombs method returns the correct
     * amount of bombs after adding bombs
     */
    @Test
    void getMyAdjacentBombs() {
        Indicator indicator = new Indicator();
        indicator.bombNearBy();
        indicator.bombNearBy();
        assertEquals(2,indicator.getMyAdjacentBombs());
    }
    /**
     * tests if the getMyAdjacentBombs method returns the correct
     * amount of bombs before adding bombs
     */
    @Test
    void getMyAdjacentBombsBefore() {
        Indicator indicator = new Indicator();
        assertEquals(0,indicator.getMyAdjacentBombs());
    }

    /**
     * checks to see if the toString method outputs the string . when called
     */
    @Test
    void testToString() {
        Indicator indicator = new Indicator();
        assertEquals(".",indicator.toString());
    }
}