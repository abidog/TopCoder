
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayConsecutiveNumberTest {
    @Test
    public void arrayConsecutiveNumberTest() {
        ArrayConsecutiveNumber arrayConsecutive = new ArrayConsecutiveNumber();
        int[] arr = {4, 2, 3,1};
        assertEquals(true, arrayConsecutive.isConsecutive(arr));
    }
}
