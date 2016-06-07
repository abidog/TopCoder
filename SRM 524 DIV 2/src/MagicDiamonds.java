import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MagicDiamonds {
	
	public long minimalTransfer(long n) {
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        if (n % 2 == 0 || n == 1) {
            return 1;
        }
        for (long i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return 1;
            }
        }
        // it means n is prime number
        return 2;
	}

}
