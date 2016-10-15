package Sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaxEventConcurentTest {
    @Test
    public void maxEventTest() {
        MaxEventConcurent maxEventConcurent = new MaxEventConcurent();
        int[] s = {1,2,3,4,5};
        int[] e = {3,3,7,7,7};
        int exp = 3;
        assertEquals(exp, maxEventConcurent.maxEvent(s, e));
    }

}
