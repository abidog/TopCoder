public class LongestCommonSubSec {

    public static void main(String[] args) {
        String selam = "selam";
        String sel2 = "eltyem";
        LongestCommonSubSec lcm = new LongestCommonSubSec();
        System.out.println(lcm.lcs(selam, sel2));
    }
    public int lcs(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length() ; i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }
        return dp[s1.length()][s2.length()];

    }

}
