package Arrays;

public class MostKTransaction{
    public int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[k + 1][prices.length + 1];
        int result = 0;
        for (int t = 1; t <= k; t++) {
            int maxTemp = dp[t - 1][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxTemp);
                maxTemp = Math.max(maxTemp, dp[t - 1][i] - prices[i]);
                result = Math.max(result, dp[t][i]);
            }
        }
        return result;
    }
}

