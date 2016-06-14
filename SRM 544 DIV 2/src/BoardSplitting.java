import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class BoardSplitting {
	
	public int minimumCuts(int desiredLength, int desiredCount, int actualLength) {

        if (desiredLength % actualLength == 0) {
            return 0;
        }

        int cut = 0;
        int current = actualLength;
       while (desiredCount > 0) {

           if (desiredLength == current) {
               desiredCount--;
               current = actualLength;
           } else if (current > desiredLength) {
               cut++;
               desiredCount--;
               current -=desiredLength;
           } else if (current < desiredLength) {
               current += actualLength;
           }


       }
        return cut;

	}


}
