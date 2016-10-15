public class MaximumSubSeqThree {

    public int getMaxSubSeq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int[] left = new int[n];
        left[1] = arr[1];
        int[] right = new int[n];
        right[n - 1] = arr[n - 1];
        for (int i = 2; i < arr.length; i++) {
            left[i] = Math.max(arr[i - 1], left[i - 1]);
        }
        right[n - 2] = arr[n - 1];
        for (int i = n - 3; i >= 0 ; i--) {
            right[i] = Math.max(right[i + 1], arr[i + 1]);
        }
        int max = 0;
        for (int i = 1; i < n -1 ; i++) {
            if (left[i] < arr[i] && right[i] > arr[i]) {
                max = Math.max(max, left[i]);
            }
        }

        return max;
    }

}
