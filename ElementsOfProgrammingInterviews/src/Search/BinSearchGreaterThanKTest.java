package Search;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinSearchGreaterThanKTest {
    @Test
    public void findGreaterTest() {
        BinSearchGreaterThanK bin = new BinSearchGreaterThanK();
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        int k = 10;
        assertEquals(-1, bin.search(arr, k));

    }

}
