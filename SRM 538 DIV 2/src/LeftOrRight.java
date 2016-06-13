import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class LeftOrRight {

    public static void main(String[] args) {
        String program = "R?LRRRLLRLRLLLR??L??RRRLRL??L?RLR";

        LeftOrRight lr = new LeftOrRight();

        System.out.println(lr.maxDistance(program));
    }

    public int maxDistance(String program) {

        String p1 = program.replaceAll("[?]","L");
        String p2 = program.replaceAll("[?]", "R");
        int mx = 0;
        int pos = 0;

        for (int i = 0; i < p1.length(); i++) {
            if (p1.charAt(i) == 'L') {
                pos--;
            } else {
                pos++;
            }
            mx = Math.max(mx, Math.abs(pos));
        }
        pos = 0;
        for (int i = 0; i < p2.length(); i++) {
            if (p2.charAt(i) == 'L') {
                pos--;
            } else {
                pos++;
            }
            mx = Math.max(mx, Math.abs(pos));
        }
        return mx;
    }
}
