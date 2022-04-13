import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This test class tests the Bomb class.
 * @author Yacine Bennour
 * @version 04/12/2022
 */
class MineMapTest {
    /**
     * Test inserting the bombs throughout the mine map.
     */
    @Test
    void insertBomb() {
        MineMap testInsertMap = new MineMap(1, 5);
        testInsertMap.insertBomb(0,0);
        testInsertMap.insertIndicator(0,1);
        testInsertMap.insertIndicator(0,2);
        testInsertMap.insertBomb(0,3);
        testInsertMap.insertBomb(0,4);

        testInsertMap.indicatorSetter();

        Assert.assertEquals(testInsertMap.getMyTotalBombs(), 3);

        Point[] bombPoints = testInsertMap.getMyBombLocation();
        Assert.assertEquals(bombPoints[0].x, 0);
        Assert.assertEquals(bombPoints[0].y, 0);

        Assert.assertEquals(bombPoints[1].x, 0);
        Assert.assertEquals(bombPoints[1].y, 3);

        Assert.assertEquals(bombPoints[2].x, 0);
        Assert.assertEquals(bombPoints[2].y, 4);


        Object[][] mineMap = testInsertMap.getMyMineMap();
        assertEquals(mineMap[0][0].getClass(), Bomb.class);
        assertEquals(mineMap[0][3].getClass(), Bomb.class);
        assertEquals(mineMap[0][4].getClass(), Bomb.class);
    }


    /**
     * Test inserting the bombs when we overfill the original bomb location array.
     * Expected to double the original array size and also transfer data from old to new array.
     */
    @Test
    void exceedInsertBombLimit() {
        MineMap testInsertMap = new MineMap(1, 12);
        testInsertMap.insertBomb(0,0);
        testInsertMap.insertBomb(0,1);
        testInsertMap.insertBomb(0,2);
        testInsertMap.insertBomb(0,3);
        testInsertMap.insertBomb(0,4);
        testInsertMap.insertBomb(0,5);

        Assert.assertEquals(testInsertMap.getMyTotalBombs(), 6);


        testInsertMap.insertBomb(0,6);
        testInsertMap.insertBomb(0,7);
        testInsertMap.insertBomb(0,8);
        testInsertMap.insertBomb(0,9);


        Assert.assertEquals(testInsertMap.getMyTotalBombs(), 10);


        testInsertMap.insertBomb(0,10);
        testInsertMap.insertBomb(0,11);

        Assert.assertEquals(testInsertMap.getMyTotalBombs(), 12);
        Assert.assertEquals(testInsertMap.getMyBombLocation().length, 20);

    }

    /**
     * This method checks if the print map method is printing the map with
     * the correct number of indicators.
     */
    @Test
    void printMapWithIndicators_SingleBomb() {
        String testMap = ("111\n1*1\n111\n");

        //Populating the Map
        MineMap testInsertMap = new MineMap(3, 3);
        testInsertMap.insertBomb(1,1);
        testInsertMap.insertIndicator(0,0);
        testInsertMap.insertIndicator(0,1);
        testInsertMap.insertIndicator(0,2);

        testInsertMap.insertIndicator(1,0);

        testInsertMap.insertIndicator(1,2);

        testInsertMap.insertIndicator(2,0);
        testInsertMap.insertIndicator(2,1);
        testInsertMap.insertIndicator(2,2);

        //Setting the indicators
        testInsertMap.indicatorSetter();

        Assert.assertEquals(testMap, testInsertMap.printMapWithIndicators());
    }

    /**
     * Insert the regular empty spot (filled with a '.')
     */
    @Test
    void insertIndicator() {
        int columns = 5;
        MineMap testInsertMap = new MineMap(1, 5);
        testInsertMap.insertIndicator(0,0);
        testInsertMap.insertIndicator(0,1);
        testInsertMap.insertBomb(0,2);
        testInsertMap.insertIndicator(0,3);
        testInsertMap.insertBomb(0,4);

        testInsertMap.indicatorSetter();

        // indicator amount is the column - the amount of bombs.. 5-2 = 3 expected indicators.
        Assert.assertEquals(columns - testInsertMap.getMyTotalBombs(), 3);

        Object[][] mineMap = testInsertMap.getMyMineMap();
        assertEquals(mineMap[0][0].getClass(), Indicator.class);
        assertEquals(mineMap[0][1].getClass(), Indicator.class);
        assertEquals(mineMap[0][3].getClass(), Indicator.class);


        assertEquals(mineMap[0][0].toString(), ".");
        assertEquals(mineMap[0][1].toString(), ".");
        assertEquals(mineMap[0][3].toString(), ".");
    }

