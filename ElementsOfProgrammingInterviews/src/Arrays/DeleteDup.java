package Arrays;

import java.util.HashMap;
import java.util.Map;


public class DeleteDup {
    public int[] deleteDup(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int end = arr.length;
        Map<Integer, Boolean> dup = new HashMap<>();
        Map<Integer, Boolean> isDup = new HashMap<>();
        for (int i = 0; i < end; i++) {
            if (!dup.containsKey(arr[i])) {
                dup.put(arr[i], true);
            } else {

                for (int start = i; start < end - 1; start++) {
                    arr[start] = arr[start + 1];
                }
                i--;
                end--;

            }
        }
        int[] result = new int[end];
        for (int i = 0; i < end; i++) {
            result[i] = arr[i];
        }

        return result;
    }
}