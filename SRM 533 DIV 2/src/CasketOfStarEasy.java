import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class CasketOfStarEasy {

    public static void main(String[] args) {
        CasketOfStarEasy casket = new CasketOfStarEasy();
        int[] weight = {1,2,3,4};
        System.out.println(casket.maxEnergy(weight));
    }

	int max = 0;
	public int maxEnergy(int[] weight) {

        List<Integer> pos = new ArrayList<>();
        for (int i : weight){
            pos.add(i);
        }

        solve(pos, 0);
        return max;
	}

    private void solve(List<Integer> pos, int cur) {

        if (pos.size() == 2) {
            max = Math.max(max, cur);
            return ;
        }
        // choose ith star
        for (int i = 1; i < pos.size() - 1 ; i++) {
            List<Integer> copy = new ArrayList<>(pos);
            copy.remove(i);
            solve(copy, cur + pos.get(i - 1) * pos.get(i + 1));

        }


    }
}
