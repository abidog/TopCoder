
import java.util.*;

public class CoinReversing {


    public double expectedHeads(int N, int[] a) {
        double q = 1.0;

        for (int i = 0; i < a.length; i++) {
            double p = 1.0 * a[i] / 1.0 * N;
            // probability of odd coin is picked with p probabiliy, and probabiliy of even coin is not picked.
            q = (1 - q) * p + q * (1 - p);


        }
        return q * N;
    }


}
