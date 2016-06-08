import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MagicStonesStore {

    public static void main(String[] args) {
        MagicStonesStore ms = new MagicStonesStore();
        System.out.println(ms.ableToDivide(1));
    }

    boolean [] prime = new boolean[2001];
	public String ableToDivide(int n) {
        n *=2;
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;
        for (int i = 2; i < 2001 ; i++) {
            if (prime[i]) {
                for (int j = i + i; j < 1001 ; j+=i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 1; i < n ; i++) {
            if (prime[i] && prime[n - i]) {
                return "YES";
            }
        }

        return "NO";
	}
}
