package Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReplaceAndRemoveTest {
    @Test
    public void replaceAndRemoveTest() {
        char[] sampe = {'b','i','a','k'};
        char[] exp = {'i','d','d','k'};
        ReplaceAndRemove replaceAndRemove = new ReplaceAndRemove();
        assertArrayEquals(exp, replaceAndRemove.replaceAndRemove(sampe));
    }

}
