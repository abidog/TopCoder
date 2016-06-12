import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class RollingDiceDivTwo {
	
	public int minimumFaces(String[] rolls) {

        char[][] roll = new char[rolls.length][];

        for (int i = 0; i < rolls.length; i++) {
            roll[i] = rolls[i].toCharArray();
            Arrays.sort(roll[i]);
        }
        int sum = 0;
        for (int i = 0; i < rolls[0].length(); i++) {
            int max = 0;
            for (int j = 0; j < rolls.length; j++) {
                max = Math.max(roll[j][i] - '0', max);
            }
            sum += max;
        }


        return sum;
	}
}
