package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxWindow{
    class Node{
        int time;
        int volume;
        public Node(int t, int v) {
            this.time = t;
            this.volume = v;
        }
    }

    public int getMax(Node[] packets, int ws) {
        if (packets == null || packets.length == 0) {
            return 0;
        }
        int start = 0;
        int mx = 0;
        MaxQ maxQ = new MaxQ();
        for (int i = 0; i < packets.length - 1; i++) {

            while (packets[i + 1].time - packets[start].time <= ws ) {
                maxQ.enqeue(packets[i]);
                mx = Math.max(mx, maxQ.max().volume);
            }
            maxQ.deqeue();
        }

        return mx;
    }

    // sorted nodes, we will use max q

    class MaxQ {
        Deque<Node> main = new ArrayDeque<>();
        Deque<Node> helper = new ArrayDeque<>();

        public void enqeue(Node node) {
            main.addLast(node);
            while (!helper.isEmpty() && helper.peekLast().volume < node.volume) {
                helper.removeLast();
            }
            helper.addLast(node);
        }

        public Node deqeue() {
            if (main.isEmpty()) {
                return null;
            }
            Node key = main.removeLast();
            if (key == helper.peekFirst()) {
                helper.removeFirst();
            }
            main.removeFirst();
            return key;
        }

        public Node max() {
            if (helper.isEmpty()) {
                return null;
            }
            return helper.peekFirst();
        }
    }
}

