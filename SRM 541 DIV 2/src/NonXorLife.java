import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class NonXorLife {
	
	public int countAliveCells(String[] field, int K) {

        int off = 1500;
        int[][] dist = new int[3001][3001];
        for (int i = 0; i < 3001; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length(); j++) {
                if (field[i].charAt(j) == 'o'){
                    dist[off + i][off + j] = 0;
                    q.add(new int[]{off+i, off+j});
                }
            }
        }
        int[][] m = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
          int[] v = q.remove(0);
            int d = dist[v[0]][v[1]];
            for (int[] mo :m) {
                int dx = v[0] + mo[0];
                int dy = v[1] + mo[1];
                if (dx >= 0 && dy >= 0 && dx < 3001 && dy < 3001 && d < K) {
                    if (dist[dx][dy] > d + 1) {
                        dist[dx][dy] = d + 1;
                        q.add(new int[]{dx,dy});
                    }
                }
            }

        }
        int count = 0;
        for (int i = 0; i < 3001; i++) {
            for (int j = 0; j < 3001; j++) {
                if (dist[i][j] <= K) {
                    count++;
                }
            }
        }


        return count;
	}
}
