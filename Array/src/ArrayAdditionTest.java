import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayAdditionTest {
    @Test
    public void testAddArray() {
        ArrayAddition googleInterview = new ArrayAddition();
        int[] arr1 = {1, 9, 8};
        int[] arr2 = {1, 2};
        int[] expected = {2,1,0};
        int[] returnedArray = googleInterview.addArray(arr1, arr2);
        assertArrayEquals(expected, returnedArray);

    }
}



