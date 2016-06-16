import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class KingdomAndDucks {
	
	public int minDucks(int[] duckTypes) {

        Map<Integer, Integer> duckMap = new HashMap<>();
        int unique = 0;
        int max = 0;
        for (int i : duckTypes) {
            if (!duckMap.containsKey(i)) {
             duckMap.put(i, 1);
                unique++;
            } else {
                duckMap.put(i, duckMap.get(i) + 1);
            }
            max = Math.max(max, duckMap.get(i));
        }


        return max * unique;
	}
}
