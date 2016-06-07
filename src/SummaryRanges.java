import java.util.*;

public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        sr.addNum(1);
        sr.addNum(3);
        sr.addNum(7);
        sr.addNum(2);
        sr.addNum(6);
    }

   class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
       public String toString() {
           return "s:"+start+" e:"+end;
       }
   }
    Map<Integer, Interval> start ;
    Map<Integer, Interval> end;
    Map<Integer, Boolean> visited ;
    List<Interval> intervals ;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        start = new HashMap<>();
        end = new HashMap<>();
        visited = new HashMap<>();
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        if (visited.containsKey(val)) {
            return;
        }
        visited.put(val, true);

        Interval st = null;
        Interval en = null;

        if ( start.containsKey(val + 1)) {
            st  = start.get(val + 1);
        }
        if (end.containsKey(val - 1)) {
            en = end.get(val - 1);
        }
        if (st != null && en != null) {
            Interval temp = new Interval(en.start, st.end);
            start.remove(val + 1);
            end.remove(val - 1);
            int si = -1;
            int ei = -1;
            boolean is = false;
            boolean ie = false;
            for (int i = 0; i < intervals.size(); i++) {
                if (intervals.get(i).start == st.start) {
                    si = i;
                    is = true;
                } else if (intervals.get(i).end == en.end) {
                    ei = i;
                    ie = true;
                }
                if (is && ie) {
                    break;
                }
            }

            intervals.remove(si);
            if (si < ei) {
                intervals.remove(ei - 1) ;
            } else {
                intervals.remove(ei) ;
            }

            intervals.add (temp);

            start.put(en.start, temp);
            end.put(st.end, temp);


        } else if (st != null) {
            Interval temp = new Interval(val, st.end);
            start.remove(val + 1);
            start.put(val, temp);

            int si = -1;
            for (int i = 0; i < intervals.size(); i++) {
                if (intervals.get(i).start == st.start) {
                    si = i;
                    break;
                }
            }
            intervals.remove(si);
            intervals.add(temp);

        } else if (en != null) {
            Interval temp = new Interval(en.start, val);
            end.remove(val - 1);
            end.put(val, temp);

            int si = -1;
            for (int i = 0; i < intervals.size(); i++) {
                if (intervals.get(i).start == st.start) {
                    si = i;
                }
            }
            intervals.remove(si);
            intervals.add(temp);
        } else {
            Interval in = new Interval(val, val);
            start.put(val, in);
            end.put(val, in);
            intervals.add(in);
        }

    }

    public List<Interval> getIntervals() {
        return intervals;
    }
}