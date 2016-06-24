package Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class IncrementTest {
    @Test
    public void incrementTest(){
        Increment inc = new Increment();
        String num = "123";
        String exp = "124";
        assertEquals(exp, inc.increment(num));
    }
}
