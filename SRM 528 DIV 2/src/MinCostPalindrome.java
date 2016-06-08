import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MinCostPalindrome {
	
	public int getMinimum(String s, int oCost, int xCost) {

        int l = 0;
        int r = s.length() - 1;
        int total = 0;

        while (l < r) {
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);

            if (lChar == '?' && rChar == '?') {
                total += 2* Math.min(oCost, xCost);
            } else if ((lChar == 'x' && rChar == '?') || (rChar == 'x' && lChar == '?') ) {
                total += xCost;
            } else if ((lChar == 'o' && rChar == '?') || (rChar == 'o' && lChar == '?')){
                total += oCost;
            } else if (lChar != rChar){
                return -1;
            }
            l++;
            r--;
        }

        return total;
	}
}
