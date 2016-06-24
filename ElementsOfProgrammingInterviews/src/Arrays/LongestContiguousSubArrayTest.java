package Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class LongestContiguousSubArrayTest{
    @Test
    public void longestContiguousSubArray() {
        LongestContiguousSubArray longest = new LongestContiguousSubArray();
        int[] arr = {2,-1,2,3,5, 4,5, 6 , 7, 8, 9, 10};
        int[] exp = {5,11};
        assertArrayEquals(exp, longest.longest(arr));
    }
}
