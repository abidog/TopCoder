import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class TheBrickTowerMediumDivTwo {
	
	public int[] find(int[] heights) {
        int[] num = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            num[i] = i;
        }
        int min = Integer.MAX_VALUE;
        int[] res = null;
        do{
            int temp = 0;
            for (int i = 0; i < heights.length - 1; i++) {
                temp += Math.max(heights[num[i]], heights[num[i + 1]]);
            }
            if (temp < min) {
                min = temp;
                res = Arrays.copyOf(num, num.length);
            }

        } while (next(num));



		return res;
	}

    public boolean next(int[]num) {

        int p = num.length - 1;
        // 1 2 4 7 9 12 10 3 0
        for (; p > 0 && num[p - 1] >= num[p]; p--);

        if (p == 0) {
            return false;
        }

        int q = num.length - 1;
        for (; q >= 0 && num[q] <= num[p - 1]; q-- );
        swap(num, p - 1 ,q);

        int l = p;
        int r = num.length - 1;
        while (l < r) {
            swap(num, l, r);
            l++;
            r--;
        }
        return true;
    }
    private void swap(int[] num, int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
