import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class EllysThreeRivers {

    double[][] a;
    double walkSpeed;
    static int MAX = 3;
    double sqr(double val) {return val * val;}
    static int INF = 2000000000;

    public double ternarySearch(int idx, double rem) {
        if (idx >= 3) {
            return rem/walkSpeed;
        }
        double ans = Double.MAX_VALUE;
        double left = 0.0;
        double right = rem;
        for (int i = 0; i < 100; i++) {

            double m1 = left + (right - left) /3.0;
            double m2 = right - (right - left) / 3.0;

            double a1 = ternarySearch(idx + 1, rem - m1) + sqrt(sqr(a[idx][0]) + sqr(m1)) / a[idx][1];
            ans = Math.min(ans, a1);
            double a2 = ternarySearch(idx + 1, rem - m2) + sqrt(sqr(a[idx][0]) + sqr(m2)) / a[idx][1];
            ans = Math.min(ans, a2);

            if (a1 < a2) {
                right = m2;
            } else {
                left = m1;
            }

        }
        return ans;
    }


	
	public double getMin(int length, int walk, int[] width, int[] swim) {

        this.walkSpeed = walk;

        a = new double[MAX][2];

        for (int i = 0; i < 3; i++) {
            a[i][0] = width[i];
            a[i][1] = swim[i];
        }

        return ternarySearch(0, length);
	}

}
