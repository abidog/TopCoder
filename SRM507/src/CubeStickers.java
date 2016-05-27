
// start 12:18pm
// end 12:40pm

import java.util.*;

public class CubeStickers {

    public static void main(String[] args) {
        CubeStickers cs = new CubeStickers();
        String[] sticker = 	{"smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "iwwfoxljz", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "smxxdjezqn", "iwwfoxljz", "smxxdjezqn"};
        System.out.println(cs.isPossible(sticker));
    }

    public String isPossible(String[] sticker) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : sticker) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        if (map.size() < 3) {
            return "NO";
        } else if (map.size() == 3) {
            for (String key : map.keySet()) {
                if (map.get(key) < 2) {
                    return "NO";
                }
            }
        } else if (map.size() == 4) {
            int numOne = 0;
            for (String key : map.keySet()) {
                if (map.get(key) == 1) {
                    numOne++;
                }
            }

            if (numOne == 3) {
                return "NO";
            } else {
                return "YES";
            }

        }

        return "YES";

    }
}
