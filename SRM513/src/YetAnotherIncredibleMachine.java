import java.util.*;
// start: 11:36am
// end : 11:51am
// test : 11:52am
public class YetAnotherIncredibleMachine {

    public static void main(String[] args) {
        YetAnotherIncredibleMachine yet = new YetAnotherIncredibleMachine();
        int[] plat =  {100, -4215, 251};
        int[] len = {400, 10000, 2121};
        int[] b =  {5000, 2270, 8512, 6122};





        System.out.println(yet.countWays(plat, len, b));
    }

    public int countWays(int[] platformMount, int[] platformLength, int[] balls) {

        long res = 0;
        boolean isRes = false;
        int mod = 1000000009;

        Map<Integer, Boolean> ball = new HashMap<>();

        for (int i = 0; i < balls.length ; i++) {
            ball.put(balls[i], true);
        }

        for (int i = 0; i < platformMount.length; i++) {
            int mount = platformMount[i];
            int len = platformLength[i];

            long count = 0;




            for (int j = mount - len; j <= mount ; j++) {
                int start = j;
                int end = j + len;
                boolean isGood = true;
                for (int test = start; test <= end ; test++) {
                    if (ball.containsKey(test)) {
                        isGood = false;
                        break;
                    }
                }
                if (isGood) {
                    count++ ;
                }

            }
            if (count != 0) {
                if (!isRes) {
                    res = 1;
                    isRes = true;
                }
                res *= (count) % mod;

            }

            res %= mod;
        }

        return (int)(res % mod);
    }
}
