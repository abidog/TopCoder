import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class P8XMatrixTransformation {
	
	public String solve(String[] original, String[] target) {
        int ori = 0;
        int tar = 0;
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length(); j++) {
                if (original[i].charAt(j) == '1') {
                    ori++;
                }
                if (target[i].charAt(j) == '1') {
                    tar++;
                }
            }
        }
        if (tar == ori) {
            return "YES";
        } else {
            return "NO";
        }

	}
}
