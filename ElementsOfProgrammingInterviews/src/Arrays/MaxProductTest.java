package Arrays;

import org.junit.Test;
import static org.junit.Assert.*;
public class  MaxProductTest {
    @Test
    public void maxProduct() {
        int[] arr = {3,2,4,6,10};
        int exp = 720;
        MaxProduct max = new MaxProduct();
        assertEquals(exp, max.maxProduct(arr));
    }
}
