package Arrays;
import org.junit.Test;
import static org.junit.Assert.*;


public class RotateArrayTest {

    @Test
    public void rotateArrayTest() {
        RotateArray rotate = new RotateArray();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 3;
        int[] exp = {4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3};
        assertArrayEquals(exp, rotate.rotateArray(arr, k));
    }

}
