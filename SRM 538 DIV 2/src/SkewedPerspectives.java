import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class SkewedPerspectives {

    public static void main(String[] args) {
        int[] cubes = new int[]{33, 67, 13};
        int B = 15;
        int w = 13;
        String[] views = new String[] {"bbb02bb21b22bb201b110bbbb2111bbbbbb22b2b2"};

        SkewedPerspectives sp = new SkewedPerspectives();
        System.out.println(sp.areTheyPossible(cubes, B, w, views));
    }

    public String[] areTheyPossible(int[] cubes, int B, int w, String[] views) {


        String[] result = new String[views.length];


        for (int i = 0; i < views.length; i++) {
            int[] cube = Arrays.copyOf(cubes, cubes.length);

            result[i] = isPossible(cube, B, w, views[i]) ? "valid": "invalid";

        }

        return result;
	}

    private boolean isPossible(int[] cube, int b, int w, String view) {

        int column = 1;
        int t = 0;
        for (int i = 0; i < cube.length; i++) {
            t+= cube[i];
        }
        int i = 0;
        int mustFill = 0;
        int needB = 0;
        int spaceB = 0;
        while (i < view.length()) {


            int j = i;

            while (j < view.length() && view.charAt(j) == 'b') {
                j++;
            }
            if (j != i) {
                int black = j - i;
                b -= black/2;
                // adjust space
                if (j == 1) {
                    return false;
                }
                if (black % 2 == 1) {
                    column++;
                    b--;
                    spaceB = (i - 1)/2;
                    if ((j - 2) % 2 == 1) {
                        t--;
                        // assign a single square
                    }

                }
                i = j;

            } else {
                cube[view.charAt(i) - '0']--;
                t--;
                i++;
            }


        }
        if (b < 0 || column > w) {
            return false;
        }
        int fill = Math.min(b, spaceB);
        spaceB -= fill;
        b -= fill;
        t -= 2 * spaceB;
        if (t < 0) {
            return false;
        }
        if (cube[0] < 0 || cube[1] < 0 || cube[2] < 0) {
            return false;
        }
        return true;

    }
}
