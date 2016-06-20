import org.junit.Test;
import static org.junit.Assert.*;

public class MaximumSubArraySumTest{
    @Test
    public void maxSubArraySumTest () {
        MaximumSubArraySum maxSubSum = new MaximumSubArraySum();
        int[] arr = {-1,-5,-1};
        int exp = -1;
        assertEquals(exp, maxSubSum.maxSubArraySum(arr));
    }
}
