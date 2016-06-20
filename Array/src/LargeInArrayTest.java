import org.junit.Test;
import static org.junit.Assert.*;

public class LargeInArrayTest{

    @Test
    public void largeIntArrayTest() {
        LargeIntArray intArray= new LargeIntArray();
        int[] exp = new int[2];
        exp[0] = 3;
        exp[1] = 5;
        //  arry = 0,0,0, ... .... . 35
        for (int i = 0; i < 35; i++) {
            intArray.increment();
        }
        assertArrayEquals(intArray.arr, exp);
    }
}
