import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ConvertibleStrings {

    public static void main(String[] args) {
        ConvertibleStrings cs = new ConvertibleStrings();
        String A = "FEDEIGCGHFFAHIEBIHFEED";
        String B = "DCFAGGBCBAFABAIGGIAFBD";


        System.out.println(cs.leastRemovals(A,B));
    }

    private boolean nextPerm(int[] num) {
        // 1 10 8 7 6 4
        // 4 10 8 7 6 1
        // 6 10 8 7 4 1
        int p = num.length - 1;
        for (; p > 0 && num[p - 1] >= num[p] ; p--);
        if (p == 0) {
            return false;
        }
        int q = num.length - 1;
        for (; num[q] <= num[p - 1]; q--);

        swap(num, p-1, q);

        int l = p;
        int r = num.length - 1;
        while (l < r) {
            swap(num, l, r);
            l++;
            r--;
        }
        return true;
    }
    private void swap(int[] num, int l , int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }

    public int leastRemovals(String A, String B) {

        String p = "ABCDEFGHI";
        int[] num = {0,1,2,3,4,5,6,7,8};
        int min = Integer.MAX_VALUE;
        do{
            int cnt = 0;
            for (int i = 0; i < A.length(); i++) {
                char a = A.charAt(i);
                char b = B.charAt(i);
                if (b == (char)(num[a - 'A'] + 'A')){
                    continue;
                } else {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);

        } while (nextPerm(num));

        return min;
	}



}
