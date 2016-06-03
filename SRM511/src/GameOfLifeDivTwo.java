// start : 2:16pm
// end : 2:26pm

public class GameOfLifeDivTwo {

    public static void main(String[] args) {
        String s = "110010000010111110010100001001";
        int t = 1000;
        GameOfLifeDivTwo gm = new GameOfLifeDivTwo();
        System.out.println(gm.theSimulation(s, t));
    }

    public String theSimulation(String init, int T){

        boolean[] state = new boolean[init.length()];
        for (int i = 0; i < init.length(); i++) {
            state[i] = init.charAt(i) == '0' ? false : true;
        }


        for (int t = 0; t < T; t++) {
            boolean[] nstate = new boolean[init.length()];
            for (int i = 0; i < init.length(); i++) {
                int numLive = 0;
                if (i == 0) {
                    numLive = (state[init.length() - 1]? 1 : 0) + (state[i]? 1: 0) + (state[i + 1] ? 1 : 0);
                } else if (i == init.length() - 1) {
                    numLive = (state[i - 1]? 1 : 0) + (state[i]? 1: 0) + (state[0] ? 1 : 0);
                } else {
                    numLive = (state[i - 1]? 1 : 0) + (state[i]? 1: 0) + (state[i + 1] ? 1 : 0);
                }

                if (numLive >= 2) {
                    nstate[i] = true;
                }

            }
            state = nstate;
        }

        String res = "";
        for (int i = 0; i < init.length(); i++) {
            res += state[i] ? "1" : "0";
        }
        return res;
    }
}
