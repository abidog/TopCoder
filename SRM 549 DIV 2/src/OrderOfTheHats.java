import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class OrderOfTheHats {
	
	public int minChanged(String[] spellChart) {


        int[] dp = new int[1 << spellChart.length];

        Arrays.fill(dp, -1);

        int[] adj = new int[spellChart.length];

        for (int i = 0; i < spellChart.length; i++) {
            int mask = 0;
            for (int j = 0; j < spellChart[0].length(); j++) {
                    if (spellChart[i].charAt(j) == 'Y') {
                        mask |= (1 << j);
                    }
            }
            adj[i] = mask;

        }


        return F(dp, adj, 0, spellChart.length);
	}

    private int F(int[] dp, int[] adj, int mask, int n) {

        if (mask == ((1 << n) - 1)){
            return 0;
        }
        if (dp[mask] != -1) {
            return dp[mask];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < adj.length; i++) {
            if (((mask >> i) & 0x1) != 1) {

                int next = mask | (1 << i);
                    // reverse edges   next & (adj[i])
                res = Math.min(res, Integer.bitCount(next & adj[i]) + F(dp, adj, mask | (1 << i), n));

            }
        }
        dp[mask] = res;
        return dp[mask];
    }
}
