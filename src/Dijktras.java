import java.util.Arrays;

public class Dijktras {


    public static void main(String[] args) {
        Dijktras dic = new Dijktras();
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

        dic.dijkstra(graph, 0);
    }

    public int[] dijkstra(int[][] graph, int src) {

        int n = graph.length;
        int[] dist = new int[n];
        boolean[] minTree = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        for (int count = 0; count < n - 1; count++) {


            int u = minDist(dist, minTree);
            if (u == -1) {
                break;
            }
            minTree[u] = true;

            for (int i = 0; i < n; i++) {
                if (graph[u][i] != 0 && dist[u] != Integer.MAX_VALUE && dist[i] > dist[u] + graph[u][i]) {
                    dist[i] = dist[u] + graph[u][i];
                }
            }
        }

       for (int i = 0; i < n; i++) {
           System.out.println(dist[i]);
       }

        return dist;

    }

    private int minDist(int[] dist, boolean[] minTree) {


        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i]  < min && !minTree[i]) {
                index = i;
                min = dist[i];
            }
        }
        return index;
    }


}
