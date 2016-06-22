package primitivetypes;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseDigitTest {
    @Test
    public void reverseDigitTest() {
        ReverseDigit reverse = new ReverseDigit();
        int num = -245;
        assertEquals(-542, reverse.reverseDigit(num));
    }

}
