package Stacks;

import org.junit.Test;
import static org.junit.Assert.*;
public class MaxQTest {
    @Test
    public void maxQTest() {
        MaxQ max = new MaxQ();
        int[] in = {3,2,1,6,2};
        for (int i : in) {
            max.enqueu(i);
            System.out.println(max.max());
        }
        max.dequeu();
        System.out.println(max.max());
        max.dequeu();
        System.out.println(max.max());
        max.dequeu();
        System.out.println(max.max());
        max.dequeu();
        System.out.println(max.max());


    }

}
