package primitivetypes;

public class DivideTwo {

    public int divide(int x, int y) {
        if (y > x) {
            return 0;
        }
        int k = 1;
        int res = 0;
        while (x >= y) {

            while ( (y << (k)) > (y << (k - 1)) && (x - (y << (k))) >= 0 ) {
                k++;
            }
            x -=  (y << (k - 1));
            res += (1 << (k - 1));
            k = 1;
        }
        return res;
    }

}
