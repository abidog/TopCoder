package Arrays;

import org.junit.Test;

public class SpiralMatrixTest {
    @Test
    public void test(){
        SpiralMatrix sp = new SpiralMatrix();
        int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        sp.spiral(mat);
    }
}
