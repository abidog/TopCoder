import java.util.Arrays;

public class ArrayConsecutiveNumber {

    public boolean isConsecutive(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
