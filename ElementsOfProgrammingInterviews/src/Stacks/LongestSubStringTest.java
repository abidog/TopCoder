package Stacks;
import org.junit.Test;
import static org.junit.Assert.*;

public class LongestSubStringTest {
    @Test
    public void longestSubStringTest() {
        LongestSubString longestSubString = new LongestSubString();
        String test = "))))))";
        assertEquals(0, longestSubString.maxParen(test));
    }

}
