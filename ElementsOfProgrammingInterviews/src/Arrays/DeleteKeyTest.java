package Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteKeyTest {
    @Test
    public void deleteKeyTest() {
        DeleteKey deleteKey = new DeleteKey();
        int[] arr = {1,1,2,2,3,3,3};
        int[] exp = {1,1,2,2};
        assertArrayEquals(exp, deleteKey.delete(arr, 3));

    }
}
