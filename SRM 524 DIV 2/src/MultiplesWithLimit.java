import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MultiplesWithLimit {

    public static void main(String[] args) {
        /*
        int N = 2007;
        int[] forbiddenDigits = new int[] {1, 2, 3, 4, 5, 6, 8, 9, 0};
        /*
        int N = 10000;
        int[] forbiddenDigits = new int[] {0};
        */
        int N = 8;
        int[] forbiddenDigits = new int[] {2,3,4,5,6,7,8,9};
        System.out.println(new MultiplesWithLimit().minMultiples(N, forbiddenDigits));
    }

    public String minMultiples(int N, int[] forbiddenDigits) {

        int[] q = new int[N + 1];
        String[] current = new String[N+1];
        int[] len = new int[N + 1];
        for (int i = 0; i < current.length; i++) {
            current[i] = "";
        }

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(i, true);
        }
        for (int i : forbiddenDigits) {
            map.put(i, false);
        }
        int qTail = 0;

        int curr = 0;
        while (curr <= qTail) {


            int now = q[curr];

            for (int i = 0; i <= 9; i++) {
                if (map.get(i)) {

                    if (now > 0 || i > 0) {
                        int nextMod = (10 * now + i) % N;
                        String nextString = current[now] + ""+String.valueOf(i);
                        if (current[nextMod].equals("")) {
                            current[nextMod] = nextString;
                            len[nextMod] = len[now] + 1;
                            if (nextString.length() > 9) {
                                current[nextMod] = nextString.substring(0,5)+ nextString.substring(nextString.length() - 5);
                            }
                            qTail++;
                            q[qTail] = nextMod;
                        }
                    }

                }
            }
            curr++;

        }

        if (current[0].equals("")) {
            return "IMPOSSIBLE";
        }
        if (current[0].length() >= 9) {
            return current[0].substring(0,3) +"..." + current[0].substring(len[0] - 3)+"("+len[0]+" digits)";
        }
        return current[0];

    }
}
