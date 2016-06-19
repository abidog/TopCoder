public class KthLargestElem{
    public int getKthLargestElem(int[] arr, int k) {

        return findNthSmall(arr, arr.length - k , 0, arr.length - 1);
    }
    private int findNthSmall(int[] arr, int n, int l, int r) {

        int index = partition(arr, l, r);

        if (index == (n)) {
            return arr[index];
        } else if (index < n) {
            return findNthSmall(arr, n, index + 1, r);
        } else {
            return findNthSmall(arr, n, l, index - 1);
        }


    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int pivotPos = r;
        while (l < r) {
            while (l < r && arr[l] < pivot) {
                l++;
            }

            while (r > l && arr[r] >= pivot) {
                r--;
            }
            if (l == r) {
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

        }
        int temp = arr[l];
        arr[l] = pivot;
        arr[pivotPos] = temp;
        return l;

    }

}