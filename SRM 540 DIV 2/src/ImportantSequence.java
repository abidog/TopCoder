import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ImportantSequence {

    public static void main(String[] args) {
        ImportantSequence is = new ImportantSequence();
        int[] B = new int[] {-1000000000, -1000000000, -1000000000, 1000000000, 1000000000, 1000000000, 2};
        String operators = "------+";

        System.out.println(is.getCount(B, operators));
    }

    public int getCount(int[] B, String operators) {

        int[] num = new int[operators.length() + 1];

        boolean allNeg = true;
        int start = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < operators.length(); i++) {
            if (operators.charAt(i) == '+') {
                allNeg = false;
                if (B[i] < start) {
                    index = i;
                    start = B[i];
                }
            }
        }
        if (allNeg) {
            return -1;
        }
        int count = 0;
        for (int i = 1; i < start ; i++) {
            long a = i;
            long b = B[index] - a;

            // check if right is pos
            boolean right = true;
            boolean left = true;
            for (int j = index + 1; j < operators.length() ; j++) {
                long nb;
                if (operators.charAt(j) == '+') {
                    nb = B[j] - b;
                } else {
                    nb = b - B[j];
                }
                if (nb <= 0) {
                    right = false;
                    break;
                }
                b = nb;

            }
            b = a;
            a = B[index] - b;

            for (int j = index - 1; j >= 0 ; j--) {
                long nb;
                if (operators.charAt(j) == '+') {
                    nb = B[j] - b;
                } else {
                    nb = b + B[j];
                }
                if (nb <= 0) {
                    left = false;
                    break;
                }
                b = nb;
            }
            if (left && right) {
                count++;
            }



        }
        return count;
	}
}
