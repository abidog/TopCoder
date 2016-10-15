import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution31 {

    static class Node{
        int id;
        List<Node> to;

        public Node(int id) {
            this.id = id;
            to = new ArrayList<>();
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

                //graph.get(to).to.add(graph.get(from));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : graph.keySet()) {
            min = Math.min(min, graph.get(i).to.size());
            max = Math.max(max, graph.get(i).to.size());

        }

        System.out.println("Minimum degree :" + min);
        System.out.println("Maximum degree: "+ max);

    }
}
