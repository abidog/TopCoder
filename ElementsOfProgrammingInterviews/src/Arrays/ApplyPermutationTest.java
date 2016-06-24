package Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class ApplyPermutationTest {
    @Test
    public void applyPermutationTest () {
        ApplyPermutation apply = new ApplyPermutation();
        char[] arr = {'a','b','c','d'};
        int[] perm = {2,0,1,3};
        char[] exp = {'b','c','a','d'};
        assertArrayEquals(exp, apply.apply(arr, perm));
    }
}
