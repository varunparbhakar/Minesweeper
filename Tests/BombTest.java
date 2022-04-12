
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BombTest {
    @Test
    void testBombConstructor(){
        Bomb bomb = new Bomb();
        assertEquals(Bomb.class, bomb.getClass());
    }
    @Test
    void testToString() {
        Bomb bomb = new Bomb();
        assertEquals("*", bomb.toString());
    }
}