import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class StrangeDictionary {
	
	public double[] getExpectedPositions(String[] words) {


        double [] p = new double[words.length];

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length ; j++) {
                double dif = 0;
                double jWin = 0;

                for (int k = 0; k < words[j].length(); k++) {

                    if (words[i].charAt(k) < words[j].charAt(k)) {
                        jWin++;
                    }
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        dif++;
                    }

                }

                p[i] += (dif - jWin) / dif;
                p[j] += jWin / dif;

            }
        }

        return p;
	}
}
