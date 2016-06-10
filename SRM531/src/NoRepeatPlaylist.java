import java.util.Arrays;

public class NoRepeatPlaylist {


    public static void main(String[] args) {
        NoRepeatPlaylist np = new NoRepeatPlaylist();
        System.out.println(np.numPlaylists(2,0,3));
    }
    int mod = 1000000007;
    public int numPlaylists(int N, int M, int P) {
        // p spots
        long res = 1;
        int[][][] dp = new int[101][101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(dp[i][j], - 1);
            }
        }

        res = solve(0, 0, N, M, P, dp);

        return (int)(res % mod);
    }

    private long solve(int position, int xs, int ys, int m, int p, int[][][] dp ) {
        if (position == p) {
            return ys == 0 ? 1 : 0;
        }
        if (dp[position][xs][ys] != -1) {
            return dp[position][xs][ys];
        }
        long res = 0;
        if (ys > 0) {
            res += ys * solve(position+ 1, xs + 1, ys - 1, m, p, dp);
            res %= mod;
        }
        if (xs > m) {
            res += (xs - m) * solve(position+1, xs, ys, m,p, dp);
        }
        return  dp[position][xs][ys] = (int)(res % mod);
    }
}
