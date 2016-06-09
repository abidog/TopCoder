import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class YetAnotherTwoTeamsProblem {

    public static void main(String[] args) {
        int[] skill = new int[] {1, 1, 1, 1, 1};

    }

    public long count(int[] skill) {

        int max = 1560000;
        Arrays.sort(skill);
        long sum = 0;
        for (long i : skill) {
            sum+= i;
        }
        long[] dp = new long[max];
        for (int t = 0; t <= skill.length; t++) {
            for (int s = 0; s < max; s++) {
                if (t == 0) {
                    if (s > (sum / 2.0)) {
                        dp[s] = 1;
                    }
                } else {

                    if (s < sum / 2.0) {
                        dp[s] += dp[s + skill[t - 1]];
                    }

                }
            }
        }
        return dp[0];
	}
}
