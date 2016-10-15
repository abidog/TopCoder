package Map;

import java.util.HashMap;
import java.util.Map;

public class LongestRange {
    public int longestRange(int[] num) {
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        int max = 0;
        for (int i : num) {
            if (start.containsKey(i + 1)) {
                start.put(i, start.get(i + 1) + 1);
            } else {
                start.put(i, 1);
            }

            if (end.containsKey(i - 1)) {
                end.put(i, end.get(i -1) + 1);
            } else {
                end.put(i, 1);
            }
            max = Math.max(max, Math.max(start.get(i), end.get(i)));
        }
        for (int i : num) {
            if (start.containsKey(i +1 ) && end.containsKey(i - 1)) {
                max = Math.max(max,start.get(i +1 ) + end.get(i - 1) + 1);
            }
        }
        return max;
    }
}

