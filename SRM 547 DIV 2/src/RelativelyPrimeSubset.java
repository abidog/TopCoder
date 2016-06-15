import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class RelativelyPrimeSubset {


    public int gcd(int a, int b) {

        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

	public int findSize(int[] S) {

       int max = 0;

        for (int i = 0; i < S.length; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(S[i]);
            for (int j = i + 1; j < S.length; j++) {

                if (relativePrimeToList(S[j], current)) {
                    current.add(S[j]);
                }

            }
            if (current.size() > max) {
                max = current.size();
            }
        }


        return max;
	}

    private boolean relativePrimeToList(int s, List<Integer> current) {

        for (int k : current) {
            if (gcd(k, s) != 1) {
                return false;
            }
        }
        return true;
    }


    private List<Integer> factor(int n) {
        List<Integer> fac = new ArrayList<>();
        for (int i = 2; i <= n / i ; i++) {
            if (n % i == 0) {
                fac.add(i);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n != 0) {
            fac.add(n);
        }
        return fac;

    }
}
