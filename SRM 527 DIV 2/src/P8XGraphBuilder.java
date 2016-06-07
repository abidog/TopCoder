import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class P8XGraphBuilder {

    public static void main(String[] args) {
        int[] scores = new int[] {0, 0, 0, 10};
        P8XGraphBuilder grap = new P8XGraphBuilder();
        System.out.println(grap.solve(scores));

    }

	public int solve(int[] scores) {
        int N = scores.length + 1;
        List<List<Integer>> result = new ArrayList<>();
        // 2N - 2) max degree, we give each node a edge, there are N - 1 edges.
        // so we have N-1 numbers to each node, we only habe N-1 number to distribute to N nodes. maximum each node
        // will have N-2 node remaining since we already assing 1 edge.
        partition(N-2, N-2, result, new ArrayList<Integer>());
        int best = 0;

        for (List<Integer> candid : result) {
            best = Math.max(best, score(candid, scores));
        }
        return best;
	}

    private void partition(int n, int max, List<List<Integer>> result, List<Integer> prefix) {
        if (n == 0) {
            result.add(prefix);
            return;
        }

        for (int i = Math.min(n, max); i >= 1 ; i--) {
            List<Integer> list = new ArrayList<>(prefix);
            list.add(i);
            partition(n - i, i, result, list);
        }

    }

    public int score(List<Integer> p, int [] scores) {
        int sc = 0;
        int zeros = scores.length + 1- p.size();
        sc += scores[0] * zeros;

        for (int i : p) {
            sc += scores[i];
        }
        return sc;
    }


}
