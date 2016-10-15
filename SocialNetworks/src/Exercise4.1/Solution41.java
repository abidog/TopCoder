import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution41 {

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

        int from = Integer.parseInt(args[0]);
        int to = Integer.parseInt(args[1]);


        System.out.println(isStrongTie(from, to, graph));

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
