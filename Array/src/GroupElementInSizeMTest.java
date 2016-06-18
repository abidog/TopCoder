import org.junit.Test;
import static org.junit.Assert.*;

public class GroupElementInSizeMTest {
    @Test
    public void groupElementInSizeMTest2() {
        GroupElementInSizeM groupElementInSizeM = new GroupElementInSizeM();
        int[] intArray =  {4,1,1,1,4,1,1,1};
        int[] expected = {1,1,4,1,1,4,1,1};
        intArray = groupElementInSizeM.groupinSizeM(intArray, 2);
        assertArrayEquals(intArray, expected);
    }





    @Test
    public void groupElementInSizeMTest() {
        GroupElementInSizeM groupElementInSizeM = new GroupElementInSizeM();
        int[] intArray = {1,2,3,4,4,4,4,4,4};
        int[] expected = {4,4,4,2,4,4,4,3,1};
        intArray = groupElementInSizeM.groupinSizeM(intArray, 3);
        assertArrayEquals(intArray, expected);
    }


}
