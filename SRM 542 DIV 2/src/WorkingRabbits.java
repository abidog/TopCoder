import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class WorkingRabbits {
	
	public double getEfficiency(String[] profit) {

        double total = 0;
        boolean[][] paired = new boolean[profit.length][profit.length];
        int pairs = 0;
        for (int i = 0; i < profit.length; i++) {
            int mx = 0;


            for (int j = i + 1; j < profit[i].length(); j++) {
                int eff = profit[i].charAt(j) - '0';

                    total += eff;
                    pairs++;

            }


        }

        return (total)/pairs;
	}
}
