import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class FractionInDifferentBases {

    private long gcd(long a, long b) {
        while (b != 0) {
            long c = b;
            b = a%b;
            a = c;
        }
        return a;
    }
	
	public long getNumberOfGoodBases(long P, long Q, long A, long B) {

        long gc = gcd(P, Q);
        P /= gc;
        Q /= gc;

        long Y = 1;
        for (long base = 2; base <= Q / base; base++) {
            if (Q % base == 0) {
                Y *= base;
                while (Q % base == 0) {
                    Q /= base;
                }
            }
        }
        Y *= Q;

        long finite = B/Y - (A-1)/Y;

		return (B - A + 1) - finite;
	}
}
