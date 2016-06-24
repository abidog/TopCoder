package Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteDupTest {
    @Test
    public void deleteDupTest() {
        DeleteDup deleteDup = new DeleteDup();
        int[] arr = {1,1,1,2,2,2,3,3,4,4,5,6,6};
        int[] exp = {1,2,3,4,5,6};
        assertArrayEquals(exp, deleteDup.deleteDup(arr));
    }
}
