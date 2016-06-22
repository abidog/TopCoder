package primitivetypes;

import org.junit.Test;
import static org.junit.Assert.*;

public class DivideTwoTest{

    @Test
    public void divideTwoTest(){
        int a = 14;
        int b = 3;
        int exp = 4;
        DivideTwo dt = new DivideTwo();
        assertEquals(exp, dt.divide(a,b));
    }
}
