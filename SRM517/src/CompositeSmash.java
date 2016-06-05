import java.util.Arrays;

public class CompositeSmash {

    boolean[] isPrime = new boolean[100000];

    public static void main(String[] args) {
        CompositeSmash cs = new CompositeSmash();
        System.out.println(cs.thePossible(39601,199));

    }
    public String thePossible(int N, int target) {

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 4; i < 100000 ; i+=2) {
            isPrime[i] = false;
        }
        for (int i = 3; i < 100000 ; i+=2) {
            if (isPrime[i]) {
                for (int j = i + i; j < 100000 ; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        if (N == target) {
            return "Yes";
        }

        if (isPrime[N]) {
            return "NO";
        }

        int count = 0;

        for (int i = 2; i <= Math.sqrt(N); i++) {
           if (N % i == 0) {
               count++;
           }
            if (count > 1) {
                return "No";
            }
        }
        if (N % target == 0) {
            return "Yes";
        } else {
            return "No";
        }

    }
}
