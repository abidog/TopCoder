import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PalindromizationDiv2 {

    public static void main(String[] args) {
        PalindromizationDiv2 p = new PalindromizationDiv2();
        System.out.println(p.getMinimumCost(25));
    }

    public int getMinimumCost(int x) {

        int min = Integer.MAX_VALUE;
        int ori = x;
        while (!isPal(x)) {
            x++;
        }
        min = Math.min(min, x - ori);
        x = ori;
        while (!isPal(x) && x > -2) {
            x--;
        }

        min = Math.min(min, ori - x);
        return min;
	}
    public boolean isPal(int x) {
        StringBuilder st = new StringBuilder(String.valueOf(x)).reverse();
        StringBuilder s = new StringBuilder(String.valueOf(x));
        return st.toString().equals(s.toString());
    }
}
