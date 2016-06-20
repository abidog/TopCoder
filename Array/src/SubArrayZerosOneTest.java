import org.junit.Test;
import static org.junit.Assert.*;

public class SubArrayZerosOneTest {
    @Test
    public void maxSubArrayTest() {
        SubArrayZerosOne subArray = new SubArrayZerosOne();
            int[] arr = {0,1,1,1,1,1,0,0,0,0,1,1,1};
            int exp = 10;
            assertEquals(exp, subArray.maxSubArray(arr));
    }
}
