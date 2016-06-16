import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class EasyConversionMachine {
	
	public String isItPossible(String originalWord, String finalWord, int k) {


        if (originalWord.length() != finalWord.length()) {
            return "IMPOSSIBLE";
        }
        int needed =0;
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) != finalWord.charAt(i)) {
                needed++;
            }
        }
        k -= needed;
        if (k == 0 || (k > 0 && k % 2 == 0)) {
            return "POSSIBLE";
        } else {
            return "IMPOSSIBLE";
        }

	}
}
