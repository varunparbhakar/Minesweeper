import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndicatorTest {

    @org.junit.jupiter.api.Test
    void bombNearBy() {
        Indicator indicator = new Indicator();
        assertEquals(0,indicator.getMyAdjacentBombs());
        indicator.bombNearBy();
        assertEquals(1,indicator.getMyAdjacentBombs());
    }

    @org.junit.jupiter.api.Test
    void getMyAdjacentBombs() {
        Indicator indicator = new Indicator();
        indicator.bombNearBy();
        indicator.bombNearBy();
        assertEquals(2,indicator.getMyAdjacentBombs());
    }
    @org.junit.jupiter.api.Test
    void getMyAdjacentBombsBefore() {
        Indicator indicator = new Indicator();
        assertEquals(0,indicator.getMyAdjacentBombs());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Indicator indicator = new Indicator();
        assertEquals(".",indicator.toString());
    }
}