import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndicatorTest {

    @Test
    void bombNearBy() {
        Indicator indicator = new Indicator();
        assertEquals(0,indicator.getMyAdjacentBombs());
        indicator.bombNearBy();
        assertEquals(1,indicator.getMyAdjacentBombs());
    }

    @Test
    void getMyAdjacentBombs() {
        Indicator indicator = new Indicator();
        indicator.bombNearBy();
        indicator.bombNearBy();
        assertEquals(2,indicator.getMyAdjacentBombs());
    }
    @Test
    void getMyAdjacentBombsBefore() {
        Indicator indicator = new Indicator();
        assertEquals(0,indicator.getMyAdjacentBombs());
    }

    @Test
    void testToString() {
        Indicator indicator = new Indicator();
        assertEquals(".",indicator.toString());
    }
}