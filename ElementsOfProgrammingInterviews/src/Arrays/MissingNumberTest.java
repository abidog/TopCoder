package Arrays;

import org.junit.Test;
import static org.junit.Assert.*;
public class MissingNumberTest {
    @Test
    public void missingNumberTest() {
        MissingNumber missing = new MissingNumber();
        int[] arr = {1,2,3,5,6,7,8,9,10};
        int exp = 4;
        assertEquals(exp, missing.missing2(arr));
    }
}
