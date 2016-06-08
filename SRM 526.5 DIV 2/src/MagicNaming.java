import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MagicNaming {

    public static void main(String[] args) {
        MagicNaming mn = new MagicNaming();
        String magicName = "abcdefghijklmnopqrstuvwxyz";
        //String magicName = "aba";
        System.out.println(mn.maxReindeers(magicName));
    }



    public int maxReindeers(String magicName) {
        int n = magicName.length();
        int[][] dp = new int[n][n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n ; j++) {

                if (i == 0) {
                    dp[i][j] = 1;
                } else {

                    dp[i][j] = -100000000;
                    for (int k = 0; k < i ; k++) {
                        String a = magicName.substring(k, i);  /// a = [k.....i-1]
                        String b = magicName.substring(i, j + 1);  // b = [i....j];

                        if ((a + b).compareTo((b + a)) <= 0) {
                            dp[i][j] = Math.max(dp[i][j],  dp[k][i - 1] + 1);
                        }

                    }

                }

                if (j == n - 1) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }


        return ans;
    }


	public int maxReindeerss(String magicName) {

        magic(magicName, "", 0, 0);
        return res;
	}
    int res = 0;
    boolean isGood = false;
    private int magic(String magicName, String last, int curr, int num) {
        if (curr == magicName.length()) {
            res = Math.max(res, num);
            if (res == magicName.length()) {
                isGood  = true;
            }
            return -1;
        }

        for (int i = curr + 1; i <= magicName.length(); i++) {
            String check = magicName.substring(curr, i);
            if ((last + check).compareTo(check + last) <= 0 && !isGood) {
                 magic(magicName, check, i, num + 1);
            }
        }

        return -1;
    }
}
