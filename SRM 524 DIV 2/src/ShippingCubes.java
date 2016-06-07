import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class ShippingCubes {
	
	public int minimalCost(int N) {


        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                for (int k = 0; k < 200; k++) {
                    if (i * j * k == N) {
                        min = Math.min (min, i + j + k);
                    }
                }
            }
        }

        return min;
	}
}
