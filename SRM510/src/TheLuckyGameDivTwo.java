public class TheLuckyGameDivTwo {

    public static void main(String[] args) {
        TheLuckyGameDivTwo dv2 = new TheLuckyGameDivTwo();
        System.out.println(dv2.find(1,4747,4747,4747));
    }

    public int find(int a, int b, int jLen, int bLen) {

        int[] lowerLucky = new int[4749];
        for (int i = 0; i <= 4747 ; i++) {
            lowerLucky[i + 1] = lowerLucky[i] + (isLucky(i) ? 1 : 0);
        }

        int johnMax = 0;
        for (int jStart = a; jStart + jLen - 1 <= b ; jStart++) {
            int bMin = Integer.MAX_VALUE;
            for (int bStart = jStart; bStart + bLen - 1 <= jStart + jLen - 1 ; bStart++) {

                int c = lowerLucky[bStart + bLen] - lowerLucky[bStart];
                bMin = Math.min(bMin, c);

            }
            johnMax = Math.max(johnMax, bMin);
        }
        return johnMax;
    }

    private boolean isLucky(int i) {

        while (i > 0) {
            int last = i % 10;
            i /=10;
            if (last == 4 || last == 7) {
                continue;
            } else {
                return false;
            }

        }
        return true;

    }

}
