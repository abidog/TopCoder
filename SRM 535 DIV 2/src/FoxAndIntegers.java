import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class FoxAndIntegers {
	
	public int[] get(int AminusB, int BminusC, int AplusB, int BplusC) {

        int A  = (AminusB + AplusB) /2;
        int B = AplusB - A;
        int C = BplusC - B;

        if (AminusB == A - B  && B - C == BminusC && AplusB == (A + B) && BplusC == (B + C)) {
            return new int[]{A,B,C};
        }
        return new int[]{};
	}
}
