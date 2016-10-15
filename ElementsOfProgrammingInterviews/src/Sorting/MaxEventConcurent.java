package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxEventConcurent {
    class Point{
        int time;
        boolean start;
        public Point(int t, boolean s) {
            this.time = t;
            this.start = s;
        }
    }
    public int maxEvent(int[] start, int[] end) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            points.add(new Point(start[i], true));
            points.add(new Point(end[i], false));
        }
        Comparator<Point> pointComp = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.time != p2.time) {
                    return p1.time - p2.time;
                }
                return p1.start ? -1 : 1;
            }


        };

        Collections.sort(points, pointComp);
        int max = 0;
        int count = 0 ;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).start) {
                max = Math.max(++count, max);
            } else {
                count--;
            }
        }
        return max;
    }
}