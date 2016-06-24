package Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class MulLargeStringTest {
    @Test
    public void mulLargeStringTest() {
        MulLargeString mul = new MulLargeString();
        String num1 = "123456789";
        String num2 = "30";
        String exp = "3703703670";

        assertEquals(exp, mul.mul(num1, num2));
    }

}
