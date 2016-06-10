import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class HardProof {
	int n ;


    public static void main(String[] args) {
        HardProof hp = new HardProof();
        int[] D = new int[] {0,11,13,13,
                10,0,12,13,
                10,10,0,11,
                12,10,10,0};
        System.out.println(hp.minimumCost(D));
    }

	public int minimumCost(int[] D) {

        Set<Integer> set = new HashSet<>();
        for (int i : D){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        int k = 1;
        while (k * k < D.length) {
            k++;
        }
        this.n = k;
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < set.size(); i++) {

                while ( j < set.size() && !can(list.get(i), list.get(j), D)) {
                    j++;
                }
                if (j < set.size()) {
                    res = Math.min(res, list.get(j) - list.get(i));
                }




        }

        return res;
	}

    private boolean can(int x, int y, int[] d) {
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((d[i * n + j] >= x && d[i * n + j] <= y) || i == j) {
                        dp[i][j] = true;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dp[i][k]) {
                    for (int j = 0; j < n; j++) {
                        if (dp[k][j]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!dp[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
