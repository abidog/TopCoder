import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution42 {

    static class Node{
        int id;
        Set<Node> to;

        public Node(int id) {
            this.id = id;
            to = new HashSet<>();
        }
        @Override
        public int hashCode() {
            return id;
        }
        @Override
        public boolean equals(Object o) {
            Node other = (Node)o;
            if (other.id == this.id) {
                return true;
            }
            return false;
        }
    }


    public static void main(String[] args) {
        Map<Integer, Node> graph = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("caGrQc.txt")) ;
            String line = "";
            while ((line = br.readLine()) != null && line.length() != 0 ) {
                line = line.replaceAll("\\s+"," ");

                String[] fromTo = line.split(" ");
                int from = Integer.parseInt(fromTo[0]);
                int to = Integer.parseInt(fromTo[1]);
                if (!graph.containsKey(from)) {
                    graph.put(from, new Node(from));
                }
                if (!graph.containsKey(to)) {
                    graph.put(to, new Node(to));
                }
                if (to != from) {
                    graph.get(from).to.add(graph.get(to));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /*
        Comparator<Node> nodeComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {



                   if (o1.to.size() != o2.to.size()) {
                       return o1.to.size() - o2.to.size();
                   } else {
                       int numberOfStrongTiesNode1 = 0;
                       int numberOfStrongTiesNode2 = 0;
                       int numberOfWeakTiesNode1 = 0;
                       int numberOfWeakTiesNode2 = 0;
                       Set<Node> fromNode = graph.get(o1.id).to;

                       for (Node n : fromNode) {
                           if (isStrongTie(o1.id, n.id, graph)) {
                               numberOfStrongTiesNode1++;
                           } else {
                               numberOfWeakTiesNode1++;
                           }
                       }


                       Set<Node> toNode = graph.get(o2.id).to;

                       for (Node n : toNode) {
                           if (isStrongTie(o2.id, n.id, graph)) {
                               numberOfStrongTiesNode2++;
                           } else {
                               numberOfWeakTiesNode2++;
                           }
                       }
                       if (numberOfStrongTiesNode1 != numberOfStrongTiesNode2) {
                           return numberOfStrongTiesNode1 - numberOfStrongTiesNode2;
                       } else if (numberOfWeakTiesNode1 !=  numberOfWeakTiesNode2) {
                          return numberOfWeakTiesNode1 - numberOfWeakTiesNode2;
                       } else {
                           return o1.id - o2.id;
                       }


                   }
            }
        };

        */

        int numberOfDirectedEdge = 0;
        int numberOfStrongTies = 0;
        int numberOfWeakTies = 0;
        for (int i : graph.keySet()) {
            numberOfDirectedEdge += graph.get(i).to.size();

            Set<Node> adj = graph.get(i).to;
            for (Node n : adj) {
                if (isStrongTie(i, n.id, graph)) {
                    numberOfStrongTies++;
                } else {
                    numberOfWeakTies++;
                }
            }
        }
        System.out.println(" Number of Directed edges : "+ numberOfDirectedEdge);
        System.out.println(" Number of Strong ties : "+ numberOfStrongTies/2);
        System.out.println(" Number of Weak Ties : "+ numberOfWeakTies/2);



    }

    private static boolean isStrongTie(int from, int to, Map<Integer, Node> g) {

        Set<Node> fromNode = g.get(from).to;
        Set<Node> toNode = g.get(to).to;
        for (Node n : fromNode) {
            if (toNode.contains(n)) {
                return true;
            }
        }
        return false;
    }
}
