import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MagicCandy {

    public static void main(String[] args) {
        MagicCandy mc = new MagicCandy();
        System.out.println(mc.whichOne(460216916));
    }

    private long f(long n) {
        return n - (long)Math.sqrt(n);
    }

    private long fInv(long x) {

        long l = x;
        long r = 2*x + 100;
        while (r - l > 1) {

            long m = l  + ((r - l) >> 1);
            if (f(m) < x) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }
    public long step(long n) {
        long re = 0;
        while (n > 1) {
            n = f(n);
            re++;
        }
        return  re;
    }

    public int whichOne(int n) {

        int lastCandy = n;

        while (n > 1) {
            int disregard = (int)Math.sqrt(n);
            if (disregard * disregard == n) {
                lastCandy--;
            }
            n = n - (int) disregard;

        }
        return lastCandy;
	}
}
