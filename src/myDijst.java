import java.util.Arrays;

public class myDijst {

    public static void main(String[] args) {
        myDijst dic = new myDijst();
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dic.dijstraMe(graph, 0);
    }

    public int[] dijstraMe(int[][] g, int src) {


        int n = g.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int index = getMin(dist, visited);

            if (index == -1) {
                break;
            }
            visited[index] = true;
            for (int j = 0; j < n; j++) {
                if (g[index][j] != 0 && dist[index] != Integer.MAX_VALUE && dist[index] + g[index][j] < dist[j] ) {
                    dist[j] = dist[index] + g[index][j];
                }
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.println(dist[i]);
        }
        return dist;

    }

    public int getMin(int[] dist, boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < dist.length; i++) {

            if (!visited[i] && dist[i] < min) {
                index = i;
                min = dist[i];
            }

        }
        return index;

    }

}
