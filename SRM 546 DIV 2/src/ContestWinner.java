import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ContestWinner {
	
	public int getWinner(int[] events) {
        int mx = 0;
        int wn = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int k : events) {
         if (!freq.containsKey(k)) {
             freq.put(k, 1);
         } else {
             freq.put(k, freq.get(k) + 1);
         }
           if (freq.get(k) > mx) {
               mx = freq.get(k);
               wn = k;
           }
        }

        return wn;
	}
}
