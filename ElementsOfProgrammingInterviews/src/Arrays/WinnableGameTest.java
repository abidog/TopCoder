package Arrays;
import org.junit.Test;
import static org.junit.Assert.*;


public class WinnableGameTest{
    @Test
    public void winnableGameTest() {
        WinnableGame winGame = new WinnableGame();
        int [] game1 = {3,4,0,0,0,1,0};
        assertTrue(winGame.isWin(game1));
    }
}
