
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.List;



public class Main {
    // > 0 counter clock wise, c is on the left,
    private double turn(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }


    class Point{
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }



    public static void main(String[] args) throws Exception {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(br.readLine());
        br.readLine();
        while (numCases-- > 0) {
            int numPoint = Integer.parseInt(br.readLine());
            String [] points = new String[numPoint];
            for (int i = 0; i < numPoint; i++) {
                points[i] = br.readLine();
            }

            main.convexPoints(points);

        }

    }
    public Point getLowest(Point[] points) {
        Point lowe =points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].y < lowe.y) {
                lowe = points[i];
            } else if (points[i].y == lowe.y) {
                if (points[i].x < lowe.x) {
                    lowe = points[i];
                }
            }

        }
        return lowe;
    }
    private double dist(Point p1, Point p2) {
        return Math.sqrt((p1.y - p2.y) * (p1.y - p2.y) + (p1.x - p2.x)*(p1.x - p2.x) );
    }

    private void convexPoints(String[] points) {
        Point[] point = new Point[points.length];
        for (int i = 0; i < point.length; i++) {
            String[] p = points[i].split(" ");
            point[i] = new Point(Double.parseDouble(p[0]), Double.parseDouble(p[1]));
        }
        Point lowest = getLowest(point);
        Comparator pointComp = new Comparator<Point>() {

            public int compare(Point p1, Point p2) {

                double angle1 = Math.atan2(p1.y - lowest.y, p1.x - lowest.x);
                double angle2 = Math.atan2(p2.y - lowest.y, p2.x - lowest.x);

                if (angle1 < angle2) {
                    return -1;
                }
                if (angle2 > angle1) {
                    return 1;
                }
                long dist1 =  (long)dist(lowest, p1);
                double dist2 =  (long)dist(lowest, p2);

                if (dist1 < dist2) {
                    return -1;
                }
                if (dist1 > dist2) {
                    return 1;
                }
                return 0;
            }
        };



        Arrays.sort(point, pointComp);

        if (point.length < 3) {
            System.out.println("No");
            return;
        }
        if (allColinear(point)) {
            System.out.println("NO");
        }
        List<Point> result = new ArrayList<>();

        Stack<Point> hullPoints = new Stack<>();
        hullPoints.push(point[0]);
        hullPoints.push(point[1]);

        for (int i = 2; i <point.length ; i++) {

            Point head = point[i];
            Point middle = hullPoints.pop();
            Point tail = hullPoints.peek();
            double trn = turn(tail, middle, head);
            if (trn > 0) {
                hullPoints.push(middle);
                hullPoints.push(head);
                continue;
            } else if (trn < 0) {
                i--;
            } else {
                hullPoints.push(head);
            }

        }
        hullPoints.push(point[0]);
        while (!hullPoints.isEmpty()) {
            result.add(hullPoints.pop());
        }
        double distance = 0;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < result.size() - 1; i++) {
               distance += dist(result.get(i), result.get(i + 1));
               min = Math.min(min, dist(new Point(0, 0), result.get(i)));
        }

        System.out.println((distance + 2 * min) + "");
    }

    private boolean allColinear(Point[] points) {
        for (int i = 0; i < points.length - 2; i++) {
            if (turn(points[i], points[i +1], points[i +2]) != 0) {
                return false;
            }
        }
        return true;
    }


}