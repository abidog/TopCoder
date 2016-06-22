package primitivetypes;

public class Random {
    public int random(int a, int b) {
        int t = b - a + 1;
        int res = 0;
        do {
            for (int i = 0; (1 << i) < t; i++ ) {
                res = (res << i) | (randomZeroOrOne());
            }
        } while (res > t);
        return res + a;
    }
    private int randomZeroOrOne() {
        Random rand = new Random();
        if (rand.random(2,7) % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}

