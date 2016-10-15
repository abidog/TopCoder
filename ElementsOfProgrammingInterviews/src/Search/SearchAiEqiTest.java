package Search;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchAiEqiTest {

    @Test
    public void testSearch() {
        SearchAiEqi searchAiEqi = new SearchAiEqi();
        int[] arr = {-5,-4,-3,-2,-1,0,5, 7, 8, 9};
        assertEquals(7, searchAiEqi.search(arr));
    }
}
