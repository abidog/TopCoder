package Arrays;

import java.util.Collections;

public class NextPerm {
    public int[] next(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int p = arr.length - 1;
        for ( ; p > 0 && arr[p - 1] >= arr[p]; p--);
        if (p == 0) {
            return null;
        }
        int q = arr.length - 1;

        for (; q > p -1 && arr[q] <= arr[p - 1]; q--);

        swap(arr, p - 1, q);

        int l = p;
        int r = arr.length - 1;
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
