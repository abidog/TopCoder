
import org.junit.Test;

import static org.junit.Assert.*;

public class KadaneTest{
    @Test
    public void kadaneTest(){
        int[] arr = {-1,3,7,-10};
        int exp = 10;
        Kadane kadane = new Kadane();
        assertEquals(exp, kadane.wrapKadane(arr));

    }

}