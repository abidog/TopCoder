package Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void palindromeTest() {
        String str = "A man, a plan, a canal, Panama.";
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalin(str));
    }

}
