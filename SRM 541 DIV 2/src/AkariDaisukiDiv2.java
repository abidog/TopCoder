import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class AkariDaisukiDiv2 {
	
	public int countTuples(String S) {
        int count = 0;
        for (int i = 1; i < S.length() - 1 ; i++) {

            for (int j = i + 1; j < S.length() ; j++) {

                // j is not included
                String x = S.substring(i, j);

                for (int k = j + 1; k < S.length() - 1 ; k++) {
                    for (int l = k + 1; l < S.length(); l++) {
                        String candid = S.substring(k, l);

                        if (x.equals(candid)) {
                            count++;
                        }

                    }
                }
            }


        }

        return count;
	}
}
