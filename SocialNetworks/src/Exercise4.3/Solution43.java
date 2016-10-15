import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution43 {

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


        Set<String> edgesToRemove = new HashSet<>();

        for (int i :graph.keySet()) {

            Set<Node> to = graph.get(i).to;

            for (Node toNode : to) {
                if (!isStrongTie(i, toNode.id, graph)) {
                    edgesToRemove.add(i +" "+ toNode.id);
                    edgesToRemove.add(toNode.id +" "+i);
                }
            }

        }

        Map<Integer, Node> strongGraph = new HashMap<>();

        for (int i : graph.keySet()) {
            Node node = new Node(i);
            strongGraph.put(i, node);
            for (Node adj : graph.get(i).to) {
                if (!edgesToRemove.contains(i+" "+ adj.id)) {
                    if (!strongGraph.containsKey(adj.id)) {
                        strongGraph.put(adj.id, new Node(adj.id));
                    }
                    strongGraph.get(i).to.add(strongGraph.get(adj.id));
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int numberOfConnectedCompOriginal = 0;
        int numberNodeInLargestConnectedOriginal = 0;
        int numberOfConnectedCompStrong = 0;
        int numberNodeInLargestConnectedStrong = 0;
        for (int i : graph.keySet()) {

            if (!visited.contains(i)) {
                numberOfConnectedCompOriginal++;
                numberNodeInLargestConnectedOriginal = Math.max(numberNodeInLargestConnectedOriginal, dfs(visited, i, graph));
            }

        }
        visited.clear();

        for (int i : strongGraph.keySet()) {
            int before = visited.size();
            if (!visited.contains(i)) {
                numberOfConnectedCompStrong++;
                dfs(visited, i, strongGraph);
                //numberNodeInLargestConnectedStrong = Math.max(numberNodeInLargestConnectedStrong, dfs(visited, i, strongGraph));
                int after = visited.size();
                numberNodeInLargestConnectedStrong = Math.max(numberNodeInLargestConnectedStrong, after - before);
            }



        }


        System.out.println("The number of connected components originally: " + numberOfConnectedCompOriginal);
        System.out.println("The number of connected components without weak ties: "+ numberOfConnectedCompStrong);
        System.out.println("The number of nodes in the largest connected component originally: "+ numberNodeInLargestConnectedOriginal);
        System.out.println("The number of nodes in the largest connected component without weak ties: "+ numberNodeInLargestConnectedStrong);
    }

    private static int dfs(Set<Integer> v, int start, Map<Integer, Node> graph) {
        v.add(start);
        int res = 1;
        for (Node adj : graph.get(start).to) {
            if (!v.contains(adj.id)) {
                res += dfs(v, adj.id, graph);
            }
        }
        return res;
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
