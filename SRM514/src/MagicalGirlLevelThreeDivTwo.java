public class MagicalGirlLevelThreeDivTwo {
    public static void main(String[] args) {
        MagicalGirlLevelThreeDivTwo m = new MagicalGirlLevelThreeDivTwo();
        m.theCount(null, 0, 0, 0);
    }
    int K;
    String[] fir;
    long[] cnt;
    public int theCount(String[] first, int n, long lo, long hi) {
        long max = hi + 1;
        long[] count = new long[n];
        this.K = first.length;
        fir = first;
        cnt = count;
        for (int i = 0; i < first.length; i++) {
            count[i] = first[i].length();
        }
        for (int i = first.length; i < n ; i++) {
            for (int j = i - 1; j >= 0 ; j-= K) {
                count[i] += count[j];
                count[i] = Math.min(count[i], max);
            }
        }

        int res = 0;


        for (long p = lo; p <= hi ; p++) {
            res += (isDigit(n, p) == 1 ? 1 : 0);
        }
        return res;
    }

    private int isDigit(int i, long p) {

        if (i < K) {
            return fir[i].charAt((int)p);
        } else {

            long before = 0;
            int j = i - 1;
            while (p > before + cnt[j]) {
                before += cnt[j];
                j -= K;
            }
            return isDigit(j,p-before);
        }
    }
}
