import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class DengklekMakingChains {

    public static void main(String[] args) throws IOException {
        String[] chains = new String[]{"9.9", "123"};
        System.out.println(new DengklekMakingChains().maxBeauty(chains));


    }

	public int maxBeauty(String[] chains) {

        int total = 0;
        List<String> needed = new ArrayList<>();
        int max = 0;
        for (String s : chains) {
            char a = s.charAt(0);
            char b = s.charAt(1);
            char c = s.charAt(2);
            if (a >= '0' && a <= '9' && b >= '0' && b <= '9' && c >= '0' && c <= '9') {
                total += a - '0' + b - '0' + c - '0';
            } else if (a != '.' || c != '.') {
                needed.add(s);
            }
            if (a  != '.')
                 max = Math.max(max, a - '0');
            if (b  != '.')
                max = Math.max(max, b - '0');
            if (c  != '.')
                max = Math.max(max, c - '0');


        }
        // left i   right j
        int mx = 0;
        for (int i = 0; i < needed.size(); i++) {
            String is = needed.get(i);
            int left = is.charAt(2) != '.' ? is.charAt(2) - '0' : 0;
            if (is.charAt(2) != '.') {
                left += (is.charAt(1) != '.' ? is.charAt(1) - '0' : 0);
            }
            mx = Math.max(mx, left);

            for (int j = 0; j < needed.size(); j++) {
                String js = needed.get(j);
                int right = js.charAt(0) != '.' ? js.charAt(0) - '0' : 0;
                if (js.charAt(0) != '.') {
                    right += (js.charAt(1) != '.' ? js.charAt(1) - '0' : 0);
                }
                if (i != j) {
                    mx = Math.max(left + right, mx);
                }
                mx = Math.max(mx, right);
            }
        }


        return Math.max(total + mx, max);
	}
}
