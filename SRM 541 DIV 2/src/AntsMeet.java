import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class AntsMeet {

    public static void main(String[] args) {
        int[] x = new int[] {-1000, 1000};
        int[] y = new int[] {-1000, 1000};
        String direction =  "NW";
        System.out.println(new AntsMeet().countAnts(x, y, direction));
    }

    private  int[] getDir(char c) {
        if (c == 'N') {
            return new int[]{0,1};
        } else if (c == 'S') {
            return new int[]{0,-1};
        } else if (c == 'W') {
            return new int[]{-1,0};
        } else{
            return new int[]{1,0};
        }
    }
	public int countAnts(int[] x, int[] y, String direction) {


        double[] xx = new double[x.length];
        double[] yy = new double[y.length];
        for (int i = 0; i < x.length; i++) {
            xx[i] = x[0];
            yy[i] = y[0];
        }
        boolean[] collide = new boolean[x.length];
        int t = 0;
        while (t <= 4000) {


            for (int i = 0; i < x.length; i++) {
                if (collide[i]) {
                    continue;
                }
                int[] dir = getDir(direction.charAt(i));
                for (int j = i + 1; j < x.length; j++) {
                    int[] dir2 = getDir(direction.charAt(j));
                   if (!collide[j] && (2 * x[i] + dir[0] * t) == (2 * x[j] + dir2[0] * t) && (2 *y[i] + t * dir[1]) == (2 *y[j] + t * dir2[1])) {
                       collide[i] = true;
                       collide[j] = true;
                   }
                }
            }
            t++;
        }

        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (!collide[i]) {
                count++;
            }
        }
        return count;
	}
}
