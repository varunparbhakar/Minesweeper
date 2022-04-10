public class Indicator {
    private int myAdjacentBombs;

    Indicator() {
        myAdjacentBombs = 0;
    }
    protected void bombNearBy() {
        myAdjacentBombs++;
    }

    public int getMyAdjacentBombs() {
        return myAdjacentBombs;
    }

    @Override
    public String toString() {
        return ".";
    }
}
