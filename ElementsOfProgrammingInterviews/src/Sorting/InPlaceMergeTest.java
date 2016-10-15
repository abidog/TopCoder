package Sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class InPlaceMergeTest {

    @Test
    public void inPlaceMerge() {
        InPlaceMerge inPlaceMerge = new InPlaceMerge();
        int[] arr= {3,2,4,1,0,-1};
        int[] exp = {-1, 0, 1, 2, 3,4 };
        inPlaceMerge.mergeSort(arr);
        assertArrayEquals(exp, arr);
    }
}
