import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class KingXNewBaby {
	
	public String isValid(String name) {

        String wo = "aeiuo";
        int w = 0;
        char ch = 'r';
        char ch2 = 't';
        boolean f1 = false;
        boolean f2 = false;
        for (char a : name.toCharArray()) {
            if (wo.indexOf(a) >= 0 && !f1) {
                ch = a;
                w++;
                f1 = true;
            } else if (!f2 && wo.indexOf(a) >= 0) {
                ch2 = a;
                f2 = true;
                w++;
            } else  if (wo.indexOf(a) >= 0) {
                w++;
            }
        }
        if (name.length() != 8) {
            return "NO";
        }
        if (w == 2 && ch2 == ch) {
            return "YES";
        } else {
            return "NO";
        }

	}
}
