package Search;

import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtTest {

    @Test
    public void testSqrt() {
        Sqrt sqrt = new Sqrt();
        int num = 17;
        assertEquals(5, sqrt.sqrt(num));
    }

}
