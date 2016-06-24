package Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class DutchFlagTest {

    @Test
    public void dutchFlagTest() {
        int[] arr = {1,0,2,1,2,0,1,2};
        int[] exp = {0,0,1,1,1,2,2,2};

        DutchFlag df = new DutchFlag();
        assertArrayEquals(exp, df.partition(arr, 0));

    }

}
