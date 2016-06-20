import org.junit.Test;
import static org.junit.Assert.*;

public class MaximumSubArrayProductTest{
    @Test
    public void maximumSubArraySumTest() {
        MaximumSubArrayProduct maxProduct = new MaximumSubArrayProduct();
        int[] arr = {-2,-1,-1};
        int exp = 2;
        assertEquals(exp, maxProduct.maximumSubArraySum(arr));
    }
}