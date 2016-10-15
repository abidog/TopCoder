public class MinimumSortedWhichSortArray {
    public int[] minimumSortedWhichSortArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int n = arr.length;
        int[] minFromRight = new int[n];
        minFromRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minFromRight[i] = Math.min(arr[i], minFromRight[i + 1]);
        }
        int[] maxFromLeft = new int[n];
        maxFromLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], arr[i]);
        }

        int left = 0;
        int right =  n -1;
        while (arr[left] <= minFromRight[left]) {
            left++;
        }
        while (arr[right] >= maxFromLeft[right]) {
            right--;
        }
        return new int[]{left, right};
    }

}
