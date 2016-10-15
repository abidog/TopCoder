package Search;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinSearchTest {
    @Test
    public void testBin() {
        BinSearch binSearch = new BinSearch();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(9, binSearch.binSearch(arr, 10));
    }
}
