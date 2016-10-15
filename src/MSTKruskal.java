import java.io.*;
import java.util.*;

public class MSTKruskal {
    class Node{
        int data;
        Node parent;
        int rank;
        public Node(int d ) {
            this.data = d;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    public void makeSet(int d) {
        Node n = new Node(d);
        n.parent = n;
        n.rank = 0;
        map.put(d, n);

    }
    public Node findSet(Node node) {
        Node p = node.parent;
        if (p.data == node.data) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }
    public Node findSet(int i1) {
        return findSet(map.get(i1));
    }


    public boolean makeUnion(int n1, int n2) {
        Node node1 = map.get(n1);
        Node node2 = map.get(n2);
        Node p1 = findSet(node1);
        Node p2 = findSet(node2);

        if (p1.data == p2.data) {
            return false;
        }
        if (p1.rank >= p2.rank) {
            p1.rank = p1.rank == p2.rank ? p1.rank + 1 : p2.rank;
            p2.parent = p1;
        } else {
            p1.parent = p2;
        }

        return true;


    }

    class Edge{
        int v1;
        int v2;
        int w;
        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named MSTKruskal. */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] l = bf.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);
        List<String> edge = new ArrayList<>();
        int mm = m;
        while (mm-- > 0) {
            edge.add(bf.readLine());
        }
        int s = Integer.parseInt(bf.readLine());
        MSTKruskal sol = new MSTKruskal();

        sol.findGraph(n, edge, s);

    }

    private void findGraph(int n, List<String> edge, int start) {

        List<Edge> edges = new ArrayList<>();
        Comparator<Edge> edgeComp = new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2) {
                return e1.w - e2.w;
            }
        };
        List<Edge> edgeSorted = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Edge minEdgeFromS = null;
        for (String s : edge) {
            String[] edgeParam = s.split(" ");
            Edge ed = new Edge(Integer.parseInt(edgeParam[0]), Integer.parseInt(edgeParam[1]), Integer.parseInt(edgeParam[2]));
            edgeSorted.add(ed);

            if (min > ed.w && ((ed.v1 == start) || (ed.v2 == start))) {
                min = ed.w;
                minEdgeFromS = ed;
            }

        }
        Collections.sort(edgeSorted, edgeComp);
        MSTKruskal sol = new MSTKruskal();
        for (int i = 1; i <= n; i++) {
            sol.makeSet(i);
        }

        sol.makeUnion(minEdgeFromS.v1, minEdgeFromS.v2);
        int result = minEdgeFromS.w;
        for (Edge e1 : edgeSorted) {

            Node p1 = sol.findSet(e1.v1);
            Node p2 = sol.findSet(e1.v2);

            if (p1.data == p2.data) {
                continue;
            }

            sol.makeUnion(p1.data, p2.data);
            result  += e1.w;

        }

        System.out.println(result);

    }
}