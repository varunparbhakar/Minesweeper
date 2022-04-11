import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineMapTest {

    @Test
    void printMapWithIndicators() {
    }

    @Test
    void insertBomb() {
        MineMap mineMap = new MineMap(2,2);
        mineMap.insertBomb(1,1);
    }

    @Test
    void insertIndicator() {
    }

    @Test
    void indicatorSetter() {
    }
}