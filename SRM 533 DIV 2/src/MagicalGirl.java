import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class MagicalGirl {

	class Node{
        double prob;
        int left;
        public Node(double p, int l) {
            this.prob = p;
            this.left =l;
        }
    }
	public double maxExpectation(int M, int[] day, int[] win, int[] gain) {

        TreeMap<Integer, List<Integer>> dayToWitch  = new TreeMap<>();
        double max = 0;
        for (int i = 0; i < day.length; i++) {
            if (!dayToWitch.containsKey(day[i])) {
                dayToWitch.put(day[i], new ArrayList<>());
            }
            dayToWitch.get(day[i]).add(i);
        }
        List<Node> prob = new ArrayList<>();
        prob.add(new Node(1.0, M));

        for (int d = 1; d < 5000001; d++) {

            for (int i = 0; i < prob.size(); i++) {
                Node node = prob.get(i);
                if (dayToWitch.containsKey(d)) {
                    List<Node> next = new ArrayList<>();
                    List<Integer> evils = dayToWitch.get(d);

                    // not fight
                    next.add(new Node(node.prob, node.left - 1));


                }
            }


        }

        return 0;
	}
}
