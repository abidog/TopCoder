import org.junit.Test;
import static org.junit.Assert.*;

public class BuySellStockProfitTest {
    @Test
    public void oneProfitTest(){
        BuySellStockProfit buysellTest = new BuySellStockProfit();
        int[] prices = {-1,-2,3,12};
        int expected = 14;
        assertEquals(expected, buysellTest.oneProfit(prices));

    }

}
