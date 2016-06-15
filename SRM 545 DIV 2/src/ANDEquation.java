import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ANDEquation {

    public static void main(String[] args) {
        ANDEquation ae = new ANDEquation();
        int[] A = new int[] {31, 7, 7};
        System.out.println(ae.restoreY(A));
    }

    public int restoreY(int[] A) {


        for (int y = 0; y < A.length; y++) {
            int res = ~0;
            for (int i = 0; i < A.length; i++) {
                if(i != y) {
                    res &= A[i];
                }

            }
            if (res == A[y]) {
                return A[y];
            }
        }

        return -1;
	}
}
