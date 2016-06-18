import java.util.HashMap;
import java.util.Map;

public class DuplicateWithinK {
    public boolean duplicateWithinK(int [] arr, int k) {
        if (arr == null || arr.length < 2) {
            return false;
        }
        Map<Integer, Boolean> intMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (intMap.containsKey(arr[i])) {
                return true;
            }
            intMap.put(arr[i], true);
            if (i - k >= 0) {
                intMap.remove(arr[i - k]);
            }
        }
        return false;
    }
}
