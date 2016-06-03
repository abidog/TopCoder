import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class LuckyRemainder {
	
	public int getLuckyRemainder(String X) {
        long res = 0;
        for (int i = 0; i < X.length(); i++) {
             res += X.charAt(i) - '0';
        }
        res %= 9;
        return  (int)((res << (X.length() - 1)) % 9);
	}
}
