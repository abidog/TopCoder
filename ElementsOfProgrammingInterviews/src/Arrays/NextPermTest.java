package Arrays;


import org.junit.Test;
import static org.junit.Assert.*;

public class NextPermTest {
    @Test
    public void nextPermTest () {
        NextPerm next = new NextPerm();
        int[] arr = {1,3,2};
        int[] exp = {2,1,3};
        assertArrayEquals(exp, next.next(arr));
    }
}
