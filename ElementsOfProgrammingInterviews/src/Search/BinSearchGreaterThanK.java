package Search;

public class BinSearchGreaterThanK {
    public int search(int[] arr , int k) {
        if (arr == null || arr.length == 0 || arr[arr.length - 1] <= k) {
            return -1;
        }

        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (arr[m] > k) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return h;
    }

}
