import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            char [] line = bf.readLine().toLowerCase().toCharArray();
            Arrays.sort(line);
            String ln = new String(line);
            if (map.containsKey(ln)) {
                map.put(ln, map.get(ln) + 1);
            } else {
                map.put(ln, 1);
            }
        }
        int mx = 0;
        for (String i : map.keySet()) {
            if (map.get(i) > 1) {
                mx += map.get(i);
            }

        }
        System.out.println(mx);
    }

}
