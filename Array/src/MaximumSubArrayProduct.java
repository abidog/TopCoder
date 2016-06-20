public class MaximumSubArrayProduct{
    public int maximumSubArraySum(int[] arr) {
        int[] min = new int[arr.length];
        int[] max = new int[arr.length];
        min[0] = max[0] = arr[0];
        int result = max[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                max[i] = Math.max(max[i - 1] * arr[i], arr[i]);
                min[i] = Math.min(min[i - 1] * arr[i], arr[i]);
            } else {
                min[i] = Math.min(max[i - 1] * arr[i], arr[i]);
                max[i] = Math.max(min[i - 1] * arr[i], arr[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}
