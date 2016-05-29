import java.util.*;

public class CandyShop {


    public static void main(String[] args) {
        int[] x = {2,3,5};
        int[] y = {1,-1,0};
        int[] r = {2,2,3};
        CandyShop cs = new CandyShop();
        System.out.println(cs.countProbablePlaces(x,y,r));
    }

    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int hashCode() {
            int hash = 7;
            hash = hash * 71 + x;
            hash = hash * 71 + y;
            return hash;
        }
        public boolean equals(Object o) {
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }
    }
    public int countProbablePlaces(int[] X, int[] Y, int[] R) {
        Set<Point> points = new HashSet<>();
        Map<String, Integer>count = new HashMap<>();
        Map<String, Integer>nextCount = new HashMap<>();
        for (int i = 0; i < 1; i++) {
            int dist = R[i];

            int minX = X[i] - dist;
            int maxX = X[i] + dist;

            int minY = Y[i] - dist;
            int maxY = Y[i] + dist;

            for (int j = minX; j <= maxX; j++) {
                for (int k = minY; k <= maxY ; k++) {
                    if (Math.abs(j - X[i]) + Math.abs(k - Y[i]) <= dist) {
                        count.put(j+" "+k, 1);

                    }
                }
            }

        }


        for (int i = 1; i < R.length; i++) {
            int dist = R[i];

            int minX = X[i] - dist;
            int maxX = X[i] + dist;

            int minY = Y[i] - dist;
            int maxY = Y[i] + dist;

            for (int j = minX; j <= maxX; j++) {
                for (int k = minY; k <= maxY ; k++) {
                    if (Math.abs(j - X[i]) + Math.abs(k - Y[i]) <= dist) {
                        String key = j+" "+k;
                        if (count.containsKey(key)) {
                            nextCount.put(key, count.get(key) + 1);
                        }
                    }
                }
            }

            count = nextCount;
            nextCount = new HashMap<>();

        }



        return count.size();
    }

}
