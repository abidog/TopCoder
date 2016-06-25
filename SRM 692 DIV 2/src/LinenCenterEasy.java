import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class LinenCenterEasy {
	long[][][] dp = new long[51][51][51];
    boolean[] badprefix = new boolean[51];
    int[][] prefixBecome = new int[51][27];
    int MOD = 1000000009;
    int k = 0;
    int L;
	public int countStrings(String S, int N, int K) {
        k = K;
        L = S.length();
        for (int i = 0; i < S.length(); i++) {
            String check = (S.substring(0, i) + S).substring(0, S.length());
            if (check.equals(S)) {
             badprefix[i] = true;
            }
            if (i == 0) {
                badprefix[i] = false;
            }


            for (char j = 'a'; j <= 'z'; j++) {
                prefixBecome[i][j - 'a'] = 0;
                String t = S.substring(0, i) +j;
                for (int len = t.length(); len >= 0; len--) {
                    if (S.substring(0, len).equals(t.substring(t.length() - len))) {
                        prefixBecome[i][j - 'a'] = len;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return (int) (rec(0,N,K) %MOD);
	}

    private long rec(int p, int n, int k) {
        if (dp[p][n][k] != -1) {
            return dp[p][n][k];
        }
        if (p == L) {
            dp[p][n][k] = 0;
            return 0;
        }
        long res = 0;
        if (k == 0) {
            res = 1;
        }
        if (n > 0) {
            for (char a = 'a'; a <= 'z'; a++) {
                res += rec(prefixBecome[p][(int)(a - 'a')], n- 1, k) % MOD;
            }
        }

        if (k > 0 && !badprefix[p]) {
            res += rec(0, n, k - 1) %MOD;
        }
        dp[p][n][k] = res % MOD;
        return res %MOD;
    }
}
