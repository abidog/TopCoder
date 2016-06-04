import java.util.Arrays;

public class MarbleDecoration {
    public int maxLength(int R, int G, int B) {
        int[] arr = new int[]{R, G, B};
        Arrays.sort(arr);
        if (arr[1] == arr[2]) {
            return arr[1] * 2;
        } else {
            return arr[1] *2 + 1;
        }
    }
}
