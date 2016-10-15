package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MilkChoose {
    // 230 -240
    // 290 - 310
    // 500 - 515
    // 2100 - 2300

    public void getBottle() {
        int[][] bottle = {{230,240},{290,310},{500, 515}};
        int[][] dp = new int[2301][2301];
        Set<Integer> cache = new HashSet<>();
        backtrack(bottle, 0, 0, "", dp );
        cachedBacktracking(bottle, 2100, 2300, cache);
    }

    private void backtrack(int[][] bottle, int min, int max, String current, int[][] dp) {
        if (min >= 2100 && max <= 2300 && dp[min][max] == 0) {
            dp[min][max] = 1;
            System.out.println(min+" "+max+" "+current);
        }
        if (min > 2300 || max > 2300) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            backtrack(bottle, min + bottle[i][0], max + bottle[i][1], current+" "+i, dp);
        }
    }

    private boolean cachedBacktracking(int[][] bottle, int min, int max, Set<Integer> cache) {

        if (min < 0 || max < 0 ) {
            return false;
        }
        int key = min * 2100 + max;
        if (cache.contains(key)) {
            return false;
        }


        for (int i = 0; i < 3; i++) {
            if ((min <= bottle[i][0] && max >= bottle[i][1]) || cachedBacktracking(bottle, min - bottle[i][0], max - bottle[i][1], cache)) {
                return true;
            }
        }
        cache.add(min * 2100 + max);
        return false;
    }
}
