package primitivetypes;

public class GCD {

    public int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd2(b % a, a);
    }


}
