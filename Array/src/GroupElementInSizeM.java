import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
// Group elements in size m such that in every group does not have all the same elements.
public class GroupElementInSizeM{
    class Node{
        int key;
        int freq;
        public Node(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        GroupElementInSizeM groupElementInSizeM = new GroupElementInSizeM();
        int[] intArray =  {2,1,1,1,3,4,4,4,5,5,5,5,7,7,8,8,8,9,9,9,9};
        int[] expected = {1,1,4,1,1,4,1,1};
        intArray = groupElementInSizeM.groupinSizeM(intArray, 2);
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+" ");
        }
    }

    public int[] groupinSizeM(int[] intArray, int M) {
        if (intArray == null || intArray.length == 0) {
            return intArray;
        }
        Comparator<Node> nodeComp = new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.freq - n1.freq;
            }
        };
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(nodeComp);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : intArray) {
            if (freqMap.containsKey(i)) {
                freqMap.put(i, freqMap.get(i) + 1);
            } else {
                freqMap.put(i, 1);
            }
        }
        for (int key : freqMap.keySet()) {
            maxHeap.add(new Node(key, freqMap.get(key)));
        }
        int pointer = 0;

        while (!maxHeap.isEmpty()) {

            Node v = maxHeap.poll();
            int maxPossible = (pointer != 0 && v.key == intArray[pointer - 1]) ? M - 1 : M;
            for (int i = 0; i < Math.min(maxPossible, v.freq); i++) {
                intArray[pointer++] = v.key;
            }
            v.freq -= Math.min(maxPossible, v.freq);
            if (v.freq > 0) {
                if (maxHeap.isEmpty()) {
                    return null;
                }
                Node next = maxHeap.poll();
                intArray[pointer++] = next.key;
                next.freq--;
                if (next.freq > 0) {
                    maxHeap.add(next);
                }
                maxHeap.add(v);
            }

        }
        return intArray;
    }

}

