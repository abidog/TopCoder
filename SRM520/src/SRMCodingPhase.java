public class SRMCodingPhase {

    public static void main(String[] args) {
        SRMCodingPhase cp = new SRMCodingPhase();
        int[] p = {300, 600, 1100};
        int[] s =  {80, 90, 100};
        int l = 4;




        System.out.println(cp.countScore(p, s, l));
    }

    public int countScore(int[] points, int[] skills, int luck) {
        int[][] order = {{0,1,2}, {0,2,1}, {1,0,2}, {1,2,0}, {2, 0,1}, {2,1,0}};
        int res = 0;
        for (int[] o : order) {
            res = Math.max(res, getPoint(o, points, skills, luck));
        }

        return res;
    }


    private int getPoint(int[]o, int[] points,int[] skills, int luck) {

        int t1 = skills[o[0]];
        int t2 = skills[o[1]];
        int t3 = skills[o[2]];

        int[] map = {2, 4,8};

        if (luck >= t1 - 1) {
            t1 = 1;
            luck -= skills[o[0]];
        } else {
            t1 -= luck;
            luck = 0;
        }

        if (luck >= t2 - 1) {
            t2 = 1;
            luck -= skills[o[1]];
        } else {
            t2 -= luck;
            luck = 0;
        }

        if (luck >= t3 - 1) {
            t3 = 1;
            luck -= skills[o[2]];
        } else {
            t3 -= luck;
            luck = 0;
        }
        int res = 0;
        if (t1 <= 75) {
            res += points[o[0]] - map[o[0]] * t1;
        }
        if (t1 + t2 <= 75) {
            res += points[o[1]] - map[o[1]] * t2;
        }
        if (t1 + t2 + t2 <= 75) {
            res += points[o[2]] - map[o[2]] * t3;
        }

        return res;
    }
}
