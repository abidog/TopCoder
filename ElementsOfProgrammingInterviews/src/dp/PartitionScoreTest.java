package dp;
import org.junit.Test;
import static org.junit.Assert.*;

public class PartitionScoreTest {
    @Test
    public void partitionTest() {
        PartitionScore partitionScore = new PartitionScore();
        int[] w = {2,3,7};
        int s = 12;
        partitionScore.getTrace(w,s);
    }
}
