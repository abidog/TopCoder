package primitivetypes;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConvertBaseTest {
    @Test
    public void convertBaseTest() {
        ConvertBase cb = new ConvertBase();
        String num =  "200";
        String exp = "125";
        assertEquals(exp, cb.convert(num, 10, 13));
    }
}
