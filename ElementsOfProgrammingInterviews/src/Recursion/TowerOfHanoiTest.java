package Recursion;
import org.junit.Test;
import static org.junit.Assert.*;

public class TowerOfHanoiTest {
    @Test
    public void towwerOfHanoi() {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        System.out.println(towerOfHanoi.hanoi(3, 1,3));
    }
}
