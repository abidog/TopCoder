public class DivideAndShift {

    public static void main(String[] args) {
        DivideAndShift ds = new DivideAndShift();
        System.out.println(ds.getLeast(56, 14));
    }

    public int getLeast(int N, int M) {

        int res = N;
        M--;
        for (int y = 1; y <= N ; y++) {

            if (N % y == 0) {
                int x = N / y;
                int c = 0;
                for (int p = 2; p <= x / p ; p++) {
                    while (x %p == 0) {
                        x /= p;
                        c++;
                    }
                }
                c += ((x != 1) ? 1 : 0);


                int s = Math.min(M % y, y - M % y);

                res = Math.min(c + s, res);


            }

        }
        return  res;
    }
}
