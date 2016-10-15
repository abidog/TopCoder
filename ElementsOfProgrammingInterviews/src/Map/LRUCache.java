package Map;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }

    }
    Node head = null;
    int cap;
    int size;
    Map<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
        size = 0;
    }

    public int get(int key) {
        if (head == null) {
            return -1;
        }


        if (head.key == key) {
            return head.val;
        }
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
        return head.val;
    }

    public void set(int key, int value) {
        if (head == null) {
            head = new Node(key, value);
            map.put(key, head);
        } else {

            if (get(key) != -1){
                removeNode(key);
                size--;
            }

            Node newHead = new Node(key, value);
            if (size == cap) {
                removeTail();
                size--;
            }
            if (head != null) {
                newHead.next = head;
                head.prev = newHead;
            }
            head = newHead;
            map.put(key, newHead);


        }
        size++;
    }
    private void removeNode(int key) {
        if (head == null) {
            return;
        }
        if (head != null && head.key == key) {
            map.remove(key);
            head = head.next;
            head.prev = null;
        } else {
            if (map.containsKey(key)) {
                Node cur = map.get(key);
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }
            map.remove(key);
        }
    }
    private void removeTail() {
        if (head == null || head.next == null) {

            if (head != null) {
                map.remove(head.key);
            }
            head = null;

        } else {
            Node cur = head;
            Node prev = null;
            while (cur.next != null) {
                prev = cur;
                cur = cur.next;
            }
            map.remove(cur.key);
            prev.next = null;
        }
    }
}