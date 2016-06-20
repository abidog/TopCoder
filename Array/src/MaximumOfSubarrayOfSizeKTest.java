import org.junit.Test;
import static org.junit.Assert.*;

public class MaximumOfSubarrayOfSizeKTest{
    @Test
    public void maximumOfSubarrayOfSizeKTest (){
        MaximumOfSubarrayOfSizeK maximum = new MaximumOfSubarrayOfSizeK();
        int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 4;
        int[] exp = {10, 10, 10, 15, 15, 90, 90};
        assertArrayEquals(maximum.maxOfSubarrayOfSizeK(arr, k), exp);
    }
}
