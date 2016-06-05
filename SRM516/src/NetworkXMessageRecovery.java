import java.util.*;

public class NetworkXMessageRecovery {

    public static void main(String[] args) {
        NetworkXMessageRecovery rec = new NetworkXMessageRecovery();
        String[] messages = 	{"PYFHWkbrjvJADTKeBiGmQSM", "yZYLHWkblCqrjdufNDKehoBpiRm", "yZXFLWbCwdzsJOBpciRm", "XYFLWktblCqrjvUdzuKhoBiR", "IPFHblvUdzuNOVxTKhBpciRmM", "yZXYWblrjvzsuNODTKehoBpiSMg", "IyatCqvUAOVxDKehoiGmQSM", "PYHWkbwrjvJANOxDThBQSMg", "IPXYLktlqrsfOxhiRGmQSMg", "IyZYFktblwqvduAOcGQMg", "yZFHktCqrjvzuAOxDociRmM", "XYLWaktblCqdJfANxhoBRGSg", "yZLtbCwqvUsJANOVxKehoBimQSg", "PyXLWatCwvdufAVxDBciRGg", "yYLHblwqrUzuJAVDBpcim", "XYFLWbCrvUdsufANOVxDTKeoBcRQS", "yZXYFWktbCrjzuJANepiRM", "IPZXYLkblCwrjvduJfANTehBpcimQS", "yYLHWabwqjvUdzsfVxTKeciRGm", "PyZXYLbwrjzJANOVoBciRGmQSM", "yZLtblCqrUuJfNODKocmQSg", "PyZXYLHWatblwqrjvzsANOVTKehBimQg", "IPyZYLWatCwqjdsNxhoBpcRG", "IPZXLHWalCvUdzsNxTKeoBpciRSMg", "IPyYatblCwrjvUdsAKhoiGmSM", "IPyZXYWtblqvUdzsuANOxDhBciGmMg", "IyXFHWkqvzJNOVhoBcmQSM", "IZXYFLHaqrzuOxTKehpiGm", "IPyXFLtbljvUsANOxDKepcRSg", "PyXHtbqrvUdsJNVxKoBRmQS", "IPLHWaktbwrjUdsuJANKBpRGQSM", "yYHWajzufOVDhopiRG", "ZXYFLbwqjzsJfAxToBGQSMg", "IPyZFWatblCwqsufANVxDKhoiRGM", "yZXYFaktlwrjvdsuJfAOVxDhociRmQSg", "PyZXLWkbCjvuJfANOxTKoBpcGmMg", "IyZXFLHakblwqjvUJANxhBmQSg", "IyZXYFLablCwrjvUzuJfADoGQ", "IyXakbqrUdsJANxDTBciGmM", "ZHWablwjuJVDTecRmSMg", "IZHalCjvUdzuJANxeoRQSMg", "IyZLaCwqdzsuJfANThociGQSM", "XFLHtlCqrvUdfNTKehBpRSMg", "LHWqrdJANDTKcimQg", "PZaktwdzfANVxDKehBcimg", "PyZYHWatCwqrvdzsuAVxTKhoBcGmS", "IZYLktCwrjUzufNOxDTBpGQSg", "XHakbCqjzuJANOVDcimS", "PyXFHtblqvUdsJfANDThopRGmQSMg", "IyXLHWtwqrjsJfOxKhBpimSMg"};
        System.out.println(rec.recover(messages));
    }
    class Node{
        char val;
        List<Node> adj = new ArrayList<>();
        public Node(char c) {
            this.val = c;
        }
    }
    public String recover(String[] messages) {
        Map<Character, Node> mapToNode = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String mes = messages[i];
            if (mes.length() == 1) {
                if (mapToNode.containsKey(mes.charAt(0))) {
                    continue;
                } else {
                    mapToNode.put(mes.charAt(0), new Node(mes.charAt(0)));
                }

            }
            for (int j = 0; j < mes.length() - 1; j++) {
                char from = mes.charAt(j);
                char to = mes.charAt(j + 1);
                Node fromNode = null;
                Node toNode = null;
                if (mapToNode.containsKey(from)) {
                    fromNode = mapToNode.get(from);
                }
                if (mapToNode.containsKey(to)) {
                    toNode = mapToNode.get(to);
                }
                if (fromNode == null) {
                    fromNode = new Node(from);
                    mapToNode.put(from, fromNode);
                }
                if (toNode == null) {
                    toNode = new Node(to);
                    mapToNode.put(to, toNode);
                }
                fromNode.adj.add(toNode);
            }
        }


        Stack<Character> order = new Stack<>();
        Map<Character, Boolean> visited = new HashMap<>();
        List<Character> nodes = new ArrayList<>();
        nodes.addAll(mapToNode.keySet());
        Collections.sort(nodes);
        for (int i = nodes.size() - 1; i >= 0; i--) {
            char c = nodes.get(i);
            if (!visited.containsKey(c)) {
                topSort(visited, order, c, mapToNode);
            }
        }

        String res = "";
        while (!order.isEmpty()) {
            res += order.pop();
        }

        return res;
    }

    private void topSort(Map<Character, Boolean> visited, Stack<Character> order, char v, Map<Character, Node> mapToNode) {
        visited.put(v, true);

        for (Node adj : mapToNode.get(v).adj) {
            if (!visited.containsKey(adj.val)) {
                topSort(visited, order,adj.val, mapToNode );
            }
        }
        order.push(v);

    }
}