    /**
     * Makes sure that all 8 adjacent spots relative to the spot are correctly marked
     * by increasing the bomb count.
     *
     * Test with a square 3x3 mine map with a bomb in the dead center (1, 1)
     * and so all the other spots must have a 1 as there bomb count.
     */
    @Test
    void adjacentBombSetter() {
        MineMap testInsertMap = new MineMap(3, 3);


        testInsertMap.insertIndicator(0,0);
        testInsertMap.insertIndicator(0,1);
        testInsertMap.insertIndicator(0,2);

        testInsertMap.insertIndicator(1,0);
        testInsertMap.insertBomb(1,1);
        testInsertMap.insertIndicator(1,2);

        testInsertMap.insertIndicator(2,0);
        testInsertMap.insertIndicator(2,1);
        testInsertMap.insertIndicator(2,2);


//      At first all the regions around the bomb have a default bomb count of 0.
//      We will check this to confirm and also confirm that the point (1, 1) has a bomb.
        Object[][] mineMap = testInsertMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[0][2]).getMyAdjacentBombs(), 0);

        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[1][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[1][2]).getMyAdjacentBombs(), 0);

        assertEquals(((Indicator) mineMap[2][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[2][1]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[2][2]).getMyAdjacentBombs(), 0);



//      this will call the adjacentBombSetter and will update the coordinates
//      all around the bomb to display that there is one bomb besides them.
        testInsertMap.indicatorSetter();


//      after we call adjacentBombSetter, the regions around the bomb will get their adjacent bombs
//      count updated by 1. We also confirm that there is a bomb at point (1, 1).
        mineMap = testInsertMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 1);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 1);
        assertEquals(((Indicator) mineMap[0][2]).getMyAdjacentBombs(), 1);

        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 1);
        assertEquals(mineMap[1][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[1][2]).getMyAdjacentBombs(), 1);

        assertEquals(((Indicator) mineMap[2][0]).getMyAdjacentBombs(), 1);
        assertEquals(((Indicator) mineMap[2][1]).getMyAdjacentBombs(), 1);
        assertEquals(((Indicator) mineMap[2][2]).getMyAdjacentBombs(), 1);
    }


    /**
     * Tests individually the north location setter.
     * Used to increment the bomb number, north of the bomb.
     */
    @Test
    void northLocationSet(){
        MineMap threeByOneTestMap = new MineMap(3, 1);


        threeByOneTestMap.insertIndicator(0,0);
        threeByOneTestMap.insertBomb(1,0);
        threeByOneTestMap.insertIndicator(2,0);

        Object[][] mineMap = threeByOneTestMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[1][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[2][0]).getMyAdjacentBombs(), 0);

        threeByOneTestMap.northLocationSet(new Point(1, 0));

        mineMap = threeByOneTestMap.getMyMineMap();

        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 1);
        assertEquals(mineMap[1][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[2][0]).getMyAdjacentBombs(), 0);
    }

    /**
     * Tests individually the south location setter.
     * Used to increment the bomb number, south of the bomb.
     */
    @Test
    void southLocationSet() {
        MineMap threeByOneTestMap = new MineMap(3, 1);


        threeByOneTestMap.insertIndicator(0,0);
        threeByOneTestMap.insertBomb(1,0);
        threeByOneTestMap.insertIndicator(2,0);


        Object[][] mineMap = threeByOneTestMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[1][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[2][0]).getMyAdjacentBombs(), 0);

        threeByOneTestMap.southLocationSet(new Point(1, 0));


        mineMap = threeByOneTestMap.getMyMineMap();

        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[1][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[2][0]).getMyAdjacentBombs(), 1);
    }

    /**
     * Tests individually the west location setter.
     * Used to increment the bomb number, west of the bomb.
     */
    @Test
    void westLocationSet() {
        MineMap oneByThreeTestMap = new MineMap(1, 3);


        oneByThreeTestMap.insertIndicator(0,0);
        oneByThreeTestMap.insertBomb(0,1);
        oneByThreeTestMap.insertIndicator(0,2);


        Object[][] mineMap = oneByThreeTestMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[0][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[0][2]).getMyAdjacentBombs(), 0);

        oneByThreeTestMap.westLocationSet(new Point(0, 1));


        mineMap = oneByThreeTestMap.getMyMineMap();

        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[0][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[0][2]).getMyAdjacentBombs(), 1);
    }

    /**
     * Tests individually the east location setter.
     * Used to increment the bomb number, east of the bomb.
     */
    @Test
    void eastLocationSet() {
        MineMap oneByThreeTestMap = new MineMap(1, 3);


        oneByThreeTestMap.insertIndicator(0,0);
        oneByThreeTestMap.insertBomb(0,1);
        oneByThreeTestMap.insertIndicator(0,2);

        Object[][] mineMap = oneByThreeTestMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[0][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[0][2]).getMyAdjacentBombs(), 0);

        oneByThreeTestMap.eastLocationSet(new Point(0, 1));


        mineMap = oneByThreeTestMap.getMyMineMap();

        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 1);
        assertEquals(mineMap[0][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[0][2]).getMyAdjacentBombs(), 0);
    }


    /**
     * Tests individually the north-west location setter.
     * Used to increment the bomb number, north-west of the bomb.
     */
    @Test
    void northWestLocationSet() {
        MineMap oneByThreeTestMap = new MineMap(2, 2);


        oneByThreeTestMap.insertIndicator(0,0);
        oneByThreeTestMap.insertIndicator(0,1);
        oneByThreeTestMap.insertBomb(1,0);
        oneByThreeTestMap.insertIndicator(1,1);

        // we pass (1, 0) as the bomb location and thus the north-west of that (0, 1) should have a bomb count of 1.
        Object[][] mineMap = oneByThreeTestMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[1][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[1][1]).getMyAdjacentBombs(), 0);

        oneByThreeTestMap.northWestLocationSet(new Point(1, 0));


        mineMap = oneByThreeTestMap.getMyMineMap();
        // we expect north-west of the bomb to have a bomb count of 1.
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 1);
        assertEquals(mineMap[1][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[1][1]).getMyAdjacentBombs(), 0);
    }

    /**
     * Tests individually the north-east location setter.
     * Used to increment the bomb number, north-east of the bomb.
     */
    @Test
    void northEastLocationSet() {
        MineMap oneByThreeTestMap = new MineMap(2, 2);


        oneByThreeTestMap.insertIndicator(0,0);
        oneByThreeTestMap.insertIndicator(0,1);
        oneByThreeTestMap.insertIndicator(1,0);
        oneByThreeTestMap.insertBomb(1,1);

        // we pass (1, 1) as the bomb location and thus the north-east of that (0, 0) should have a bomb count of 1.
        Object[][] mineMap = oneByThreeTestMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[1][1].getClass(), Bomb.class);

        oneByThreeTestMap.northEastLocationSet(new Point(1, 1));


        mineMap = oneByThreeTestMap.getMyMineMap();
        // we expect north-east of the bomb to have a bomb count of 1.
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 1);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[1][1].getClass(), Bomb.class);
    }

    /**
     * Tests individually the south-west location setter.
     * Used to increment the bomb number, south-west of the bomb.
     */
    @Test
    void southWestLocationSet() {
        MineMap oneByThreeTestMap = new MineMap(2, 2);


        oneByThreeTestMap.insertBomb(0,0);
        oneByThreeTestMap.insertIndicator(0,1);
        oneByThreeTestMap.insertIndicator(1,0);
        oneByThreeTestMap.insertIndicator(1,1);

        // we pass (0, 0) as the bomb location and thus the south-west of that (1, 1) should have a bomb count of 1.
        Object[][] mineMap = oneByThreeTestMap.getMyMineMap();
        assertEquals(mineMap[0][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[1][1]).getMyAdjacentBombs(), 0);

        oneByThreeTestMap.southWestLocationSet(new Point(0, 0));


        mineMap = oneByThreeTestMap.getMyMineMap();
        // we expect south-east of the bomb to have a bomb count of 1.
        assertEquals(mineMap[0][0].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[0][1]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[1][1]).getMyAdjacentBombs(), 1);
    }

    /**
     * Tests individually the south-east location setter.
     * Used to increment the bomb number, south-east of the bomb.
     */
    @Test
    void southEastLocationSet() {
        MineMap oneByThreeTestMap = new MineMap(2, 2);


        oneByThreeTestMap.insertIndicator(0,0);
        oneByThreeTestMap.insertBomb(0,1);
        oneByThreeTestMap.insertIndicator(1,0);
        oneByThreeTestMap.insertIndicator(1,1);

        // we pass (0, 1) as the bomb location and thus the south-east of that (1, 0) should have a bomb count of 1.
        Object[][] mineMap = oneByThreeTestMap.getMyMineMap();
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[0][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 0);
        assertEquals(((Indicator) mineMap[1][1]).getMyAdjacentBombs(), 0);

        oneByThreeTestMap.southEastLocationSet(new Point(0, 1));


        mineMap = oneByThreeTestMap.getMyMineMap();
        // we expect south-east of the bomb to have a bomb count of 1.
        assertEquals(((Indicator) mineMap[0][0]).getMyAdjacentBombs(), 0);
        assertEquals(mineMap[0][1].getClass(), Bomb.class);
        assertEquals(((Indicator) mineMap[1][0]).getMyAdjacentBombs(), 1);
        assertEquals(((Indicator) mineMap[1][1]).getMyAdjacentBombs(), 0);

    }
}