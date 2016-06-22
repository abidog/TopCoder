package primitivetypes;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplyTwoTest{
    @Test
    public void multiplyTwoTest() {
        MultiplyTwo mt = new MultiplyTwo();
        int a = 7;
        int b = 4;
        int exp = 28;
        assertEquals(exp, mt.multiply(a,b));
    }

}
