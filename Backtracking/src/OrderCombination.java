import java.util.ArrayList;
import java.util.List;

public class OrderCombination {

    public List<List<List<Integer>>> nonOverLapCombination(int[] arr) {
        List<List<List<Integer>>> result = new ArrayList<>();
        List<List<Integer>> current = new ArrayList<>();
        backtrack(arr, 0, current, result);
        return result;
    }
    private void backtrack(int[] arr, int start, List<List<Integer>> current, List<List<List<Integer>>> result) {
        if (start == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            List<Integer> c = new ArrayList<>();

            for (int j = start; j <= i; j++) {
                c.add(arr[j]);
            }
            current.add(c);
            backtrack(arr, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
