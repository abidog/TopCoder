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
    // 0 7
    // 1 6
    // 2 5
    // 3 4
    // 4 3
    // 5 2
    // 6 1

    // 7 + par (0, 7)
    // 6 + pari (1, 6)
    // 5 + par (2,5)
    // 4 + par (3,4)
    // 3 + par (4,3)

    public static void main(String[] args) {
        IntegerPartition ip = new IntegerPartition();
        //int N = Integer.parseInt(args[0]);
        int N = 7;
        List<List<Integer>> res = new ArrayList<>();
        ip.partition(N, N, res, new ArrayList<>());
        System.out.println("selam");
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
