import org.junit.Test;
import static org.junit.Assert.*;
public class KadaneGasCircularTest {

    @Test
    public void kadaneTest(){
        KadaneGasCircular kadane = new KadaneGasCircular();
        int[] gasAvailable = {4, 4, 6};
        int[] gasRequired = {5, 6, 1};

        assertEquals(2, kadane.gasCirclular(gasAvailable, gasRequired));
    }
}
