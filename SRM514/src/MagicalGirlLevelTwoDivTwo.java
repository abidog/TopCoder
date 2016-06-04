import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

// start 1pm
// end : 1:24pm
public class MagicalGirlLevelTwoDivTwo {


    public static void main(String[] args) {
        int[] ju = 		{1, 3, 9, 7, 5};
        int x = -30;
        int y = -29;
        MagicalGirlLevelTwoDivTwo m = new MagicalGirlLevelTwoDivTwo();
        System.out.println(m.isReachable(ju, x, y));

    }

    private int[][] moves(int n) {
        int[][] m = new int[][]{{n, 1}, {n, -1}, {-n, 1}, {-n, -1}, {1, n}, {-1, n}, {1, -n},{-1, -n}};
        return m;
    }
    private boolean isBoundry(int x, int y) {
        return x >= -60 && x <= 60 && y >= -60 && y <= 60;
    }
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            int hash = 71;
            hash = hash * x + y;
            return hash;
        }
        public boolean equals(Object o) {
            Node other = (Node) o;
            return other.x == this.x && other.y == this.y;
        }
    }
    private double distance(Node n, int x, int y) {
        return Math.sqrt((n.x - x) * (n.x - x) + (n.y - y) * (n.y - y));
    }
    public String isReachable(int[] jumpTypes, int x, int y) {
        PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (distance(o1, x,y) <= distance(o2, x,y)){
                    return -1;
                }
                return   (int)(distance(o1, x,y) - distance(o2, x,y));
            }
        });

        q.add(new Node(0, 0));
        Map<Node, Boolean> visited = new HashMap<>();
        visited.put(q.peek(), true);

        while (!q.isEmpty()) {
            Node visiting = q.poll();
            if (visiting.x == x && visiting.y == y) {
                return "YES";
            }
            for (int n : jumpTypes) {
                int[][] move = moves(n);
                for (int [] adj : move) {
                    int dx = visiting.x + adj[0];
                    int dy = visiting.y + adj[1];
                    if (isBoundry(dx,dy) && !visited.containsKey(new Node(dx, dy))) {
                        Node t =new Node(dx,dy);
                        q.add(t);
                        visited.put(t, true);
                    }
                }
            }

        }
        return "NO";
    }

}
