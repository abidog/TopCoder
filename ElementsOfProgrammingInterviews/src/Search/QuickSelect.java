package Search;

public class QuickSelect {
    public int quickSelect(int[] arr, int k) {
        k = arr.length - k;
        return partition(arr, 0, arr.length - 1, k);
    }

    public int partition(int[] arr, int l, int r, int k) {
        int pivot = arr[r];

        int left = l;
        int right = r;
        while (l < r) {

            while (l < r && arr[l] < pivot) {
                l++;
            }
            while ( r > l && arr[r] >= pivot) {
                r--;
            }
            swap(arr, l, r);
        }
        swap(arr, right, l);
        if (l + 1 == k) {
            return arr[l];
        } else if (l + 1 < k) {
            return partition(arr, l + 1, right, k);
        } else {
            return partition(arr, left, l - 1, k);
        }
    }

    private void swap(int[] num, int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }

}
