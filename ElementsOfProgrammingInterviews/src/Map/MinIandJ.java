package Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinIandJ {
    class Node{
        String word ;
        int index;
        public Node(String w, int i) {
            word = w;
            index = i;
        }
        public int hashCode() {
            int hash = 373;
            return hash;
        }
        public boolean equals(Object o) {
            Node other = (Node) o;
            return other.word.equals(this.word);
        }
    }
    public int[] minIandJ(String[] A, String[] Q) {
        int[] res = new int[]{};
        if (A == null || Q == null || A.length == 0 || Q.length == 0) {
            return res;
        }
        Comparator<Node> nodeComp  = new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n1.index - n2.index;
            }
        };

        PriorityQueue minHeap = new PriorityQueue<Node>(nodeComp);
        boolean ever = false;
        Map<String,Boolean> mapQ = new HashMap<>();
        for (String s : Q) {
            mapQ.put(s, true);
        }
        int minI = 0;
        int minJ = A.length - 1;

        for (int i = 0; i < A.length; i++) {


            if (mapQ.containsKey(A[i])) {
                Node input = new Node(A[i], i);
                if (minHeap.contains(input)) {
                    minHeap.remove(input);
                }
                minHeap.add(input);
            }

            if (minHeap.size() == mapQ.size()) {
                if (minJ - minI > i - ((Node)(minHeap.peek())).index) {
                    minI = ((Node)(minHeap.peek())).index;
                    minJ = i;
                    ever = true;
                }
            }
        }
        return ever ? new int[]{minI, minJ} : res;
    }
}

