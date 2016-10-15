import java.util.Arrays;

public class StableMarriage {
    public int[] match(int[][] priority) {
        if (priority == null || priority.length == 0) {
            return null;
        }
        int n = priority[0].length;
        int[] match = new int[n];
        Arrays.fill(match, -1);
        boolean[] free = new boolean[n];
        Arrays.fill(free, true);
        int num = n;
        while (n > 0) {

            for (int m = 0; m < num; m++) {
                if (!free[m]) {
                    continue;
                }
                n--;

                for (int i = 0; i < num && free[m]; i++) {
                    int w2 = priority[m][i];
                    if (match[w2 - num] == -1) {
                        match[w2 - num] = m;
                        free[m] = false;
                        break;
                    } else {
                        int m1 = match[w2 - num];
                        if (mIsPreferedM1(priority[w2], m, m1)) {
                            free[m] = false;
                            match[w2 - num] = m;
                            free[m1] = true;
                        }
                    }
                }



            }



        }
        return match;
    }

    private boolean checkIfNewIsBetter(int priority[][], int bride,
                                       int currentGroom, int suitor) {
        for (int groom : priority[bride]) {
            if (currentGroom == groom) {
                return false;
            }
            if (suitor == groom) {
                return true;
            }
        }
        return false;
    }

    public int[] findPair(int[][] priority) {
        int pair = priority[0].length;
        int groomToBride[] = new int[pair];
        int brideToGroom[] = new int[pair];
        for(int i=0; i < groomToBride.length; i++){
            groomToBride[i] = -1;
        }
        for(int i=0; i < brideToGroom.length; i++){
            brideToGroom[i] = -1;
        }
        int groom ;
        int remaingGrooms = pair;
        while (remaingGrooms > 0) {
            groom = -1;
            for (int hasBride : groomToBride) {
                if (hasBride != -1) {
                    continue;
                }
                groom++;
                for (int bride : priority[groom]) {
                    if (brideToGroom[bride-pair] == -1) {
                        groomToBride[groom] = bride;
                        brideToGroom[bride-pair] = groom;
                        remaingGrooms--;
                        break;
                    } else {
                        boolean flag = checkIfNewIsBetter(priority, bride,
                                brideToGroom[bride-pair], groom);
                        if (flag) {
                            int currentGroom = brideToGroom[bride-pair];
                            brideToGroom[bride-pair] = groom;
                            groomToBride[groom] = bride;
                            groomToBride[currentGroom] = -1;
                        }
                    }
                }
            }
        }
        return groomToBride;
    }


    public boolean mIsPreferedM1(int[] arr, int m, int m1) {

        for (int i : arr) {
            if (m == i) {
                return true;
            }
            if (m1 == i) {
                return false;
            }
        }
        return false;
    }



    public static void main(String args[]){
        int priority[][] = { {7, 5, 6, 4},
                {5, 4, 6, 7},
                {4, 5, 6, 7},
                {4, 5, 6, 7},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
        };
        StableMarriage smp = new StableMarriage();
        int[] result = smp.match(priority);
        for(int i = 0; i < result.length; i++){
            System.out.println((i + 4) + " " + (result[i]));
        }
    }
}
