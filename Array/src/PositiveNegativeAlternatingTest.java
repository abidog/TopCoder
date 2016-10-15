import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
public class PositiveNegativeAlternatingTest {
    @Test
    public void positiveNegAlternate() {
        PositiveNegativeAlternating positiveNegativeAlternating = new PositiveNegativeAlternating();
        int[] arr = {1,-2,4,-2,-3,-6,2,4};
        positiveNegativeAlternating.alternate(arr);

    }

    public int mice(List<Integer> a, List<Integer> b) {
        if (b.size() < a.size()) {
            return -1;
        }

        Set<Integer> timee = new HashSet<>();

        for (int i : a) {
            for (int j : b) {
                timee.add(Math.abs(j - i));
            }
        }
        List<Integer> times = new ArrayList<>(timee);
        System.gc();
        Collections.sort(times);

        int l = 0;
        int h = times.size() - 1;
        int n = a.size();

        while (l < h) {

            int m = l + (h - l) / 2;

            int time = times.get(m);

            int[][] g = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Math.abs(a.get(i) - b.get(j)) <= time) {
                        g[i][j] = 1;
                    }
                }
            }


            int numberMouse = bpm(g);

            if (numberMouse == n) {
                h = m;
            } else {
                l = m + 1;
            }

        }
        return times.get(h);
    }


    public int bpm(int[][] g) {
        int n = g.length;
        int[] match = new int[n];
        Arrays.fill(match, -1);

        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean[] v = new boolean[n];

            if (dfs(match, v, g, i)) {
                count++;
            }

        }
        return count;

    }
    private boolean dfs(int[] match, boolean[] v, int[][] g, int m) {

        if (v[m]) {
            return false;
        }
        v[m] = true;

        for (int i = 0; i < v.length; i++) {
            if (g[m][i] == 1) {
                if ((match[i] == -1) || dfs(match, v, g, match[i])) {
                    match[i] = m;
                    return true;
                }
            }
        }

        return false;

    }

}
