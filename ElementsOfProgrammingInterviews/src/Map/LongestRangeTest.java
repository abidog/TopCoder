package Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongestRangeTest {
    @Test
    public void longestRangeTest() {
        LongestRange longestRange = new LongestRange();
        int[] arr = {3,-2, 7, 9,8, 1,2,0};
        System.out.println(longestRange.longestRange(arr));
    }

}
