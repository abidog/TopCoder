import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MergersDivTwo {
	double max;

    public static void main(String[] args) {
        MergersDivTwo merge = new MergersDivTwo();
        int[] revenues = new int[] {-981, -972, -963, -948, -946, -928, -927, -908, -902, -896, -895, -890, -882, -874, -874, -855, -826, -777, -770, -750, -728, -690, -621, -598, -575, -555, -497, -485, -481, -477, -463, -446, -402, -300, -296, -255, -236, -221, -203, -166, -143, -119, -113, -109, -85, -26, -26, -21, -9, 51};
        int k = 3;
        System.out.println(merge.findMaximum(revenues, k));
    }

	public double findMaximum(int[] revenues, int k) {

        double[] dp = new double[51];
        Arrays.fill(dp, -50001);
        Arrays.sort(revenues);
        for (int i = 0; i < revenues.length; i++) {
            if (i == 0) {
                dp[i] = revenues[0];
            } else {

                double sum = revenues[i];
                for (int j = i - 1; j >= 0 ; j--) {

                    if (i - j + 1 >= k) {
                        if ((sum + dp[j]) / (double)(i - j + 1) > dp[i]) {
                            dp[i] = (sum + dp[j]) / (double)(i - j + 1);
                        }

                    }
                    sum += revenues[j];

                }


            }
        }

        return dp[revenues.length - 1];
	}

    public double sum(List<Double> list) {
        double res = 0;
        for (double d : list) {
            res += d;
        }
        return  res;
    }

    private List<Double> getSum(List<Double> list, int count) {
        double sum = 0;
        int cp = count;
        while (count-- > 0) {
            sum += list.remove(0);
        }
        list.add(sum/(double)(cp));
        Collections.sort(list);
        return list;
    }

    private void solve(List<Double> list, int k) {
        if (list.size() == k) {
            max = Math.max(max, sum(list)/k);
            return;
        }
        if (list.size() == 1) {
            max =  Math.max(max, list.get(0));
            return;
        }
        if (list.size() < k) {
            return;
        }

        for (int i = k; i <= list.size() ; i++) {
            List<Double> copy = new ArrayList<>(list);
            copy = getSum(copy, i);
            solve(copy, k);
        }





    }
}
