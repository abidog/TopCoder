import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class DengklekTryingToSleep {
	
	public int minDucks(int[] ducks) {

        Arrays.sort(ducks);
        int res = 0;
        if (ducks.length == 0) {
            return 0;
        }
        // 3 4 7 8
        for (int i = 0; i < ducks.length - 1; i++) {
            if (ducks[i] + 1 == ducks[i + 1]) {
                continue;
            } else {
                res += ducks[i + 1] - ducks[i] - 1;
            }
        }

        return res;
	}
}
