package Search;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSelectTest {

    @Test
    public void quickSelectTest() {
        QuickSelect qs = new QuickSelect();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        assertEquals(6, qs.quickSelect(arr, k));
    }
}
