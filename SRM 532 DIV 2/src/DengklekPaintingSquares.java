public class DengklekPaintingSquares {
    int[] pow3;
    int[][][] set; // set[i][j][k], set i such that jth bit is k
    int[][] get; // get[j][k], get the kth bit of j.
    int max;

    private void preCompute() {
        this.max = 9;
        pow3 = new int[max  + 1];
        pow3[0] = 1;

        for (int i = 1; i < max + 1; i++) {
            pow3[i] = pow3[i - 1] * 3;
        }
        get = new int[pow3[max]][max + 1];
        for (int i = 0; i < pow3[max]; i++) {
            for (int k = 0; k < max + 1; k++) {
                // get the kth bit of i
                get[i][k] = i/pow3[k] % 3;
            }
        }
        set = new int[pow3[max]][max][3];

        for (int i = 0; i < pow3[max]; i++) {
            for (int j = 0; j < max + 1; j++) {
                for (int k = 0; k < 3; k++) {
                    set[i][j][k] = i + (k - get[i][j]) * pow3[j];
                }
            }
        }

    }
    int mod = 1000000007;
    public int numSolutions(int N, int M) {
        preCompute();
        int[][][] dp = new int[N + 1][M + 1][pow3[M]];


        int start2 = 0;
        for (int i = 0; i < M; i++) {
            start2 = set[start2][i][2];
        }
        dp[0][0][start2] = 1;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < pow3[M]; k++) {

                    // top square is not 1, it can be zero or not colored. so leave it as it is correct state
                    if (get[k][j] != 1) {
                        dp[i][j + 1][k] += dp[i][j][k];
                        dp[i][j + 1][k] %= mod;
                    }
                    //
                    // top square is not 0, 0 is correct state, as it will change it will be a wrong state.
                    // color this square
                    if (get[k][j] != 0) {
                        int newK = k;
                        newK = set[newK][j][0];

                        if (get[newK][j] != 2) {
                            newK = set[k][j][1 - get[newK][j]];
                        }
                        if (j > 0 && get[newK][j - 1] != 2) {
                            newK = set[newK][j - 1][1 - get[newK][j - 1]];
                            newK = set[newK][j][1 - get[newK][j]];
                        }

                        dp[i][j + 1][newK] += dp[i][j][k];
                        dp[i][j + 1][newK] %= mod;
                    }


                }
            }
            for (int j = 0; j < pow3[M] ; j++) {
                dp[i + 1][0][j] = dp[i][M][j];
            }
        }
        int res = 0;
        for (int k = 0; k < pow3[M]; k++)
        {
            boolean valid = true;
            for (int j = 0; j < M; j++)
                if (get[k][j] == 1)
                    valid = false;
            if (valid)
                res = (res + dp[N][0][k]) % mod;
        }
        return res;
    }

}
