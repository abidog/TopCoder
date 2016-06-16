import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ColorfulBricks {
	
	public int countLayouts(String bricks) {

        int[] map = new int[256];
        int dif = 0;
        for (int i = 0; i < bricks.length(); i++) {
            if (map[bricks.charAt(i)] == 0) {
                dif++;
            }
            map[bricks.charAt(i)]++;
        }
        if (dif == 2) {
            return 2;
        } else if (dif == 1) {
            return 1;
        }


        return 0;
	}
}
