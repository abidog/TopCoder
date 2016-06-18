import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class MoreThanNbyKTest {
    @Test
    public void moreThanNbyKTest() {
        MoreThanNbyK moreThanNbyK  = new MoreThanNbyK();
        int[] intArray = {1,2,3,45,6,45,2};
        Set<Integer> result = moreThanNbyK.findElementNbyK(intArray,3);
        Set<Integer> expected = new HashSet<>();
        expected.add(2);
        expected.add(45);
        assertEquals(expected, result);
    }
}

