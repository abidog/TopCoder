import org.junit.Test;
import static org.junit.Assert.*;

public class KthLargestElemTest{

    @Test
    public void kthLargest() {
        KthLargestElem kthLargest = new KthLargestElem();
        int[] arr = {-1,2,0};
        int k = 1;
        int expected = 2;
        assertEquals(expected, kthLargest.getKthLargestElem(arr, k));
    }

}
