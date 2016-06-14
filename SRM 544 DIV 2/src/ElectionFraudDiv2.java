import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ElectionFraudDiv2 {
	
	public String IsFraudulent(int[] percentages) {

        double sum = 0;
        int canBeRoundDown = 0;

        for (double d : percentages) {
            if (d >= 1) {
                canBeRoundDown++;
            }
            sum += d;
        }
        if (sum == 100) {
            return "NO";
        }
        if (sum > 100) {
            if (sum - canBeRoundDown * 0.5 <= 100) {
                return "NO";
            }
        }
        if (sum < 100) {
            if (sum + percentages.length* 0.49999999 >= 100) {
                return "NO";
            }
        }

        return "YES";
	}
}
