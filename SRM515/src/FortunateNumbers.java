// start : 2:20pm
// end :  2:26pm
import java.util.*;
public class FortunateNumbers {

    public static void main(String[] args) {

        int[] a = { 500, 800 };
        int[] b = { 50, 80 };
        int[] c = { 5, 8 };
        FortunateNumbers fn = new FortunateNumbers();
        System.out.println(fn.getFortunate(a,b,c));
    }

    public int getFortunate(int[] a, int[] b, int[] c) {

        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    if (isFortunate(a[i] + b[j] + c[k])) {
                        nums.add(a[i] + b[j] + c[k]);
                    }
                }
            }
        }

        return nums.size();

    }

    public boolean isFortunate(int i) {
        while (i > 0) {
            int last = i % 10;
            if (last != 8 && last != 5) {
                return false;
            }
            i /=10;
        }
        return true;
    }
}

