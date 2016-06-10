import java.util.*;

public class KingdomReorganization {

    class DisjointSet{
        int[] p;
        public DisjointSet(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        public int find(int x) {

            if (p[x] == x) {
                return x;
            }
            // path compression
            p[x] = find(p[x]);
            return p[x];
        }

        private boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }
            p[px] = py;
            return true;
        }
    }
    class Edge{
        int x;
        int y;
        int w;
        public Edge(int v1, int v2, int w) {
            this.x = v1;
            this.y = v2;
            this.w = w;
        }
    }


    public static void main(String[] args) {
        KingdomReorganization ko = new KingdomReorganization();
        String[] kingdom = {"011",
                            "101",
                            "110"};
        String[] build = {"ABD",
                          "BAC",
                          "DCA"};

        String[] des =  {"ABD",
                         "BAC",
                         "DCA"};

        System.out.println(ko.getCost(kingdom, build, des));
    }

    public int getCost(String[] kingdom, String[] build, String[] destroy) {


        int n = build.length;
        int m = build[0].length();
        int[][] b = new int[n][m];
        int[][] d = new int[n][m];
        int total = 0;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                b[i][j] = build[i].charAt(j) >= 'a' ? (26 + build[i].charAt(j) - 97) : build[i].charAt(j) - 65;
                b[j][i] = b[i][j];
                d[i][j] = destroy[i].charAt(j) >= 'a' ? (26 + destroy[i].charAt(j) - 97) : destroy[i].charAt(j) - 65;
                d[j][i] = d[i][j];
                if (i != j && kingdom[i].charAt(j) == '1') {
                    total += d[i][j];
                    b[i][j] = -d[i][j];
                    b[j][i] = -d[i][j];
                }
                if (i != j) {
                    edges.add(new Edge(i,j,b[i][j]));
                }
            }
        }
        Comparator<Edge> edgeComp = new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return e1.w - e2.w;
            }
        };

        Collections.sort(edges, edgeComp);

        DisjointSet ds = new DisjointSet(n);

        for (Edge e : edges) {

            int px = ds.find(e.x);
            int py = ds.find(e.y);
            if (px != py) {
                ds.union(e.x, e.y);
                total += b[e.x][e.y];
                /*
                if (kingdom[e.x].charAt(e.y) == '1') {
                    total -= d[e.x][e.y];
                } else {

                }
                */
            }

        }

        return total;


    }
}
