package Sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class ComputeViewFromAboveTest {
    @Test
    public void computeView() {
        Segment s1 = new Segment(0,1,1,0);
        Segment s2 = new Segment(0,2,2,1);
        Segment s3 = new Segment(1,4,3,3);
        Segment[] segs = {s3,s2,s1};
        int[] exp = {1,2,3,3};
        ComputeViewFromAbove computeViewFromAbove = new ComputeViewFromAbove();
        assertArrayEquals(exp, computeViewFromAbove.view(segs));

    }

}
