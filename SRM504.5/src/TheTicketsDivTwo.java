// Start 11:16am
// end  11:56am

import java.util.*;

public class TheTicketsDivTwo {

    public static void main(String[] args) {
        TheTicketsDivTwo td2 = new TheTicketsDivTwo();
        System.out.println(td2.find(3,3,4));
    }

    public double find(int n, int m, int k) {
        List<List<Integer>> current = new ArrayList<>();
        List<Double> probCurrent = new ArrayList<>();
        ArrayList<Integer> firstLine = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == m) {
                firstLine.add(1);
            } else {
                firstLine.add(0);
            }
        }
        current.add(firstLine);
        probCurrent.add(1.0);
        List<Double> probNext = new ArrayList<>();
        List<List<Integer>> next;
        double goHome = 2.0/6.0;
        double goEnd = 1.0/2.0;
        double win = 1.0/6.0;
        double result = 0;
        while (k-- > 0) {
            next = new ArrayList<>();
            probNext = new ArrayList<>();

            for  (int i = 0; i < current.size(); i++) {

                List<Integer> line = current.get(i);

                // john at the begining
                if (line.get(0) == 1) {
                    if (line.size() == 1) {
                        result += probCurrent.get(i);
                        continue;
                    }
                    result += probCurrent.get(i) * win;
                    List<Integer> lineGoEnd = new ArrayList<>(line);

                    lineGoEnd.remove(0);
                    lineGoEnd.add(1);
                    next.add(lineGoEnd);
                    probNext.add(probCurrent.get(i) * goEnd);

                } else {
                    List<Integer> lineGoEnd = new ArrayList<>(line);
                    lineGoEnd.remove(0);
                    lineGoEnd.add(0);
                    probNext.add( probCurrent.get(i) * goEnd);
                    next.add(lineGoEnd);
                    List<Integer> goHomeLine = new ArrayList<>(line);

                    goHomeLine.remove(0);
                    next.add( goHomeLine);
                    probNext.add( probCurrent.get(i) * goHome);


                }
            }
            current = next;
            probCurrent = probNext;


        }

        for (int i = 0; i < current.size() ; i++){
            List<Integer> c = current.get(i);
            if (c.get(0) == 1) {
                result += probCurrent.get(i);
            }
        }
        return result;

    }
}
