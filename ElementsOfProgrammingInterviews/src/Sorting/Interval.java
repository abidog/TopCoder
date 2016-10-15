package Sorting;

class Interval{
    int start;
    int end;
    boolean startInc;
    boolean endInc;
    public Interval(int s, int e, boolean si, boolean ei) {
        start = s;
        end = e;
        startInc = si;
        endInc = ei;
    }
}