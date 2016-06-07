public class CountingSeries {

    public static void main(String[] args) {
        CountingSeries cs = new CountingSeries();


        System.out.println(cs.countThem(138496014408l, 788102, 9530, 159, 955369882363l));
    }

    public long countThem(long a, long b, long c, long d, long upperBound) {
        // a + b*x
        // c * d^y
        long res = 0;
        // multiple of b
        long totalArit = (upperBound - a) / b + 1;
        // power of d in upperBound /d


        if (d == 1) {
            if (c <= upperBound) {
                res++;
            }
        } else {
            for (int power = 0; power < 1000 ; power++) {
                // c * d^y
                long check = (long)(c * Math.pow(d, power));
                if (check > 0 && check <= upperBound) {


                    if (check >= a && (check - a) % b == 0) {

                    } else {
                        res++;
                    }

                }
            }
        }




        return res + totalArit;

    }
    private  boolean isGeo(long c, long d, long candid) {
        candid = candid/c;
        while (candid % d == 0) {
            candid /= d;
        }
        return candid == 1;
    }
    private  boolean isPro(long a, long b, long candid) {
        if (candid <= a) {
            return false;
        }
        candid -= a;
        while (candid % b == 0) {
            candid /= b;
        }
        return candid == 1;
    }
}
