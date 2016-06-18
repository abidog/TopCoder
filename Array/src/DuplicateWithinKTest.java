import org.junit.Test;
import static org.junit.Assert.*;

public class DuplicateWithinKTest {
    @Test
    public void duplicateTest() {
        DuplicateWithinK duplicateK = new  DuplicateWithinK();
        int[] arr = {2,3,5,7,4,2,7,3,6,7};
        int k = 4;
        assertEquals(true, duplicateK.duplicateWithinK(arr, k));
    }
}
