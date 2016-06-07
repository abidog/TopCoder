public class SmallBricks31 {
    long mod = 1000000007;
    public static void main(String[] args) {
        SmallBricks31 sm = new SmallBricks31();
        System.out.println(sm.countWays(3,1));
    }

    long[][] memo = new long[11][1 << 10];
    int w ;
    public int countWays(int w, int h) {
        this.w = w;



        return  F(h, (1 << w)-1);

    }

    private int F(int h, int prev) {
        if (memo[h][prev] == -1) {
            if (h == 0) {
                memo[h][prev] = 1;
            } else {
                memo[h][prev] = backTrack(h, prev, 0, 0);
            }

        }

        return (int)(memo[h][prev] % mod);
    }

    private long backTrack(int h, int prev, int x, int current) {
        if (x == w) {
            F(h - 1, current);
        }

            long res = 0;
            // place nothing
            res += backTrack(h - 1, prev, x + 1, current);

            // place one brick
            boolean b1 = ((prev ) & (1 << x)) > 0;

            if (b1) {
                res += backTrack(h, prev, x + 1, current | (1 << x));
            }

            // place 1x2 brick
            if (b1 && ((prev & (1 << (x + 1))) > 0)) {
                res += backTrack(h, prev, x + 2, current | (1 << x) | (1 << (x + 1)));
            }

            // place 1x3 brick
            if (b1 && ((prev & (1 << (x + 2))) > 0)) {
                res += backTrack(h, prev, x + 3, current | (1 << x) | (1 << (x + 1)) | (1 <<(x + 2)));
            }
            memo[h][prev] = res;


        return  memo[h][prev] % mod;
    }


}
