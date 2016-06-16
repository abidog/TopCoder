import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ColorfulCupcakesDivTwo {

    public static void main(String[] args) {
        ColorfulCupcakesDivTwo cup = new ColorfulCupcakesDivTwo();
        String cupcakes = "BAACBABBABBCCCBCCCACBCCABBAAAAACBACCBBBB";
        System.out.println(cup.countArrangements(cupcakes));
    }
    int mod = 1000000007;
    public int countArrangements(String cupcakes) {

        int a = 0;
        int b = 0;
        int c = 0;
        for (char cup : cupcakes.toCharArray()) {
            if (cup == 'A') {
                a++;
            } else if (cup == 'B') {
                b++;
            } else {
                c++;
            }
        }
        int[][][][][] dp = new int[a + 1][b + 1][c + 1][3][3];
        for (int i = 0; i < a + 1; i++) {
            for (int j = 0; j < b + 1; j++) {
                for (int k = 0; k < c + 1; k++) {
                    for (int l = 0; l < 3; l++) {
                        Arrays.fill(dp[i][j][k][l], -1);
                    }
                }
            }
        }

        return solve(a, b, c, -1, 0, -1, cupcakes.length(), dp) % mod;
	}

    private int solve(int a, int b, int c, int cur, int index, int first, int max, int[][][][][]dp) {



        if (index == max && first != cur) {
            return 1;
        }
        if (index >= max) {
            return 0;
        }

        if (first != -1 && cur != -1 && dp[a][b][c][first][cur] != -1) {
            return dp[a][b][c][first][cur] % mod;
        }

        int res = 0;
        if (a > 0 && 0 != cur) {
            if (first == -1) {
                res += solve(a - 1, b, c, 0, index + 1, 0, max, dp) % mod;
                res %= mod;
            } else {
                res += solve(a - 1, b, c, 0, index + 1, first, max, dp) % mod;
                res %= mod;
            }
        }

        if (b > 0 && 1 != cur) {
            if (first == -1) {
                res += solve(a, b - 1, c, 1, index + 1, 1, max, dp) % mod;
                res %= mod;
            } else {
                res += solve(a, b - 1, c, 1, index + 1, first, max, dp) % mod;
                res %= mod;
            }
        }

        if (c > 0 && 2 != cur) {
            if (first == -1) {
                res += solve(a, b, c - 1, 2, index + 1, 2, max, dp) % mod;
                res %= mod;
            } else {
                res += solve(a, b, c - 1, 2, index + 1, first, max,dp) %mod;
                res %= mod;
            }
        }
        if (first !=-1 && cur != -1) {
            dp[a][b][c][first][cur] = res % mod;
            dp[a][b][c][first][cur] %= mod;
        }

        return res %= mod;
    }
}
