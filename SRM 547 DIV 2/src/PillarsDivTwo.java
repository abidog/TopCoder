import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PillarsDivTwo {

	public double maximalLength(int[] height, int w) {

        double[][] dp = new double[height.length][101];
        for (int i = 0; i < height.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        double[] len = new double[100];
        for (int i = 0; i < 100; i++) {
            len[i] = Math.sqrt(w * w + i * i);
        }

        for (int i = 1; i < height.length  ; i++) {
            for (int j = 1; j <= height[i] ; j++) {
                for (int k = 1; k <= height[i - 1] ; k++) {
                    dp[i][j] = Math.max(dp[i - 1][k] + len[Math.abs(j - k)], dp[i][j]);
                }
            }
        }
        double max = 0;
        for (int i = 1; i <= height[height.length - 1]; i++) {
            max = Math.max(dp[height.length - 1][i], max);
        }
        return max;
    }


}
