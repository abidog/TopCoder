import org.junit.Test;
import static org.junit.Assert.*;
public class GasStationCircleTest {

    @Test
    public void gasStationCircleTest() {
        GasStation gasStation = new GasStation();
        int[] gasAvailable = {4, 4, 6};
        int[] gasRequired = {5, 6, 1};

        assertEquals(2, gasStation.gasStationCircle(gasAvailable, gasRequired));

    }

}
