package primitivetypes;
import org.junit.Test;
import static org.junit.Assert.*;

public class DecodeTest{
    @Test
    public void decodeTest() {
        Decode decodeTest = new Decode();
        String num = "CA";
        int exp = 79;
        assertEquals(exp, decodeTest.ssDecodeColID(num));
    }
}

