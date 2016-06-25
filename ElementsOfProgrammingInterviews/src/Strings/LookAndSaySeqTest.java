package Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class LookAndSaySeqTest {
    @Test
    public void lookAndSaySeqTest() {
        LookAndSaySeq look = new LookAndSaySeq();
        String exp = "1113213211";
        assertEquals(exp, look.lookAndSay(8));
    }
}
