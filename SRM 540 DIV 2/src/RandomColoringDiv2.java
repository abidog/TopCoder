import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class RandomColoringDiv2 {
	
	public int getCount(int maxR, int maxG, int maxB, int startR, int startG, int startB, int d1, int d2) {
        int count = 0;

        for (int i = 0; i < maxR; i++) {
            for (int j = 0; j < maxG; j++) {
                for (int k = 0; k < maxB; k++) {

                    if (Math.abs(startR - i) <= d2 && Math.abs(startG - j) <= d2 && Math.abs(startB - k) <= d2) {
                        if (Math.abs(startR - i) >= d1 || Math.abs(startG - j) >= d1 || Math.abs(startB - k) >= d1) {
                            count++;
                        }
                    }

                }
            }
        }
		return count;
	}
}
