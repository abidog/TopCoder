import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class EllysCheckers {

    public static void main(String[] args) {
        String board = ".o...ooo..oo..";
        System.out.println(new EllysCheckers().getWinner(board));
    }

    public String getWinner(String board) {

        int init = 0;
        String bre = new StringBuilder(board).reverse().toString();
        for (int i = 1; i < board.length(); i++) {
            if (bre.charAt(i) == 'o') {
                init |= (1 << i);
            }
        }
        int[] dp = new int[1 << board.length()];
        Arrays.fill(dp, -1);
        if (play(init, dp)){
            return "YES";
        } else {
            return "NO";
        }

	}

    private boolean play(int init, int[] dp ) {
        if (dp[init] != -1) {
            return dp[0] == 0 ? true : false;
        }
        List<Integer> next = moves(init);
        if (next.size() == 0) {
            return false;
        }
        for (int i : next) {
            if (dp[i] != -1) {
                if (dp[i] == 0) {
                    return true;
                }
            }
            if (dp[i] == -1 &&  !play(i, dp)) {
                dp[i] = 0;
                return true;
            } else {
                dp[i] = 1;
            }
        }
        dp[init] = 1;
        return false;

    }

    List<Integer> moves(int mask) {
        if ((mask & 0x1) == 1) {
            mask = mask - 1;
        }

        List<Integer> next = new ArrayList<>();
        for (int i = 1; i < 20 ; i++) {
            if (((mask >> i) & 0x1) == 1) {
                // check right
                if ((((mask)>> (i - 1))  & 0x1) != 1) {
                    // I can make a move
                    int nxt = mask;
                    // set ith bit 0, and set i - 1 bit 1
                    // 11111i(0)11111
                    int setIthZero = ~(1 << (i));
                    nxt = nxt & setIthZero;
                    nxt = (nxt | (1 << (i - 1)));
                    next.add(nxt);

                }

            }

            if (i > 3 && (((mask >> i) & 0x1) == 1) && (((mask >> (i - 3)) & 0x1) != 1)) {

                    int nxt = mask;
                    // set ith bit 0, and set i - 1 bit 1
                    // 11111i(0)11111
                    int setIthZero = ~(1 << (i));
                    nxt = nxt & setIthZero;

                    nxt = (nxt | (1 << (i - 3)));
                    if ((nxt & 0x1) == 1) {
                        nxt -= 1;
                    }
                    next.add(nxt);



            }
        }
        return next;

    }
}
