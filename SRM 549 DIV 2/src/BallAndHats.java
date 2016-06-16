import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class BallAndHats {
	
	public int getHat(String hats, int numSwaps) {

        int index = hats.indexOf("o");
        if (numSwaps == 0) {
            return index;
        }
        if (numSwaps == 1) {
            if (index == 0 || index == 2) {
                return 1;
            } else {
                return 0;
            }
        }

        if (index == 0 || index == 2) {
            if (numSwaps % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (numSwaps % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }


	}
}
