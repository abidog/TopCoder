import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class FoxPaintingBalls {
    public static void main(String[] args) {
        FoxPaintingBalls fb = new FoxPaintingBalls();
        long R = 678784925379051339l;
        long G = 10400178261775338l;
        long B = 596597756820352946l;
        int N = 219585852;
        System.out.println(fb.theMax(R, G, B, N));
    }

    public long theMax(long R, long G, long B, int N) {


        if (N == 1) {
            return R + G + B;
        }
        long n = N;
        long x = (n * (n + 1)/2)/3;

        if (N % 3 == 0 || N % 3 ==2) {
            return Math.min(R, Math.min(G,B))/x;
        }
        long l = 0;
        long r = R + G + B;
        long sum = R + G + B;
        long res = 0;
        while (l <= r) {



            long m = l + ((r - l) >> 1);

            if (Math.min(R, Math.min(G, B))/x >= m  && sum - m * 3l * x >=  m) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }

        }
        return res;
	}
}
