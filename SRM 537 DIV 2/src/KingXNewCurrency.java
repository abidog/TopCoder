import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class KingXNewCurrency {

    public static void main(String[] args) {
        KingXNewCurrency kx = new KingXNewCurrency();
        int A = 7;
        int B = 4;
        int X = 13;

        System.out.println(kx.howMany(A,B,X));
    }

    public boolean isCombo(int num , int X, int Y) {

        for (int n = 0; n * X <= num; n++) {
            if ((num - n * X) % Y == 0) {
                return true;
            }
        }
        return false;
    }
    public int howMany(int A, int B, int X) {
        // Ap + Bq = k

        if (A % X == 0 && B % X == 0) {
            return -1;
        }
        int res = 0;
        for (int y = 1; y <= Math.max(A, B); y++) {
            if (y != X && isCombo(A, X, y) && isCombo(B, X, y)) {
                res++;
            }
        }
        return res;

    }
}
