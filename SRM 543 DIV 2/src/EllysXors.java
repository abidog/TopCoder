import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class EllysXors {


    public long xorN(long x) {

        if (x % 4 == 0) {
            return x;
        } else if (x % 4 == 1) {
            return 1;
        } else if (x % 4 == 2) {
            return x + 1;
        } else {
            return 0;
        }
    }

	public long getXor(long L, long R) {


        return xorN(L-1) ^ xorN(R);
	}
}
