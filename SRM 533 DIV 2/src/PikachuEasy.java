import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PikachuEasy {
	
	public String check(String word) {
        String w1 = "pi";
        String w2 = "ka";
        String w3 = "chu";
        Map<String, Boolean> map = new HashMap<>();
        map.put(w1, true);
        map.put(w2,true);
        map.put(w3, true);
        for (int i = 0; i < word.length();) {
            String word1 = word.substring(i, Math.min(i + 2, word.length()));
            String word2 = word.substring(i, Math.min(i + 3, word.length()));
            if (map.containsKey(word1)) {
                i = i + 2;
            } else if (map.containsKey(word2)) {
                i = i + 3;
            } else {
                return "NO";
            }

            if (i == word.length()) {
                return "YES";
            }

        }
        
        
        return null;
	}
}
