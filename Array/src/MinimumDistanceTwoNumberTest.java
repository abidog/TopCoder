import org.junit.Test;
import static org.junit.Assert.*;

public class MinimumDistanceTwoNumberTest {
    @Test
    public void minimumDistanceTwoNumber(){
        MinimumDistanceTwoNumber minDis = new MinimumDistanceTwoNumber();
        int  arr[] =  {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2;
        int exp = 1;
        assertEquals(exp, minDis.minDistanceTwoNumber(arr, x,y));
    }
}
