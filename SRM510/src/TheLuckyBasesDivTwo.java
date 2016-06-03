public class TheLuckyBasesDivTwo {
    public long find(long n) {

        if (n == 4 || n == 7) {
            return -1;
        }

        long res = count2D(n);
        res += count3D(n);

        return res;
    }

    private long count3D(long n) {
        long res = 0;

        for (int b = 2; b < n ; b++) {

            // ax + b = n
            int cDigit = 0;
            long x = n;
            boolean luck = true;
            while (x > 0) {
                luck = luck && (x % b == 4 || x % b == 7);
                cDigit++;
                x /=10;
            }
            if (cDigit <= 2) {
                break;
            }
            if (luck) {
                res++;
            }

        }


        return 0;
    }

    public boolean canWePair(long a, long b, long n) {
        // ax + b = n
        long ax = n - b;
        if (ax % a == 0) {
            long x = ax/a;
            return x > a && x > b;
        }
        return false;
    }

    private long count2D(long n) {
        long res = 0;
        for (int a = 4; a <= 7 ; a+=3) {
            for (int b = 4; b <= 7 ; b+= 3) {
                if (canWePair(a, b, n)) {
                    res++;
                }
            }
        }
        return res;
    }
}
