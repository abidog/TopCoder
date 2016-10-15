package Sorting;

import Search.SearchAiEqi;

import java.util.*;

public class ComputeViewFromAbove {


    public int[] view(Segment[] segs) {
        if (segs == null || segs.length == 0) {
            return null;
        }

        List<Point> points = new ArrayList<>();

        for (Segment s : segs) {
            points.add(new Point(s.l, s.h, s.c, true));
            points.add(new Point(s.r, s.h, s.c,  false));

        }

        Comparator<Point> pointComparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {

                return o1.x - o2.x;
            }
        };

        Comparator<Point> heighComp = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.h - o1.h;
            }
        };

        Collections.sort(points, pointComparator);

        Set<Point> treeSet = new TreeSet(heighComp);

        List<Segment> viewAbove =new ArrayList<>();
        int min = 0;
        int max = 0;
        for (Segment s : segs) {

            min = Math.min(min, s.l);
            max = Math.max(max, s.r);
        };
        int pointer = 0;
        int[] colors  = new int[max];
        for (int i = min; i < max; i++) {

            while (points.get(pointer).x == i) {
                if (points.get(pointer).isStart) {
                    treeSet.add(points.get(pointer));
                } else {
                    treeSet.remove(points.get(pointer));
                }
                pointer++;
            }


            colors[i] = treeSet.iterator().next().c;
        }



        return colors;
    }
}
