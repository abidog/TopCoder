
import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
public class ClosestPair {

    public static void main(String[] args) {
        Point[] points = new Point[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            points[i] = new Point(rand.nextInt()%10, rand.nextInt()%10);
        }
        ClosestPair cp = new ClosestPair();
        System.out.println(cp.closestPair(points)[0]);
    }


    public Point[] closestPair(Point[] points){
        Point[] closest = new Point[2];
        Comparator xComp = new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                 if (p1.x < p2.x) {
                     return -1;
                 }

                 if (p1.x > p2.x) {
                     return 1;
                 }

                 if (p1.y < p2.y ) {
                     return -1;
                 }


                 if (p1.y > p2.y) {
                     return 1;
                 }

                return 0;

            }
         };

        Comparator yComp = new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                if (p1.y < p2.y) {
                    return -1;
                }

                if (p1.y > p2.y) {
                    return 1;
                }

                if (p1.x < p2.x ) {
                    return -1;
                }


                if (p1.x > p2.x) {
                    return 1;
                }

                return 0;

            }
        };

        Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy, xComp);
        SortedSet<Point> candid = new TreeSet<>(yComp);
        double min = Double.MAX_VALUE;
        int leftIndex = 0;
        for (int i = 0; i < copy.length; i++) {

            Point current = copy[i];
            while (current.x - copy[leftIndex].x > min) {
                candid.remove(copy[leftIndex++]);
            }


            Point upper = new Point(current.x, (int)(current.y + min));
            Point lower = new Point(current.x, (int)(current.y - min));

            for (Point p : candid.subSet(lower, upper)) {

                if (p.distance(current) < min) {
                    min = p.distance(current);
                    closest[0] = current;
                    closest[1] = p;
                }

            }
            candid.add(current);

        }

        return  closest;

    }


}
