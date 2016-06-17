import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class FoxAndFlowerShopDivTwo {
	
	public int theMaxFlowers(String[] flowers, int r, int c) {
        int mx = 0;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < flowers[0].length(); j++) {
                if (flowers[i].charAt(j) == 'F') {
                    count++;
                }
            }
        }
        mx = Math.max(mx, count);
        count = 0;
        for (int i = r + 1; i < flowers.length; i++) {
            for (int j = 0; j < flowers[0].length(); j++) {
                if (flowers[i].charAt(j) == 'F') {
                    count++;
                }
            }
        }
        mx = Math.max(mx, count);
        count = 0;
        for (int i = 0; i < flowers.length; i++) {
            for (int j = 0; j < c; j++) {
                if (flowers[i].charAt(j) == 'F') {
                    count++;
                }
            }
        }
        mx = Math.max(mx, count);

        count = 0;
        for (int i = 0; i < flowers.length; i++) {
            for (int j = c + 1; j < flowers[0].length(); j++) {
                if (flowers[i].charAt(j) == 'F') {
                    count++;
                }
            }
        }
        mx = Math.max(mx, count);

        return mx;
	}
}
