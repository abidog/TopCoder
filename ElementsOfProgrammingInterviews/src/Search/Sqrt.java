package Search;

public class Sqrt {
    public int sqrt(int num) {

        int l = 0;
        int r = num;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (m * m >= num) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

}
