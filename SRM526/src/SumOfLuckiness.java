public class SumOfLuckiness {

    int[][]c = new int[11][11];
    int digit = 10;
    long[] pow8 = new long[10];
    public long theSum(int A, int B) {
        pow8[0] = 1;
        for (int i = 1; i < 10; i++) {
            pow8[i] = pow8[i - 1] * 8;
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 1; j <= i ; j++) {
                if (i == j) {
                    c[i][j] = 1;
                }else {
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
                }
            }
        }
        return ways(B) - ways(A - 1);

    }

    private long ways(int b) {
        long res = 0;
        for (int r4 = 0; r4 < digit; r4++) {
            for (int r7 = 0; r7 < digit; r7++) {
                    res += (Math.abs(r4 - r7)) *calculate(r4, r7, b+1);
            }
        }
        return res;

    }

    private long calculate(int r4, int r7, int b) {


        String B = b + "";
        int n = B.length();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int n4 = r4;
            int n7 = r7;

            for (char d = '0'; d < B.charAt(i); d++) {

                if (d == '4') {
                    n4--;
                }
                if (d == '7') {
                    n7--;
                }

                int remain = n - i - 1;
                if (n4 >= 0 && n7 >= 0 && (remain - n4 - n7) >= 0) {
                    sum += c[remain][n4] * c[remain - n4][n7]* pow8[remain - n4 - n7];
                }


            }
            if (B.charAt(i) == '4') {
                n4--;
            }
            if (B.charAt(i) == '7') {
                n7--;
            }

        }
        return sum;

    }
}
