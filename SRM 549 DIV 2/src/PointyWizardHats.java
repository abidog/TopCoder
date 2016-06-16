import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PointyWizardHats {

    private boolean canWePlace(double h1, double r1, double h2, double r2) {
        if (r2 <= r1) {
            return false;
        }
        double newHe = h2/r2 * r1;
        if (newHe >= h1 || (Math.abs(newHe - h1)) < 1e-6) {
            return false;
        }
        return true;

    }

	public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius) {


        int[][] graph = new int[topHeight.length + bottomHeight.length][topHeight.length + bottomHeight.length];

        for (int i = 0; i < topHeight.length; i++) {

            for (int j = 0; j < bottomHeight.length; j++) {
                if (canWePlace(topHeight[i], topRadius[i], bottomHeight[j], bottomRadius[j])) {
                    graph[i][topHeight.length + j] = 1;
                   // graph[j +i][i] = 1;
                }
            }
        }



        return bpm(graph);
	}





    private int bpm(int[][] graph) {

        int max = 0;
        int[] match = new int[graph.length];
        Arrays.fill(match, -1);
        for (int i = 0; i < graph.length; i++) {
            boolean[] v = new boolean[graph.length];
            if (dfs(v, i, match, graph)) {
                max++;
            }
        }


        return max;

    }

    private boolean dfs(boolean[] v, int job, int[] match, int[][] g) {

        if (v[job]) {
            return false;
        }
        v[job] = true;

        for (int j = 0; j < g.length; j++) {
           if (g[job][j] > 0 && !v[j])  {
               if (match[j] == -1 || dfs(v, match[j], match, g)) {
                   match[j] = job;
                   return true;
               }
           }
        }

        return false;
    }
}
