import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class FavouriteDigits {

    private String string(String a, int count) {

        String res = "";
        while (count-- > 0) {
            res += a;
        }
        return res;
    }
	
	public long findNext(long N, int digit1, int count1, int digit2, int count2) {

        if (digit2 < digit1) {
            int t = digit1;
            digit1 = digit2;
            digit2 = t;
            t = count1;
            count1 = count2;
            count2 = t;
        }

        String strN = String.valueOf(N - 1);
        int L = Math.max(strN.length(), count1 + count2);

        if (L > strN.length() ) {
            int needToAdd = L - strN.length();
            while (needToAdd-- > 0) {
                strN = "0"+strN;
            }
        }
        int lc1 = Math.max(0,digit1 == 1? count1 - 1 : count1);
        int lc2 = Math.max(0,digit2 == 1? count2 - 1 : count2);

        String longer = string("1", 1) + string("0", L - lc1 - lc2)+string(String.valueOf(digit1), lc1) + string(String.valueOf(digit2), lc2);
        String answer = "";

        for (int i = 0; i < strN.length(); i++) {

            for (char d  = '9'; d > strN.charAt(i); d--) {

                // change this digit to d

                int c1 = Math.max(0, count1 - (d - '0' == digit1 ? 1 : 0));
                int c2 = Math.max(0, count2 - (d - '0' == digit2 ? 1 : 0));
                if (c1 + c2 > L -1 - i) {
                    continue;
                }
                String current = strN.substring(0, i) + string(d+"", 1) + string("0",L - i-1 - c1 - c2) + string(digit1+"", c1) + string(digit2+"", c2);
                if (current.charAt(0) != '0') {
                    answer = current;
                }

            }
            count1 += strN.charAt(i) == (int)(digit1 + '0') ? -1 : 0;
            count2 += strN.charAt(i) == (int)(digit2 + '0') ? -1 : 0;



        }
        if (answer.equals("")) {
            return Long.parseLong(longer);
        } else {
            return Long.parseLong(answer);
        }
	}
}
