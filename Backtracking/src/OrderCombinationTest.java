import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderCombinationTest {

    @org.junit.Test
    public void orderComboTest(){
        int[] arr = {1,2,3,4};
        OrderCombination orderCombo = new OrderCombination();
        List<List<List<Integer>>> combo = orderCombo.nonOverLapCombination(arr);

    }

}
