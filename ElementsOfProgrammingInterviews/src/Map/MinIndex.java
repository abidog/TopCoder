package Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinIndex{
    public int minIndex(int[] a, int[] q) {
        Map<Integer, Integer> mapQ = new HashMap<>();
        int[] dp = new int[q.length];
        int[] l = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            mapQ.put(q[i], i);
        }
        int min = a.length - 1;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < a.length; i++) {
            if (mapQ.containsKey(a[i])) {
                if (mapQ.get(a[i]) == 0) {
                    dp[0] = 1;
                } else if (dp[mapQ.get(a[i]) - 1] != Integer.MAX_VALUE) {
                    dp[mapQ.get(a[i])] = i - l[mapQ.get(a[i]) - 1] + dp[mapQ.get(a[i]) - 1];
                }
                l[mapQ.get(a[i])] = i;

                if (mapQ.get(a[i]) == q.length - 1 && dp[mapQ.get(a[i])] < min ) {
                    min = dp[mapQ.get(a[i])];
                }

            }
        }
        return min;
    }
}

