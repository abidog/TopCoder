import java.util.Comparator;
import java.util.PriorityQueue;

public class MedHeap {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedHeap() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
    }

    //  1 2 3 4 5 6 7
    public void add(int i) {
        maxHeap.add(i);

        while(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    public void remove(int i) {
        if (minHeap.contains(i)) {
            minHeap.remove(i);
        } else {
            maxHeap.remove(i);
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        } else
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }

    }
    public double getMed() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)maxHeap.peek();
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

}
