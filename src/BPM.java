
import java.util.*;


public class BPM {

    public static void main(String[] args) {
        int bpGraph[][] = {  {0, 1, 1, 0, 0, 0},
                             {1, 0, 0, 1, 0, 0},
                             {0, 0, 1, 0, 0, 0},
                             {0, 0, 1, 1, 0, 0},
                             {0, 0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 0, 1}
        };

        System.out.println(new BPM().bpm(bpGraph));
    }

    public int bpm(int [][] jobToApp) {


        int max = 0;
        boolean[] v = new boolean[jobToApp.length];
        int[] match = new int[jobToApp[0].length];
        Arrays.fill(match, -1);
        for (int i = 0; i < jobToApp.length; i++) {
            Arrays.fill(v, false);
          if (dfs(jobToApp, i, match, v)) {
              max++;
          }
        }
        return max;
    }

    private boolean dfs(int[][] jobToApp, int job, int[] match, boolean[] v) {
        if (v[job]) {
            return false;
        }
        v[job] = true;
        for (int i = 0; i < jobToApp[0].length; i++) {
            if (jobToApp[job][i] > 0 && (match[i] == -1 || dfs(jobToApp, match[i], match, v))) {
                match[i] = job;
                return true;
            }
        }

        return false;
    }

}
