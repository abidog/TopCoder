import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class KingdomAndTrees {
	
	public int minLevel(int[] heights) {


        int l = 0;
        int r = 1000000000;

        while (l < r) {
            int m = l + (r - l) /2;

            if (check(heights, m)) {
                r = m;
            } else {
                l = m + 1;
            }


        }
        return r;
	}

    private boolean check(int[] heights, int m) {

       int prev = 0;
        for (int i = 0; i < heights.length; i++) {

            if (heights[i] + m > prev) {
                prev = Math.max(prev + 1, heights[i] - m);
                continue;
            }
            return false;

        }


        return true;
    }
}
