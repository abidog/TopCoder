import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumOfSubarrayOfSizeK {

    public int[] maxOfSubarrayOfSizeK(int[] arr, int k) {
        // 1 2 3 4 5 6
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        int[] result = new int[arr.length - k + 1];
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        int max = maxHeap.peek();
        int i = k;
        for ( ;i < arr.length; i++) {
            // 1 2 3 4
            result[i - k] = maxHeap.peek();
            maxHeap.add(arr[i]);
            if (i - k >= 0) {
                maxHeap.remove(arr[i - k]);
            }
        }
        result[i - k] = maxHeap.peek();
        return result;
    }
}
