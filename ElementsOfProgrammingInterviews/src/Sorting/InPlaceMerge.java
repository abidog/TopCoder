package Sorting;

public class InPlaceMerge {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    public void merge(int[] arr, int l, int m, int r1) {
        int left = l;
        int right = m + 1;
        while (left <= m && right <= r1) {
            if (arr[left] <= arr[right]) {
                left++;
            } else {
                int temp = arr[right];
                System.arraycopy(arr, left, arr, left + 1, right - left);
                arr[left] = temp;
                left++;
                m++;
                right++;
            }
        }
    }
}
