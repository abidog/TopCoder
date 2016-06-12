import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class BinaryPolynomialDivTwo {
	
	public int countRoots(int[] a) {


        int res = 0;
        int count = a[0];
        if (count % 2 == 0) {
            res++;
        }
        for (int i = 1; i < a.length; i++) {
            count += a[i] * 1;
        }
        if (count % 2 == 0) {
            res++;
        }


        return res;
	}
}
