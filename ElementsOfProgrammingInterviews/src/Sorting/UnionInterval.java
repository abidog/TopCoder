package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnionInterval {



    public List<Interval> union(List<Interval> list) {
        List<Interval> result = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return result;
        }
        Comparator<Interval> intComp = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.startInc ? -1 : 1;
            }
        };
        Collections.sort(list, intComp);
        Interval temp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval v = list.get(i);
            if (v.start >= temp.start && v.start <= temp.end) {
                if (v.start == temp.start) {
                    if (v.startInc) {
                        temp.startInc = true;
                    }
                }
                if (v.start == temp.end) {
                    if (v.startInc) {
                        temp.endInc = true;
                    }
                }
                if (v.end > temp.end) {
                    temp.endInc = v.endInc;
                }
                if (v.end == temp.end && v.endInc) {
                    temp.endInc = true;
                }

                temp.end = Math.max(temp.end, v.end);
            } else {
                result.add(temp);
                temp = v;
            }
        }
        result.add(temp);
        return result;
    }
}
