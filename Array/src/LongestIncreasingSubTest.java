import org.junit.Test;
import static org.junit.Assert.*;

public class LongestIncreasingSubTest {
    @Test
    public void longestSubSeqTest() {
        int[] arr = {1,-1,2,5,3,-6,1,9};
        int exp = 4;
        LongestIncreasingSubSequence subseq = new  LongestIncreasingSubSequence();
        assertEquals(exp, subseq.maxLongestSubSeq(arr));
    }
}
