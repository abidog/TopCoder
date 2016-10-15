package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQ{
    Deque<Integer> main = new ArrayDeque<>();
    Deque<Integer> maxq = new ArrayDeque<>();

    public void enqueu(int i) {
        while ( !maxq.isEmpty() && maxq.peek() < i) {
            maxq.removeLast();
        }
        maxq.addLast(i);
        main.addLast(i);
    }
    public int dequeu() {
        int key = main.peek();
        if (key == maxq.peek()) {
            maxq.removeFirst();
        }
        main.removeFirst();
        return key;
    }
    public int max() {
        if (!maxq.isEmpty()) {
            return maxq.peek();
        }
        return -1;
    }
}

