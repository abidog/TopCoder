import java.util.Arrays;

// start 12:40pm
// end 1:40pm

public class CubeRoll {


    public static void main(String[] args) {
        CubeRoll cr = new CubeRoll();
        int init = 125;
        int goal = 62500;
        int[] goalPos = {86735, 23446, 5613, 99969, 80858, 51974, 78982, 78892, 51570, 52484, 24473, 70032, 77616, 51006, 64916, 16505, 85550, 37993, 46191, 60057, 58373, 86305, 10123, 19582, 99937, 75384, 97491, 64553, 87825, 26959, 95094, 74754, 3015, 53212, 69008, 74596, 21846, 81977, 50089, 12671, 83023, 67478, 22967, 79903, 89445, 71889};
        System.out.println(cr.getMinimumSteps(init, goal, goalPos));
    }

    public int getMinimumSteps(int initPos, int goalPos, int[] holePos) {

        Arrays.sort(holePos);
        long left = 0;
        long right = 0;
        if (initPos < holePos[0]) {
            left = Long.MIN_VALUE;
            right = holePos[0];
        } else if (initPos > holePos[holePos.length - 1]) {
            left = holePos[holePos.length - 1];
            right = Long.MAX_VALUE;
        } else {
            for (int i = 0; i < holePos.length - 1; i++) {
                if (holePos[i] < initPos && initPos < holePos[i + 1]) {
                    left = holePos[i];
                    right = holePos[i + 1];
                    break;
                }
            }
        }

        if (goalPos > left && goalPos < right ) {

            if (initPos > goalPos) {
                int temp = goalPos;
                goalPos = initPos;
                initPos = temp;
            }

            int dif = Math.abs(goalPos - initPos);
            if (dif == ((int)Math.sqrt(dif) * (int)Math.sqrt(dif))) {
                return 1;
            }
            //try a^2 - b^2 = (a-b)(a+b) = dif
            // 2a  = biggerFactor + smallerFactor
            // b = biggerFactor - a
            // check if a^2 < right
            // b^2 > left
            for (int i = 1; i <= Math.sqrt(dif) ; i++) {
                if (dif % i == 0) {
                    int smallerFactor = i;
                    int biggerFactor = dif / i;

                    if ((smallerFactor + biggerFactor) % 2 == 0) {
                        int a = (smallerFactor + biggerFactor)/2;
                        int b = biggerFactor - a;
                        if (a * a + initPos < right || initPos - b * b > left) {
                            //System.out.println(a+" "+b);
                            return 2;
                        }
                    }
                }
            }

            // lets try a^2 + b^2 = (a + b)^2 - 2ab = dif
            // (a + b)^2 = dif + 2ab
            for (int i = (int)Math.sqrt(dif) + 1; i < goalPos ; i++) {
                if ((i * i - dif) % 2 == 0) {
                    // a + b = i;
                    // 2ab = i * i - dif
                    int factor = (i * i - dif)/2; // a*b
                   // System.out.println(factor);
                    for (int j = 1; j <= Math.sqrt(factor) ; j++) {
                        if (factor % j == 0) {
                            int a = j;
                            int b = factor / j;
                            if (a + b == i) {

                                return 2;
                            }
                        }
                    }

                }
            }
        }

        return -1;


    }
}
