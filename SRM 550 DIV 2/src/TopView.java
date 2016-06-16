import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class TopView {

    public static void main(String[] args) {
        String[] grid = new String[] {"aabbaaaaaaaaaaaaaaaaaa",
                "aabbccccccccccccccaaaa",
                "aab11111ccccccccccaaaa",
                "aab12221ccccccccccaaaa",
                "aab12221ccccccccccaaaa",
                "aab12221ccccccccccaaaa",
                "aab12221ccccccccccaaaa",
                "aab12221ccccccccccaaaa",
                "aab12221ddddddddddaaaa",
                "aab13331DDDDDDDDDDaaaa",
                "aab13331DDDDDDDDDDaaaa",
                "aa.11111DDDDDDDDDDaaaa",
                "aaaaaaaaaaaaaaaaaaaaaa"};
        new TopView().findOrder(grid);
    }

    public String findOrder(String[] grid) {


        Map<Character, Integer> mapId = new HashMap<>();
        Map<Integer, Character> intToChar = new HashMap<>();
        int id = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) != '.' && !mapId.containsKey(grid[i].charAt(j))) {
                    mapId.put(grid[i].charAt(j), id);
                    intToChar.put(id++, grid[i].charAt(j));
                }
            }
        }

        int[][] before = new int[id][id];

        for (int i = 0; i < id; i++) {

            int maxX = 0;
            int maxY = 0;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            char color = intToChar.get(i);
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid[j].length(); k++) {
                      if (grid[j].charAt(k) == color) {
                          maxX = Math.max(maxX, k);
                          maxY = Math.max(maxY, j);
                          minX = Math.min(minX, k);
                          minY = Math.min(minY, j);

                      }
                }
            }

            for (int j = minY; j <= maxY; j++) {
                for (int k = minX; k <= maxX ; k++) {
                    if (grid[j].charAt(k) == '.') {
                        return "ERROR!";
                    }
                    if (grid[j].charAt(k) != color) {
                        before[i][mapId.get(grid[j].charAt(k))] = 1;
                    }
                }
            }

        }


        // do top sort in before

        String res = "";
        int count = 0;
        boolean[] v = new boolean[id];
        for (int y = 0; y < id ; y++) {
            char min = 256;
            int iIndex = -1;
            for (int i = 0; i < id; i++) {
                if (v[i]) {
                    continue;
                }
                boolean isGood =  true;
                for (int j = 0; j < id; j++) {
                    if (before[j][i] == 1) {
                        isGood = false;
                        break;
                    }
                }
                if (isGood) {
                    if (intToChar.get(i) < min) {
                        min = intToChar.get(i);
                        iIndex = i;
                    }
                }
            }
            if (count != id  && min == 256) {
                return "ERROR!";
            }
            for (int i = 0; i < id && iIndex != -1; i++) {
                before[iIndex][i] = 0;
                count++;
            }
            v[iIndex] = true;
            res += String.valueOf((char)min);

        }
        return res;
	}
}
