package Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinIandJTest {
    @Test
    public void minIandJTest() {
        MinIandJ minIandJ = new MinIandJ();
        String[] A = {"a", "b", "c", "d","e","f","e","c","l"};
        String[] Q = {"c", "e"};

        assertArrayEquals(new int[]{6,7},minIandJ.minIandJ(A, Q));

    }

}
