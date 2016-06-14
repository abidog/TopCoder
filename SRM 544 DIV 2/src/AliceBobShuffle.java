import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class AliceBobShuffle {
	int[] as;
    int[] bs;
    int[] ae;
    int[] be;
	public int countWays(int[] AliceStart, int[] BobStart, int[] AliceEnd, int[] BobEnd) {

        int[][][][] dp = new int[51][51][51][51];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                for (int k = 0; k < 51; k++) {
                    Arrays.fill(dp[i][j][k], - 1);
                }
            }
        }

        as = AliceStart;
        ae = AliceEnd;
        bs = BobStart;
        be = BobEnd;




        return rec(AliceStart.length, BobStart.length, AliceEnd.length, BobEnd.length, dp);
	}
    final int MOD = 1000000007;

    private int rec(int a, int b, int c, int d, int[][][][] dp) {
        long res = dp[a][b][c][d];
        if (res == -1) {
            res = 0;
            if (a == 0 && b == 0 && c == 0 && d == 0) {
                res =  1;
            }
            // alice start == alice end
            if (a != 0 ) {

                if (c != 0 && as[a - 1] == ae[c - 1]) {
                    res += rec(a-1, b, c - 1, d, dp);
                }
                if (d != 0 && as[a - 1] == be[d - 1]) {
                    res += rec(a - 1, b, c, d - 1,dp);
                }

            }
            if (b != 0) {

                if (c != 0 && ae[c- 1] == bs[b - 1]) {
                    res += rec(a, b - 1, c - 1, d, dp);
                }
                if (d != 0 && be[d - 1] == bs[b - 1]) {
                    res += rec(a, b - 1, c, d - 1, dp);
                }


            }
            res = (res % MOD);

            dp[a][b][c][d] = (int)res;

        }
        return (int)res;
    }
}
