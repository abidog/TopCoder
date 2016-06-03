import java.util.Arrays;

public class FiveHundredEleven {


    public static void main(String[] args) {
        FiveHundredEleven fv = new FiveHundredEleven();
        int[]card = {461, 443, 177, 366, 499, 384, 125, 499, 372, 374, 39, 285, 203, 33, 429, 469, 458, 163, 154, 438, 508};

        System.out.println(fv.theWinner(card));
    }

    public String theWinner(int[] cards) {
        int[][] dp = new int[512][51];
        for (int i = 0; i < 512; i++) {
            Arrays.fill(dp[i], -1);
        }
        if (isWin(cards, dp, 0, 0) != 0) {
            return "Fox Ciel";
        } else {
            return "Toastman";
        }

    }

    private int isWin(int[] cards, int[][] dp, int memo, int played) {

        if (memo == 511) {
            return 1;
        }
        if (played == cards.length) {
            return 0;
        }
        if (dp[memo][played] != -1) {
            return dp[memo][played];
        } else {
            int result = 0;
            int cnt = 0;
            for (int i = 0; i < cards.length; i++) {
                if ((memo | cards[i]) == memo) {
                    cnt+=1;
                }
            }
            if (cnt > played && isWin(cards, dp, memo, played + 1) == 0) {
                result = 1;


            }
            for (int i = 0; i < cards.length; i++) {
                if ((cards[i] | memo) != memo && isWin(cards, dp, memo | cards[i], played+1) == 0) {
                    result = 1;
                }
            }

            dp[memo][played] = result;

        }


        return dp[memo][played];


    }


}
