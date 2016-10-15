package dp;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

public class KnapSack {
    public int knapsack(int[] w, int[] p, int max) {

        int[][] dp = new int[w.length][max  + 1];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= max; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (w[i] <= j) {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + p[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printAnswer(dp, w);


        return dp[w.length - 1][max];
    }

    private void printAnswer(int[][] dp, int[] w) {
        int r = dp.length - 1;
        int c = dp[0].length - 1;

        for (int i = r; i > 0 && c >= 0; i--) {
            if (dp[i][c] == dp[i - 1][c]) {
                // itemp i is not selected
                c--;
            } else {
                // item i is selected then c becomes
                System.out.println(w[i]);
                c -= w[i];
            }
        }
    }

}
