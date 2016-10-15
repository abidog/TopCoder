import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class A {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String king = bf.readLine();
        List<String> nam = new ArrayList<>();
        Map<String, List<String>> names = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] name = bf.readLine().split(" ");
            names.put(name[0], new ArrayList<>());
            names.get(name[0]).add(name[1]);
            names.get(name[0]).add(name[2]);
            nam.add(name[0]);

        }
        Map<String, Double> blood = new HashMap<>();
        blood.put(king, 1.0);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (blood.containsKey(nam.get(j))) {
                    continue;
                }
                if (blood.containsKey(names.get(nam.get(j)).get(0)) && blood.get(names.get(nam.get(j)).get(0)) == 0) {
                    continue;
                }
                if (blood.containsKey(names.get(nam.get(j)).get(1)) && blood.get(names.get(nam.get(j)).get(1)) == 0) {
                    continue;
                }
                double f = blood.containsKey(names.get(nam.get(j)).get(1)) ? blood.get(names.get(nam.get(j)).get(1)) : 0;
                f += blood.containsKey(names.get(nam.get(j)).get(0)) ? blood.get(names.get(nam.get(j)).get(0)) : 0;
                blood.put(nam.get(j), f * 0.5);

            }
        }
        
        
        String name = "";
        double min = -1.0;
        
        for (int i = 0; i < m; i++) {
            String claim = bf.readLine();
            
            if (blood.get(claim) > min) {
                name = claim;
                min = blood.get(claim);
            }
            
            
           

        }
        System.out.println(name);

    }
}
