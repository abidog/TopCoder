import java.util.*;


public class ConvexHull {

    public boolean isLeft(Point a, Point b, Point c){
        return ((b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x)) > 0;
    }
    /*
    Where a = line point 1; b = line point 2; c = point to check against.

    If the formula is equal to 0, the points are colinear.

    If the line is horizontal, then this returns true if the point is above the line.
    */


    public double areaConvexHull(int[] xs, int[] ys) {
        Point [] p = new Point[xs.length];
        for (int i = 0; i < xs.length; i++) {
            p[i] = new Point(xs[i], ys[i]);
        }
        List<Point> ch = convexHull(p);
        if (ch == null) {
            return 0.0;
        }
        p = new Point[ch.size()];
        for (int i = 0; i < ch.size(); i++) {
            p[i] = ch.get(i);
        }
        double area = 0;
        for (int i = 1; i < p.length - 1; i++) {
            area += getTurn(p[i], p[0], p[i + 1]);
        }

        return Math.abs(area)/2;
    }

    class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double distance(Point other) {
            return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
        }
    }

    public List<Point> convexHull(Point[] p) {
        List<Point> po = new ArrayList<>();
        for (Point point : p) {
            po.add(point);
        }
        List<Point> sortedPoints = new ArrayList<>(sortPoint(po));
        if (sortedPoints.size() < 3) {
            return null;
        }
        if (allColinear(p)) {
            return null;
        }

        Stack<Point> hullStack = new Stack<>();
        hullStack.push(sortedPoints.get(0));
        hullStack.push(sortedPoints.get(1));

        for (int i = 2; i < sortedPoints.size(); i++) {

            Point head = sortedPoints.get(i);
            Point middle = hullStack.pop();
            Point tail = hullStack.peek();

            double turn = getTurn(tail, middle, head);
            if (turn > 0) {
                hullStack.push(middle);
                hullStack.push(head);

            } else if (turn < 0) {
                i--;
            } else {
                hullStack.push(head);
            }
        }
        hullStack.push(sortedPoints.get(0));
        List<Point> list = new ArrayList<>(hullStack);
        return list;
    }

    private boolean allColinear(Point[] p) {

        for (int i = 0; i < p.length - 2; i++) {
            if (getTurn(p[i],p[i + 1], p[i + 2]) != 0) {
                return false;
            }
        }

        return true;
    }

    private TreeSet sortPoint(List<Point> p) {

        Point lowest = getLowest(p);

        Comparator pointComp  = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {

                double angle1 = Math.atan2(p1.y - lowest.y, p1.x - lowest.x);
                double angle2 = Math.atan2(p2.y - lowest.y, p2.x - lowest.x);

                if (angle1 < angle2) {
                    return -1;
                }
                if (angle1 > angle2) {
                    return 1;
                }

                long dis1 = (long)p1.distance(lowest);
                long dis2 = (long)p2.distance(lowest);

                if (dis1 < dis2) {
                    return -1;
                }
                if (dis2 < dis1) {
                    return 1;
                }
                return 0;
            }
        };

        TreeSet<Point> sortedPoint = new TreeSet<>(pointComp);
        sortedPoint.addAll(p);
        return sortedPoint;
    }

    private Point getLowest(List<Point> p) {

        Point minPoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = 0; i < p.size(); i++) {

            if (p.get(i).y < minPoint.y || p.get(i).x < minPoint.x && p.get(i).y == minPoint.y) {
                minPoint = p.get(i);
            }
        }

        return minPoint;
    }
    //  res < 0, clockwise, ==0 colinear > 0 anticlockwise
    private double getTurn(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y )*(c.x -a.x);
    }
}
