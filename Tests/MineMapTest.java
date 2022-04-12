import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MineMapTest {


    @Test
    void insertBomb() {
        MineMap testInsertMap = new MineMap(1, 5);
        testInsertMap.insertBomb(0,0);
        testInsertMap.insertIndicator(0,1);
        testInsertMap.insertIndicator(0,2);
        testInsertMap.insertBomb(0,3);
        testInsertMap.insertBomb(0,4);

        testInsertMap.indicatorSetter();
        testInsertMap.printMapWithIndicators();

        Assert.assertEquals(testInsertMap.getMyTotalBombs(), 3);

        Point[] bombPoints = testInsertMap.getMyBombLocation();
        Assert.assertEquals(bombPoints[0], new Point(0,0));
        Assert.assertEquals(bombPoints[1], new Point(0,3));
        Assert.assertEquals(bombPoints[2], new Point(0,4));

        Object[][] mineMap = testInsertMap.getMyMineMap();
        Assert.assertEquals(mineMap[0][0], new Bomb());
        Assert.assertEquals(mineMap[0][3], new Bomb());
        Assert.assertEquals(mineMap[0][4], new Bomb());
    }

    @Test
    void printMapWithIndicators() {
        MineMap testInsertMap = new MineMap(1, 5);
        testInsertMap.insertBomb(0,0);
        testInsertMap.insertIndicator(0,1);
        testInsertMap.insertIndicator(0,2);
        testInsertMap.insertIndicator(0,3);
        testInsertMap.insertIndicator(0,4);

        testInsertMap.indicatorSetter();

//        Assert.assertEquals(testInsertMap.printMapWithIndicators(), "*1000");
    }

    @Test
    void insertIndicator() {
    }

    @Test
    void indicatorSetter() {
    }
}