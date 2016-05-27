// start 12:13pm
// end 12:17pm

public class CubeAnts {
    public int getMinimumSteps(int[] pos) {
        int max = 0;

        for (int i : pos) {
            max = Math.max(max, match(i));
        }
        return max;
    }

    public int match(int i) {
        switch (i) {
            case 0 :
                return 0;
            case 1:
                return 1;
            case 4:
                return 1;
            case 3:
                return 1;
            case 2:
                return 2;
            case 5:
                return 2;
            case 7:
                return 2;
            case 6:
                return 3;
        }
        return 10;
    }
}
