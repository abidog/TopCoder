public class MaximumSubArraySum{
    public int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = Math.max(arr[i], arr[i] + sum[i - 1]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}
