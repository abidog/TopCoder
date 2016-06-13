import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class PlatypusPaternity {
	
	public int maxFamily(String[] femaleCompatibility, String[] maleCompatibility, String[] siblingGroups) {
        int max = 0;

        for (int i = 0; i < siblingGroups.length; i++) {
            String sib = siblingGroups[i];

            int num = 0;
            List<Integer> index = new ArrayList<>();
            for (int j = 0; j < sib.length(); j++) {
                if (sib.charAt(j) == 'Y') {
                    num++;
                    index.add(j);
                }

            }

            boolean isGood = true;
            for (int j = 0; j < femaleCompatibility.length; j++) {
                isGood = true;
                for (int k = 0; k < maleCompatibility.length; k++) {

                    for (int s : index) {
                       if (femaleCompatibility[j].charAt(s) == 'N' || maleCompatibility[k].charAt(s) == 'N') {
                           isGood = false;
                           break;
                       }
                    }
                    if (isGood) {
                        break;
                    }
                    if (k != maleCompatibility.length - 1) {
                        isGood = true;
                    }

                }
                if (isGood) {
                    max = Math.max(max, num + 2);
                    break;
                }
            }
        }

		return max;
	}
}
