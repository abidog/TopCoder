import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution32 {

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
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }



        /*
        Percentage of authors with only 1 coauthor.
        Percentage of authors with 10 or fewer coauthors.
        • Percentage of authors with 20 or fewer coauthors.
        • Percentage of authors with 40 or fewer coauthors.
        • Percentage of authors with 80 or fewer coauthors.
        */
        double totalAuthors  = graph.size();
        double oneCoauthor = 0;
        double tenOrFewerCoauthor = 0;
        double twentyorFewerCoauthor = 0;
        double fourtyOrFewerCoauthor = 0;
        double eightyOrFewerCoauthor = 0;



        for (int i : graph.keySet()) {
            int coAuthorSize = graph.get(i).to.size();
            if (coAuthorSize<= 1) {
                oneCoauthor++;
            }
            if (coAuthorSize<= 10) {
                tenOrFewerCoauthor++;
            }
            if (coAuthorSize<= 20) {
                twentyorFewerCoauthor++;
            }
            if (coAuthorSize<= 40) {
                fourtyOrFewerCoauthor++;
            }
            if (coAuthorSize<= 80) {
                eightyOrFewerCoauthor++;
            }

        }

        System.out.println("Percentage of authors with only 1 coauthor:"+ (oneCoauthor/totalAuthors) * 100.00);
        System.out.println("Percentage of authors with 10 or fewer coauthors:"+ tenOrFewerCoauthor/totalAuthors *  100.00);
        System.out.println("Percentage of authors with only 20 or fewer coauthor:"+ twentyorFewerCoauthor/totalAuthors* 100.00);
        System.out.println("Percentage of authors with only 40 or fewer coauthor:"+ fourtyOrFewerCoauthor/totalAuthors* 100.00);
        System.out.println("Percentage of authors with only 80 or fewer coauthor:"+ eightyOrFewerCoauthor/totalAuthors* 100.00);

    }

}
