import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem4 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());

        Map<String, Set<String>> preq = new HashMap<>();

        while (num-- > 0) {

            String[] param = bf.readLine().split(" ");
            preq.put(param[0], new HashSet<>());

            for (int i = 2; i < param.length ; i++) {
                preq.get(param[0]).add(param[i]);
            }

        }
        String[] line = bf.readLine().split(" ");
        Set<String> soFar = new HashSet<>();
        boolean isGood = true;
        for (String s : line) {

            if (preq.containsKey(s)) {

                for (String pre : preq.get(s)) {
                  if (!soFar.contains(pre))    {
                      System.out.println("BOOM!");
                      isGood = false;
                      break;
                  }
                }

            }
            if (!isGood) {
                break;
            }
            soFar.add(s);

        }
        if (isGood) {
            System.out.println("SAFE!");
        }

    }

}
