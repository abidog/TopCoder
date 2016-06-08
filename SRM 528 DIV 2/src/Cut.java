import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class Cut {

    public static void main(String[] args) {
        Cut c = new Cut();
        int[] eelLengths = new int[] {34, 10, 48};
        int maxCuts = 4;
        System.out.println(c.getMaximum(eelLengths, maxCuts));
    }

    public int getMaximum(int[] eelLengths, int maxCuts) {
        Comparator<Integer> intComp = new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                if (i1 % 10 == 0 && i2 % 10 == 0) {
                    return i1 - i2;
                }
                if (i1 % 10 == 0) {
                    return -1;
                }
                if (i2 % 10 ==0) {
                    return 1;
                }
                return i1 - i2;
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue(intComp);

        int count = 0;
        for (int i : eelLengths) {
            if (i == 10) {
                count++;
            } else if (i < 10) {
                continue;
            } else if (i == 20) {
                if (maxCuts > 0) {
                    maxCuts--;
                    count+= 2;
                }
            } else {
                heap.add(i);
            }
        }


        while (maxCuts > 0 && !heap.isEmpty()) {
            int stick = heap.poll();
            if (stick % 10 == 0) {
                int needed = stick/10 - 1;
                if (needed <= maxCuts) {
                    count+= needed+1;
                    maxCuts-=needed;
                } else {
                    count += maxCuts;
                    maxCuts = 0;
                }
            } else {
                int canHave = stick/10;
                if (canHave <= maxCuts) {
                    count += canHave;
                    maxCuts-= canHave;
                } else {
                    count += maxCuts;
                    maxCuts = 0;
                }
            }
        }
        return count;
	}
}
