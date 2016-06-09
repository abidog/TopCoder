import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class TheArithmeticProgression {
	
	public double minimumChange(int a, int b, int c) {
		
        
        double min = Integer.MAX_VALUE;
        // b -a = c - b
        // 2b = a + c
        for (int i = 0; i < 1001 ; i++) {
            // 2b = a + c

        }

        int difBa = b - a;
        int difCb = c - b;


        return Math.abs((double)(difCb - difBa) / 2.0);
	}
}
