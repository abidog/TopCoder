import java.util.*;

public class KingdomXCitiesandVillagesAnother {

    public static void main(String[] args) {
        KingdomXCitiesandVillagesAnother kx =  new KingdomXCitiesandVillagesAnother();
        int[] cx = {909261};
        int[] cy = {932302};
        int[] vx =  {548278, 46215, 48975, 928305, 516309, 369176, 310820, 54172, 709276, 426469, 384141, 759667, 521798, 739499, 967238, 877009, 168702, 140004, 803093, 333797, 260148, 935145, 930531, 261702, 16267, 110925, 323380, 989898, 349296, 308385, 415153};
        int[] vy=  {482944, 105989, 879870, 597621, 673340, 97243, 709059, 690735, 989952, 434120, 116710, 589489, 960206, 426208, 167258, 515515, 923224, 736177, 68308, 319402, 221472, 570968, 507817, 158305, 206670, 400408, 870592, 363677, 247895, 316533, 185393};

        System.out.println(kx.determineLength(cx,cy,vx,vy));
    }

    class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode(){
            int hash = 7;
            hash = hash * 71 + (int)x;
            hash = hash * 71 + (int)y;
            return hash;
        }
        public double distance(Point other) {
            return Math.sqrt((other.x - this.x)*(other.x - this.x) + (other.y - this.y)*(other.y - this.y));
        }


    }

    double determineLength(int[] cityX, int[] cityY, int[] villageX, int[] villageY) {
        int totalLen = cityX.length + villageX.length;
        double[][] dist = new double[totalLen][totalLen];
        int[] xPoint = new int[totalLen];
        int[] yPoint = new int[totalLen];
        System.arraycopy(cityX, 0, xPoint, 0, cityX.length);
        System.arraycopy(villageX, 0, xPoint, cityX.length, villageX.length);
        System.arraycopy(cityY, 0, yPoint, 0, cityY.length);
        System.arraycopy(villageY, 0, yPoint, cityY.length, villageY.length);


        boolean[] status = new boolean[totalLen];
        for (int i = 0; i < cityX.length; i++) {
            status[i] = true;
        }
        for (int i = 0; i < totalLen; i++) {
            for (int j = i; j < totalLen ; j++) {

                dist[i][j]  = Math.sqrt( (0.0+xPoint[i] - xPoint[j])*(0.0 + xPoint[i] - xPoint[j]) + 0.0 + (0.0+yPoint[i] - yPoint[j])*(0.0+yPoint[i] - yPoint[j]));
                dist[j][i] = dist[i][j];
            }
        }

        int connected = cityX.length;
        double res = 0;
        while (connected < totalLen) {
            double dis = Double.MAX_VALUE;
            int selectedj = -1;
            int i = 0;
            int selectedi = -1;
            for (; i < totalLen; i++) {

                // i is not connected
                if (!status[i]) {
                    continue;
                }
                // i is connected find the closest unconnected village

                for (int j = 0; j < totalLen; j++) {

                    if (status[j] || dist[i][j] >= dis ) {
                        continue;
                    }
                    dis = dist[i][j];
                    selectedj = j;
                    selectedi = i;

                }
            }
            if (selectedi != -1 && selectedj != -1) {
                status[selectedj] = true;
                connected++;
                res += dist[selectedi][selectedj];
            }

        }


        return res;

    }

}
