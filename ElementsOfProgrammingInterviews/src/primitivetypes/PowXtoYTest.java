package primitivetypes;

import org.junit.Test;
import static org.junit.Assert.*;

public class PowXtoYTest {
    @Test
    public void powXtoYTest(){
        PowXtoY powX = new PowXtoY();

        double x = 2.0;
        int y = 4;
        double exp = 16.0;
        double eps = 1e-6;
        ///System.out.println(powX.pow(x, y));
        assertTrue(exp - powX.pow(x, y) < eps);
    }
}
