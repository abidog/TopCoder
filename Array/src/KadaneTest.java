import org.junit.Test;
import static org.junit.Assert.*;
public class KadaneTest {

    @Test
    public void kadaneTest(){
        Kadane kadane = new Kadane();
        int[] gasAvailable = {4, 4, 6};
        int[] gasRequired = {5, 6, 1};

        assertEquals(2, kadane.gasCirclular(gasAvailable, gasRequired));
    }
}
