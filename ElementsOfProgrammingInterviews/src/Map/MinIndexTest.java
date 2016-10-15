package Map;


import org.junit.Test;
import static org.junit.Assert.*;


public class MinIndexTest {
    @Test
    public void minIndexTest() {
        MinIndex minIndex = new MinIndex();
        int[] a = {2,4,-5,2,7,4,2,5,-5,79,0,6,90,7,2,-5,6,7,4,5};
        int[] q = {7,2,-5};
        minIndex.minIndex(a,q);

    }
}
