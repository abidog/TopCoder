import org.junit.Test;
import static org.junit.Assert.*;
public class MinimumSortedWhichSortArrayTest {
    @Test
    public void minimumSortedWhichSortArray(){
        MinimumSortedWhichSortArray minSorted = new MinimumSortedWhichSortArray();
        int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        int[] exp = {2,5};
        assertArrayEquals(exp, minSorted.minimumSortedWhichSortArray(arr));
    }
}
