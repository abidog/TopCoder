package Strings;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReverseWordsTest {
    @Test
    public void reverseWordsTest() {
        ReverseWords reverse = new ReverseWords();
        String test = "Alice likes Bob";
        String exp = "Bob likes Alice";
        assertEquals(exp, new String(reverse.reverseWords(test.toCharArray())));
    }

}
