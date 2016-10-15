
import org.junit.Test;
import static org.junit.Assert.*;
public class TugOfWarTest {
    @Test
    public void testTugOfWar() {
        TugOfWar tug = new TugOfWar();
        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        System.out.println(tug.tugOfWar(arr));
    }


}
