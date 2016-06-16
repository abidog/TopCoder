import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ColorfulChocolates {

    public static void main(String[] args) {
        String chocolates = "ABBABABBA";
        int maxSwaps = 4;
        new ColorfulChocolates().maximumSpread(chocolates, maxSwaps);
    }

    public int maximumSpread(String chocolates, int maxSwaps) {

        int max = 0;
        for (int center = 0; center < chocolates.length(); center++) {

            int swap = maxSwaps;
            int step = 1;
            char color = chocolates.charAt(center);
            int iter = 1;
            int li = center - 1;
            int ri = center + 1;
            while (center - step >= 0 && center + step < chocolates.length()) {
                char left = chocolates.charAt(center - step);
                char right = chocolates.charAt(center + step);
                if (left == color && swap >= (li - (center - step))) {
                    iter++;
                    swap -= (li - (center - step));
                    li--;
                }
                if (right == color && swap >= ((center + step) - ri)) {
                    iter++;
                    swap -= ((center + step) - ri);
                    ri++;
                }
                step++;
            }
            // left side
            for (int i  = center - step; i >= 0; i--) {
                char left = chocolates.charAt(i);
                if (left == color && swap >= (li - i)) {
                    swap -= li - i;
                    li--;
                    iter++;
                }
            }

            // right side
            for (int i = center + step; i < chocolates.length() ; i++) {
                char right = chocolates.charAt(i);
                if (right == color && swap >= (i - ri)) {
                    swap -= i - ri;
                    ri++;
                    iter++;
                }
            }
            max = Math.max(max, iter);

        }

        return max;
	}
}
