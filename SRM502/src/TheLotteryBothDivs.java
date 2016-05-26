
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
// start 7:34pm
// end  7:46pm
public class TheLotteryBothDivs {

    public static void main(String[] args) {
        TheLotteryBothDivs lotter = new TheLotteryBothDivs();
        String[] goodSuffixes = {"8542861", "1954", "6", "523", "000000000", "5426", "8"};
        System.out.println(lotter.find(goodSuffixes));
    }

    public double find(String[] goodSuffixes) {
        Set<String> suff = new HashSet<>();
        for (int i = 0; i < goodSuffixes.length; i++) {
            suff.add(goodSuffixes[i]);
        }
        ;

        // clean up
        List<String> toBeRemoved = new ArrayList<>();
        for (String s : suff) {

            for (int i = 1; i < s.length(); i++) {
                String sub = s.substring(i);
                if (suff.contains(sub)) {
                    toBeRemoved.add(s);
                    break;
                }
            }

        }

        suff.removeAll(toBeRemoved);
        double res = 0;
        for (String s : suff) {
            res += 1.0 / (Math.pow(10, s.length()));
        }

        return res;

    }
}
