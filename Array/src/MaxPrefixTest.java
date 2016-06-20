import org.junit.Test;
import static org.junit.Assert.*;

public class MaxPrefixTest{
    @Test
    public void maxPrefixTest1() {
        int[] arr  = {10,-4,6,2,8,9,4};
        int expected = 5;
        MaxPrefix maxPrefix = new MaxPrefix();
        assertEquals(expected, maxPrefix.maxPrefix(arr) );
    }
    @Test
    public void maxPrefixTest2() {
        int[] arr  = {1,2,2,2,3,3,4};
        int expected = 6;
        MaxPrefix maxPrefix = new MaxPrefix();
        assertEquals(expected, maxPrefix.maxPrefix(arr) );
    }
    @Test
    public void maxPrefixTest3() {
        int[] arr  = {4,3,2,1,0};
        int expected = 0;
        MaxPrefix maxPrefix = new MaxPrefix();
        assertEquals(expected, maxPrefix.maxPrefix(arr) );
    }
    @Test
    public void maxPrefixTest4() {
        int[] arr  = {0,0};
        int expected = 0;
        MaxPrefix maxPrefix = new MaxPrefix();
        assertEquals(expected, maxPrefix.maxPrefix(arr) );
    }
}
