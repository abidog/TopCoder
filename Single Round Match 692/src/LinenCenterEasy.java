import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class LinenCenterEasy {

    public static void main(String[] args) {
        LinenCenterEasy lc = new LinenCenterEasy();
        String S = "xy";
        int N = 2;
        int K = 1;
        System.out.println(lc.countStrings(S, N, K));

       // System.out.println(lc.howMany(3, 2, 1, 0));
    }

    public int countStrings(String S, int N, int K) {
        int mod = 1000000009;
        int l = S.length();
        int min = l * K;
        int max = l * K + N;
        long res = 0;
        //
        for (int i = min; i <= max; i++) {
            int positionForOriginal = i - K * l + 1;
            res += howMany(i, l, K, 0) * Math.pow(26, i - K *l);
            res %= mod;
            // subtract the ones more than k cover number
            // K + 1
            long diff = howMany(i, l, K + 1, 0) * (long)(Math.pow(26, i - (K + 1)*l)) % mod;
            res -= diff;
            res %= mod;
        }

        return (int)res;
	}

    public long howMany(int len, int sizeOfS, int numberS, int start) {
        if (numberS == 0) {
            return 1;
        }
        if (numberS < 0) {
            return 0;
        }
        long res = 0;
        for (int i = start; i <= len - sizeOfS ; i++) {
            res += howMany(len, sizeOfS, numberS - 1, i + sizeOfS);
        }
        return res;

    }
}
