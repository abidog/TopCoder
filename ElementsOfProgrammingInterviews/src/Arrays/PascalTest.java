package Arrays;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PascalTest {

    @Test
    public void pascalTest() {
        Pascal pascal = new Pascal();
        List<Integer> res = pascal.pascal(5);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }

}
