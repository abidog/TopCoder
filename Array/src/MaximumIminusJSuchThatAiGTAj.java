public class MaximumIminusJSuchThatAiGTAj{
    public int findMaxiandj(int [] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n- 1] = arr[n - 1];

        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.min(left[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int i = 0;
        int j = 0;
        int max = 0;
        while (i < n && j < n) {
            if (left[i] < right[j]) {
                j += 1;
                max = Math.max(max, j - i);
            } else {
                i += 1;
            }
        }

        return max;
    }
}
