import java.util.ArrayList;
import java.util.List;

public class IntegerPartition {

    public void partition2(int n) {
        partition2(n, n, "");
    }
    public  void partition2(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            partition2(n-i, i, prefix + " " + i);
        }
    }


    public static void main(String[] args) {
        IntegerPartition ip = new IntegerPartition();
        int N = Integer.parseInt(args[0]);
        ip.partition2(N);
    }


    // parition is returned in the result list.

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
}
