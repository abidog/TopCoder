import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class Mosquitoes {
    public static void main(String[] args) {
        Mosquitoes m = new Mosquitoes();
        int[] xInit = new int[] {18, -1, -9, 15, 10, -55, 27, -5};
        int[] v = new int[] {-31, -7, 0, -28, -20, 56, -42, -4};
        int R = 1;




        System.out.println(m.getMaximum(xInit, v, R));
    }

    public int getMaximum(int[] xInit, int[] v, int R) {


        int best  = tryTime(0,1, xInit, v, R);
        int n = xInit.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n ; j++) {


                int xj = xInit[j] - xInit[i];
                int vj = v[j] - v[i];
                if (vj == 0) {
                    continue;
                } else {
                    // xj + t0 * vj = 0;
                    if (-xj * vj >= 0) {
                        best = Math.max(best, tryTime(-xj, vj, xInit, v, R));
                    }

                }

            }

        }


        return best;
	}

    private int tryTime(int ta, int tb, int[] xInit, int[] v, int r) {

        // try time ta/tb
        int best = 0;
        int n = xInit.length;
        for (int i = 0; i < n; i++) {
            int x0 = xInit[i];
            int v0 = v[i];
            int c = 0;
            for (int j = 0; j < n; j++) {
                int x1 = xInit[j];
                int v1 = v[j];

                // check starting from
                // x0 + v0 * ta/tb ..... x0 + v0 * ta/tb + 2r

                // x0 + v0 * ta/tb <= x1 + v1 * ta / tb
                //1) x0 * tb + v0 * ta  <= x1 * tb + v1 * ta
                //2) x1 * tb + v1 * ta <= x0 * tb + v0 * ta
                if (x0 * tb + v0 * ta  <= x1 * tb + v1 * ta && x1 * tb + v1 * ta <= x0 * tb + v0 * ta + 2 * r * tb ) {
                    c++;
                }

            }
            best = Math.max(best, c);
        }

        return best;
    }
}
