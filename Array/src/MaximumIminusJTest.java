import org.junit.Test;
import static org.junit.Assert.*;

public class MaximumIminusJTest {
    @Test
    public void maximumIminusJTest () {
        MaximumIminusJSuchThatAiGTAj max = new MaximumIminusJSuchThatAiGTAj();
        int[] arr = {2,3,4,1,3,-3,-4,-8};
        int exp = 5;
        assertEquals(max.findMaxiandj(arr), exp);
    }
}
