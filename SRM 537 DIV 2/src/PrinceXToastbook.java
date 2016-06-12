import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PrinceXToastbook {
	
	public double eat(int[] prerequisite) {


        double ret = 0;

        for (int i = 0; i < prerequisite.length; i++) {

            double prob = 1;
            boolean[] visit = new boolean[prerequisite.length];
            int needs = 0;
            for (int j = i; j != -1 ; j = prerequisite[j]) {

                if (visit[j]) {
                    prob = 0;
                    break;
                }
                visit[j] = true;
                needs++;
                prob *= 1.0/(double)(needs);
            }
            ret += prob;
        }

        return ret;
	}
}
