import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplyAllFieldsExceptOwnPositionTest {
    @Test
    public void multiplyAllFieldsExceptOwnPositionTest() {
        MultiplyAllFieldsExceptOwnPosition multiple = new MultiplyAllFieldsExceptOwnPosition();
        int[] arr = {2,3,1,4};
        int[] exp = {12,8,24,6};
        assertArrayEquals(exp, multiple.multiplyAllFieldsExceptOwnPosition(arr));

    }
}
