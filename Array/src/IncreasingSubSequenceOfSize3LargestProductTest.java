import junit.framework.TestCase;
import org.junit.Test;

public class IncreasingSubSequenceOfSize3LargestProductTest{
    @Test
    public void test1(){
        IncreasingSubSequenceOfSize3LargestProduct test = new IncreasingSubSequenceOfSize3LargestProduct();
        long[] arr = {1,2,3,-1,4,5,-4, 6};
        long exp = 120;
        TestCase.assertEquals(exp, test.maxProduct(arr));
    }

}
