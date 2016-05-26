import java.util.*;

public class TheCowDivTwo {

    public static void main(String[] args) {
        TheCowDivTwo cow = new TheCowDivTwo();
        int n = 7;
        int k = 4;
        System.out.println(cow.find(7, 4));
    }

    /*
    *
    *Using k numbers that sums to s
    *
    * */

    public int find(int N, int K) {
        // dp[p][k][S]   p is the index, k is the element, S is sum
        int [][][] dp = new int[2][K + 1][N];
        int mod = 1000000007;
        for (int p = N; p >= 0 ; p--) {
            for (int k = 0; k <= K; k++) {
                for (int s = 0; s < N; s++) {

                    if (k == 0) {
                        if (s == 0) {
                            dp[p % 2][k][s] = 1;
                        } else {
                            dp[p % 2][k][s] = 0;
                        }
                    } else if(p == N){
                        dp[p % 2][k][s] = 0;
                    } else {
                        dp[p % 2][k][s] = (dp[(p + 1) % 2][k - 1][(s-p + N) % N] + dp[(p + 1) % 2][k][s]) % mod;
                    }

                }
            }

        }

        return dp[0][K][0];
    }



    public int countSets(List<Integer>list, int p, int k, int s) {
        if (k == 0) {
            if (s == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (p >= list.size()) {
            return 0;
        }

        return countSets(list, p + 1, k -1, (s - list.get(p) % list.size())) + countSets(list, p + 1, k, s);
    };








}
