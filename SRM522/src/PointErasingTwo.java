// start : 5:45pm


public class PointErasingTwo {

    public static void main(String[] args) {
        PointErasingTwo p = new PointErasingTwo();
        int[] y = { 0, 23, 49, 50, 32, 0, 18, 50, 0, 28, 50, 27, 49, 0 };
        System.out.println(p.getMaximum(y));
    }

    public int getMaximum(int[] y) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < y.length; i++) {
            int x1 = i;
            int y1 = y[x1];

            for (int j = i + 1; j < y.length ; j++) {
                int x2 = j;
                int y2 = y[x2];

                int count = 0;
                for (int k = 0; k < y.length; k++) {

                    int x3 = k;
                    int y3 = y[x3];

                    if (x3 > Math.min(x1,x2) && x3 < Math.max(x1,x2) && y3 < Math.max(y1,y2) && y3 > Math.min(y1, y2)) {
                        count++;
                    }

                }

                max = Math.max(max, count);

            }


        }
        return max;
    }
}
