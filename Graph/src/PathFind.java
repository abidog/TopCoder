import java.util.*;

public class PathFind{

    class Point{
        double x;
        double y;

        Point parent;
        public Point(double x, double y) {

            this.x = x;
            this.y = y;

        }
        public double distance(Point other) {
            return Math.sqrt((other.x - this.x)* (other.x - this.x) +  (other.y - this.y)* (other.y - this.y));
        }
        public int hashCode() {
            int hash = 373;
            hash = 37 * hash  + (int)x;
            hash = 37 * hash + (int)y;
            return hash;
        }
        public boolean equals(Object o) {
            Point other = (Point) o;
            return other.x == this.x && other.y == this.y;
        }
    }

    public List<Point> pathFind(int[][] sensors, int m, int[] topLeft, int[] bottomRight) {
        Map<Point, Boolean> unsafePoints = new HashMap<>();

        for (int i = 0; i < sensors.length; i++) {
            for (int x = sensors[i][0] - m; x <= sensors[i][0] + m; x++ ) {
                for (int y = sensors[i][1] - m; y <= sensors[i][1] + m; y++ ) {
                    unsafePoints.put(new Point(x,y), true);
                }
            }
        }
        List<Point> bestRoute = new ArrayList<>();
        Point leftTop = new Point(topLeft[0], topLeft[1]);
        Point rightBottom = new Point(bottomRight[0], bottomRight[1]);
        for (int x = topLeft[0]; x <= bottomRight[0]; x++) {
            List<Point> temp = bfs(new Point(x, topLeft[1]), unsafePoints, leftTop, rightBottom );
            if (temp.size() < bestRoute.size()) {
                bestRoute = temp;
            }
        }
        return bestRoute;
    }

    private List<Point> bfs(Point start, Map<Point, Boolean> unsafe, Point leftTop, Point rightBottom) {

        int[][] moves = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        List<Point> q = new ArrayList<>();
        q.add(start);
        Map<Point, Boolean> visited = new HashMap<>();
        visited.put(start, true);
        while (!q.isEmpty()) {
            Point visiting = q.remove(0);
            if (visiting.y == rightBottom.y) {
                List<Point> path = new ArrayList<>();
                while (visiting.parent != null) {
                    path.add(visiting);
                    visiting = visiting.parent;
                }
                path.add(visiting);
                return path;
            }

            for (int[] adj : moves) {
                double dx = adj[0] + visiting.x;
                double dy = adj[1] + visiting.y;
                if (dx >= leftTop.x && dx <= rightBottom.x && dy <= leftTop.y && dy >=  rightBottom.y  ) {
                    Point next = new Point(dx,dy);
                    if (!unsafe.containsKey(next) && !visited.containsKey(next)) {
                        next.parent = visiting;
                        visited.put(next, true);
                        q.add(next);
                    }
                }
            }


        }
        return null;
    }
}
