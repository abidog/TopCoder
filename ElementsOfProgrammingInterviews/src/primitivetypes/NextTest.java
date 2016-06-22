package primitivetypes;
import org.junit.Test;
import static org.junit.Assert.*;
public class NextTest{
    @Test
    public void nextTest() {
        Next next = new Next();
        int b = 6; // 00110
        int exp = 1; // 0101
        assertEquals(exp, next.next(b));
    }
}
