import java.util.*;

public class RainyRoad {

    public static void main(String[] args) {
        RainyRoad rr = new RainyRoad();
        System.out.println(rr.isReachable(new String[]{".W..", "...."}));
        System.out.println(rr.isReachable(new String[]{".W..", "..W."}));

    }


    class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public String isReachable(String[] road) {
        int[][] move = {{1,0}, {1,1}, {0,1}, {0, -1}, {1, -1}, {1, 0}};
        boolean[] visit = new boolean[2 * road[0].length()];

        List<Node> q = new ArrayList<>();
        visit[0] = true;
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node v = q.remove(0);
            if (v.x == road[0].length() - 1 && v.y == 0) {
                return "YES";
            }

            for (int[] m : move) {
                int dx = v.x + m[0];
                int dy = v.y + m[1];
                if (dx >= 0 && dx < road[0].length() && dy >= 0 && dy < 2 && !visit[2*dy + dx]) {
                    visit[2*dy + dx] = true;
                    q.add(new Node(dx,dy));
                }
            }

        }
        return  "NO";

    }
}
