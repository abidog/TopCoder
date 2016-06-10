import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PriorityQueue {
	
	public int findAnnoyance(String S, int[] a) {
		
        int[] dis = new int[a.length];
        int numB = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
                dis[i] = numB * a[i];
                if (S.charAt(i) == 'b') {
                    numB++;
                }
        }
        int res =0;
        for (int i = 0; i < dis.length; i++) {
            res += dis[i];
        }
        return res;
	}
}
