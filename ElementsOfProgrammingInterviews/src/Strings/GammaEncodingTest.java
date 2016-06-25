package Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class GammaEncodingTest {
    @Test
    public void gammaEncodingTest() {
        GammaEncoding gammaEncoding = new GammaEncoding();
        int[] num = {3, 2};
        String exp = "011010";

        assertEquals(exp, gammaEncoding.encode(num));
        assertArrayEquals(num, gammaEncoding.decode(exp));

    }
}
