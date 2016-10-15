public class PositiveNegativeAlternating {
    public void alternate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int neg = 0;
        int pos = 0;
        for (int i : arr) {
            if (i < 0) {
                neg++;
            }
            if (pos > 0) {
                pos++;
            }
        }
        boolean negStart = neg >= pos ;

        int l = partition(arr);
        boolean alternate = true;
        for (int i = 0; i < l; i++) {
            if (negStart && i == 0) {
                continue;
            }
            if (alternate) {
                swap(arr, i, l);
                l++;
            }
            alternate = !alternate;

        }
    }

    public int partition(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (l < r && arr[l] <= 0) {
                l++;
            }
            while (l < r && arr[r] > 0) {
                r--;
            }

            if (l < r) {
                swap(arr, l, r);
            }
        }
        return l;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
