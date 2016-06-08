import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MinskyMysteryDiv2 {

    public long computeAnswer(long N) {
        if (N<2) return -1;
        for (long i=2; i*i<=N; ++i) if (N%i==0) return i+(N/i);
        return N+1;
    }
}
