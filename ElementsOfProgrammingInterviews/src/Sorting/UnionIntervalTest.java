package Sorting;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Sorting.UnionInterval.*;
import static org.junit.Assert.*;

public class UnionIntervalTest {

    @Test
    public void unionTest() {
        UnionInterval unionInterval = new UnionInterval();
        List<Interval> intervalList = new ArrayList<>();

        Interval i1 = new Interval(1, 1 , true, true);
        Interval i2 = new Interval(0, 3 , false, true);
        Interval i3 = new Interval(2, 4 , true, true);
        Interval i4 = new Interval(3, 4 , true, false);
        Interval i5 = new Interval(5, 7 , true, false);
        Interval i6 = new Interval(7, 8 , true, false);
        Interval i7 = new Interval(8, 11 , true, false);
        Interval i8 = new Interval(9, 11 , false, true);
        Interval i9 = new Interval(13, 13 , false, false);
        Interval i10 = new Interval(12, 15 , false, true);
        Interval i11 = new Interval(12, 14 , true, true);
        Interval i12 = new Interval(15, 17 , false, false);
        intervalList.add(i1);
        intervalList.add(i2);
        intervalList.add(i3);
        intervalList.add(i4);
        intervalList.add(i5);
        intervalList.add(i6);
        intervalList.add(i7);
        intervalList.add(i8);
        intervalList.add(i9);
        intervalList.add(i10);
        intervalList.add(i11);
        intervalList.add(i12);
        unionInterval.union(intervalList);






    }

}
