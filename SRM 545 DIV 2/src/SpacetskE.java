import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class SpacetskE {

    class Point{
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

	public int countsets(int L, int H, int K) {


        if (K == 1) {
            return (L + 1) * (H + 1);
        }

        int[][] nCk = new int[300][300];
        int mod = 1000000007;
        for (int i = 0; i < 300; i++) {
            nCk[i][0] = 1;
            for (int j = 1; j <= i; j++) {


                nCk[i][j] = (nCk[i - 1][j] + nCk[i - 1][j - 1]) % mod;

            }
        }

        long res = 0;
        for (int x0 = 0; x0 <= L ; x0++) {

            for (int x = -L; x <= L ; x++) {
                for (int y = 1; y <= H; y++) {
                    if (gcd(x,y) == 1) {
                        int xBegin = x0;
                        int yBegin = 0;
                        int t = 0;
                        while (xBegin >= 0 && xBegin <= L && yBegin <= H) {
                            t++;
                            xBegin += x;
                            yBegin += y;
                        }
                        res = (res + nCk[t][K]) % mod;
                    }
                }
            }

        }
        return (int)res;
	}
}
