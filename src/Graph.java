import java.util.*;

public class Graph{

    class Node{
        int v;;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
   List<Node> [] adj;

    public Graph(int v) {
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }


    public void addEdge(int u, int v, int w) {
        adj[u].add(new Node(v, w));
    }


    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        // g is dag
        System.out.println(g.longestPath(g, 1));

    }

    private boolean longestPath(Graph g, int source) {

        int[] dist = new int[g.adj.length];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[source] = 0;
        Stack<Integer> order  = topOrder(g);

        while (!order.isEmpty())   {
            int visiting = order.pop();
            if (dist[visiting] != Integer.MIN_VALUE) {
                for (int i = 0; i < g.adj[visiting].size(); i++) {
                    if (g.adj[visiting].get(i).w + dist[visiting] > dist[g.adj[visiting].get(i).v]) {
                        dist[g.adj[visiting].get(i).v] = g.adj[visiting].get(i).w + dist[visiting];
                    }
                }
            }

        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(""+dist[i]);
        }
        return false;
    }

    private Stack<Integer> topOrder(Graph g) {

        Stack<Integer> order = new Stack<>();
        boolean[] visited = new boolean[g.adj.length];

        for (int i = 0; i < g.adj.length; i++) {
            if (!visited[i]) {
                topSort(visited, order, i, g);
            }
        }
        return order;
    }

    private void topSort(boolean[] visited, Stack<Integer> order, int v, Graph g) {


        visited[v] = true;
        for (int i = 0; i < g.adj[v].size(); i++) {
            if (!visited[g.adj[v].get(i).v]) {
                topSort(visited, order, g.adj[v].get(i).v, g);
            }
        }
        order.push(v);

    }



}