package dp;

public class numWaysScore {
    public static void main(String[] args) {
        numWaysScore num = new numWaysScore();
        int[] w = {2,3,7};
        int s= 12;
        System.out.println(num.numWays(w,s));
    }
    public int numWays(int[] w, int s) {

        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int j : w) {
            for (int i = j; i <= s; i++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[s];
    }
}
