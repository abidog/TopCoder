import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D {
    static class Stop {
        String name;
        List<Stop> to;
        List<String> lines;
        public Stop(String n) {
            this.name = n;
            to = new ArrayList<>();
            lines = new ArrayList<>();
        }
    }
    static class Line{
        String name;
        List<Stop> stops;
        public Line(String n) {
            this.name = n;
            stops = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numCase = Integer.parseInt(bf.readLine());
        bf.readLine();

        String[] stop = bf.readLine().split(" ");
        List<Stop> stops = new ArrayList<>();
        List<Line> lines = new ArrayList<>();
        for (int i = 1; i < stop.length; i++) {
            stops.add(new Stop(stop[i]));
        }

        String[] line = bf.readLine().split(" ");
        Map<String, Integer> lineNameToIndex = new HashMap<>();
        for (int i = 0; i < line.length - 1; i++) {
            lineNameToIndex.put(line[i + 1], i);
            lines.add(new Line(line[i + 1]));
        }




    }
}
