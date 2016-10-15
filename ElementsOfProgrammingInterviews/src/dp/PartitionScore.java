package dp;

import java.util.ArrayList;
import java.util.List;

public class PartitionScore {
    public List<String> getTrace(int[] w, int s) {
        List<String> result = new ArrayList<>();

        partition(w, 0, s, result, "");
        return result;
    }

    private void partition(int[]w, int cur, int s, List<String>result, String res) {
        if (cur == s) {
            result.add(res);
            return;
        }
        if (cur > s) {
            return;
        }
        for (int i = 0; i < w.length; i++) {
            partition(w, cur + w[i], s, result, res + " "+w[i]);
        }
    }

}
