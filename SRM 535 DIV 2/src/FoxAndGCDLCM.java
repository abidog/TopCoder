import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class FoxAndGCDLCM {

    public static void main(String[] args) {
        FoxAndGCDLCM fox = new FoxAndGCDLCM();
        System.out.println(fox.get(1,1));
    }

    public long gcd(long a, long b) {

       if (b == 0) {
           return a;
       }
        return gcd(b, a % b);
    }



	public long get(long G, long L) {

        if (L % G != 0) {
            return -1;
        }
        long res = Long.MAX_VALUE;
        long ab = L / G; // a and b coprime

        for (long a = 1; a <= ab/a ; a++) {

            if (ab % a == 0 && gcd (a, ab / a) == 1) {
                res = Math.min(res, (a + ab/a) * G);
            }

        }

		return res;
	}
}
