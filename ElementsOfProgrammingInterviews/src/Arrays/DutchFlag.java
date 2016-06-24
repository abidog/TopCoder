package Arrays;

public class DutchFlag{

    public int[] partition(int[] arr, int pi) {
        int n = arr.length - 1;
        swap(arr, pi, n);
        int pivot = arr[n];
        int right = n - 1;
        int left = 0;
        while (left < right) {

            while (left < right && arr[left] < pivot) {
                left++;
            }
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            swap(arr, left, right);
        }
        left = right;
        right = n - 1;
        while (left < right) {
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            while (left < right && arr[right] > pivot) {
                right--;
            }
            swap(arr, left, right);
        }

        swap(arr, left, n);
        return arr;
    }




    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
