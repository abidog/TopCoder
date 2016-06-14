import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class EllysTSP {
	
	public int getMax(String places) {
        int v = 0;
        int c = 0;
        for (int i = 0; i < places.length(); i++) {
            if (places.charAt(i) == 'V') {
                v++;
            } else {
                c++;
            }
        }

        int mn = Math.min(v, c);
        if (v == c) {
            return v + c;
        } else {
            return  2 * mn + 1;
        }

	}
}
