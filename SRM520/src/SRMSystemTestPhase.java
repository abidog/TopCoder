import java.util.*;

// end 1:34pm
public class SRMSystemTestPhase {

    public static void main(String[] args) {
        SRMSystemTestPhase  system = new SRMSystemTestPhase();
        String [] des = {"YNN", "YNY", "YYY", "YNY", "YYN", "YYN", "YYY", "YYN", "YNY", "YNY", "YYN", "YNN", "NYY", "NNY", "YNY", "YYN", "YNN", "YYY", "NNY", "YNN", "YYY"};
        System.out.println(system.countWays(des));
    }

    public int score(String line) {
        int res = 0;
        char a = line.charAt(0);
        char b = line.charAt(1);
        char c = line.charAt(2);

        if (a == 'P'){
            res+= 3;
        } else if (a == 'C'){
            res -= 1;
        }

        if (b == 'P'){
            res+= 3;
        } else if (b == 'C'){
            res -= 1;
        }

        if (c == 'P'){
            res+= 3;
        } else if (c == 'C'){
            res -= 1;
        }
        return res;

    }
    int result = 0;
    public int countWays(String[] description) {


        count(description, 0, Integer.MAX_VALUE);


        return result;
    }
    Map<String, Set> bld = new HashMap<>();
    Map<String, Integer> scoreMap = new HashMap<>();
    public void count(String[]description, int cur, int score) {

        if (cur == description.length) {
            result += 1;
        } else {
            Set<String> adj = null;
            if (!bld.containsKey(description[cur])) {
                bld.put(description[cur], build(description[cur]));
            }
            adj = bld.get(description[cur]);
            for (String s : adj) {
                int thisScore = -1;
                if (!scoreMap.containsKey(s)) {
                    scoreMap.put(s, score(s));
                }
                thisScore = scoreMap.get(s);
                if (thisScore <= score) {
                    count(description, cur + 1, thisScore);
                }

            }

        }

    }

    private Set<String> build (String line) {
        char a = line.charAt(0);
        char b = line.charAt(1);
        char c = line.charAt(2);
        char[] map = {'P','C','F'};
        Set<String> option = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                for (int k = 0; k < 3; k++) {
                    String res = "";
                    if (a == 'Y') {
                        res += map[i]+"";
                    } else {
                        res += "X";
                    }
                    if (b == 'Y') {
                        res += map[j] +"";
                    } else {
                        res += "X";
                    }

                    if (c == 'Y') {
                        res += map[k];
                    } else {
                        res += "X";
                    }
                    option.add(res);
                }
            }
        }

        return option;
    }
}
