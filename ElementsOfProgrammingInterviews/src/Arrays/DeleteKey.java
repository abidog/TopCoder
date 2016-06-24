package Arrays;

public class DeleteKey {
    public int[] delete(int[] arr, int k) {
        int i = 0;
        while (i < arr.length && arr[i] != k) {
            i++;
        }
        int start = i;
        while (i < arr.length && arr[i] == k) {
            i++;
        }
        int end = i;
        int j  = 0;
        for (j = start; end < arr.length; end++, j++) {
            arr[j] = arr[end];
        }
        int[] result = new int[j];
        for (int y = 0; y < j; y++) {
            result[y] = arr[y];
        }
        return result;

    }
}
