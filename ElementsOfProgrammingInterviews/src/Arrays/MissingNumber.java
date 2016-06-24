package Arrays;

import java.util.PriorityQueue;

public class MissingNumber{
    public int missing(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.add(i);
        }
        if (heap.peek() > 1) {
            return 1;
        }
        int prev = 0;
        while (!heap.isEmpty()) {
            int now = heap.poll();
            if (prev + 1 != now) {
                return prev + 1;
            } else {
                prev = now;
            }
        }
        return prev + 1;
    }
    public int missing2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        int last = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1 && arr[i] <= last && arr[i] != i) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;

            }
        }
        for (int i = 1; i <= last; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr[last] + 1;
    }

}

