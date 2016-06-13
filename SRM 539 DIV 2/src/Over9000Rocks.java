

import java.util.*;



public class Over9000Rocks {
    class Interval{
        int s;
        int e;
        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    class IntervalList {
        List<Interval> list = new ArrayList<>();
        public void insert(Interval interval) {
            if (list.size() == 0) {
                list.add(interval);
            } else {
                for (int i = 0; i < list.size() - 1; i++) {

                    Interval current = list.get(i);
                    if ( (current.s <= interval.s && current.e >= interval.s) || (current.s <=  interval.e && current.e >= interval.e)) {
                        current.s = Math.min(current.s, interval.s);
                        current.e = Math.max(current.e, interval.e);

                        interval = list.get(i + 1);
                    }
                }
                Interval current = list.get(list.size() - 1);
                if ((current.s <= interval.s && current.e >= interval.s) || (current.s <=  interval.e && current.e >= interval.e)) {
                    current.s = Math.min(current.s, interval.s);
                    current.e = Math.max(current.e, interval.e);
                } else {
                    list.add(interval);
                }


            }
        }
    }
    IntervalList res = new IntervalList();
    class Bound{
        int l;
        int u;
        public Bound(int l, int u) {
            this.l = l ;
            this.u = u;
        }
    }


    public static void main(String[] args) {
        int[] lowerBound = new int[] {9000, 1, 10};
        int[] upperBound = new int[] {9000, 2, 20};
        Over9000Rocks or = new Over9000Rocks();
        System.out.println(or.countPossibilities(lowerBound, upperBound));

    }
    public int countPossibilities(int[] lowerBound, int[] upperBound) {
        int n = lowerBound.length;
        List<Interval> list = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            int l = 0;
            int h = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 0x1) == 1) {
                    l += lowerBound[i];
                    h += upperBound[i];
                }
            }
            list.add(new Interval(l,h));

        }

        Comparator<Interval> intComp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.s != o2.s) {
                    return o1.s - o2.s;
                }
                return o1.e - o2.e;
            }
        };

        int s = 9000;
        int x = 0;
        Collections.sort(list, intComp);
        for (Interval i : list) {

            if (i.s > s) {
                x += i.e - i.s + 1;
                s = i.e;
            } else if (i.e > s) {
                x += (i.e - s);
                s = i.e;
            }

        }
        return x;

    }

	public int countPossibilitiess(int[] lowerBound, int[] upperBound) {



        Bound[] b = new Bound[lowerBound.length];
        for (int i = 0; i < lowerBound.length; i++) {
            b[i] = new Bound(lowerBound[i], upperBound[i]);
        }

        Comparator<Bound> boundComp = new Comparator<Bound>() {
            @Override
            public int compare(Bound o1, Bound o2) {
                if (o1.l != o2.l) {
                    return o1.l - o2.l;
                }
                return o1.u - o1.u;

            }
        };

        Arrays.sort(b, boundComp);

        solve(b,0, 0, 0);

        int count = 0;
        IntervalList list = new IntervalList();

        for (Interval i : res.list) {
            list.insert(i);

        }
        Comparator<Interval> intComp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.s != o2.s) {
                    return o1.s - o2.s;
                }
                return o1.e - o2.e;
            }
        };
        Collections.sort(list.list, intComp);
        for (Interval i : list.list) {
            //System.out.println(i.s +" "+i.e);
            count += i.e - i.s +1;

        }
        return count;
	}

    private void solve(Bound[] b, int index, int lower, int upper) {



        if (lower > 9000) {

            res.insert(new Interval(lower, upper));
        }
        if (lower <= 9000 && upper > 9000) {
            res.insert(new Interval(9001, upper));
        }
        for (int i = index; i < b.length ; i++) {
            solve(b, i + 1, lower + b[i].l, upper + b[i].u);
        }

    }
}
