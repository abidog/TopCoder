package Recursion;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromePartitionTest {
    @Test
    public void palidrome() {
        PalindromePartition palindromePartition = new PalindromePartition();
        String s = "aab";
        palindromePartition.partition(s);
    }

}
