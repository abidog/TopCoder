import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MoreThanNbyK{
    public Set<Integer> findElementNbyK(int[] arrInt, int k) {
        int freq = arrInt.length / k;
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int i : arrInt) {
            if (intMap.containsKey(i)) {
                intMap.put(i, intMap.get(i) + 1);
            } else {
                intMap.put(i, 1);
            }
        }
        for (int key : intMap.keySet()) {
            if (intMap.get(key) >= freq) {
                result.add(key);
            }
        }
        return result;
    }
}
