package dp;
import org.junit.Test;
import static org.junit.Assert.*;
public class KnapSackTest {
    @Test
    public void knapSackTest() {
        KnapSack knapSack = new KnapSack();
        int[] w = {20,8,60,55,40,70,85,25,30,65,75,10,95,50,40,10};
        int[] p = {65,35,245,195,65,150,275,155,120,320,75,40,200,100,220,99};
        knapSack.knapsack(w,p,130);
    }

}
