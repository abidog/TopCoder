package Arrays;

import java.util.Arrays;

public class MaxProduct {

    public int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] output = new int[arr.length];
        int[] right = new int[arr.length];
        Arrays.fill(output, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < output.length; i++) {
            output[i] = arr[i - 1] * output[i - 1];
        }
        for (int i = output.length - 2; i >= 0; i--) {
            right[i] = arr[i + 1] * right[i + 1];
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, output[i] * right[i]);
        }
        return max;
    }
}

