import java.util.HashMap;
import java.util.Map;

public class SubArrayZerosOne {

    public int maxSubArray(int[] arr) {
        int[] left = new int[arr.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        left[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            left[i] = left[i - 1] + (arr[i - 1] == 0 ? -1 : 1);
        }
        int max = 0;
        for (int i = 0; i < left.length; i++) {
            if (map.containsKey(left[i])) {
                max = Math.max(max, i - map.get(left[i]));
            } else {
                map.put(left[i], i);
            }

        }
        return max;
    }

}
