import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class NumberLabyrinthDiv2 {

    public static void main(String[] args) {
        String[] board = new String[] {"...2",
                "....",
                "3..."};
        int r1 = 0;
        int c1 = 0;
        int r2 = 2;
        int c2 = 3;
        int K = 1;
        System.out.println(new NumberLabyrinthDiv2().getMinimumNumberOfMoves(board, r1, c1, r2, c2, K));
    }

    public int getMinimumNumberOfMoves(String[] board, int r1, int c1, int r2, int c2, int K) {

        List<Integer> q  = new ArrayList<>();
        int[][][] distance = new int[board.length][board[0].length()][K + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }

        q.add(r1);
        q.add(c1);
        q.add(K);
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        distance[r1][c1][K] = 0;
        while (!q.isEmpty()) {
            int r = q.remove(0);
            int c = q.remove(0);
            int k = q.remove(0);
            if (r == r2 && c == c2) {
                return distance[r][c][k];
            }
            boolean canWrite = k > 0 && board[r].charAt(c) == '.';
            int d = board[r].charAt(c) - '0';
            int newK = canWrite ? k - 1: k;
            for (int i = 1; i <= 9 ; i++) {
                if (canWrite || d == i) {

                  for (int m = 0; m < 4; m++) {
                    if (isValid(board, r + x[m] * i, c + y[m] * i) && distance[r + x[m] * i][c + y[m] * i][newK] > distance[r][c][k] + 1) {
                        q.add(r + x[m] * i);
                        q.add(c + y[m] * i);
                        q.add(newK);
                        distance[r + x[m] * i][c + y[m] * i][newK] = distance[r][c][k] + 1;
                    }
                  }

                }
            }

        }

		return -1;
	}

    private boolean isValid(String[] board, int r, int c) {
        return board.length > r && r >= 0 && c >= 0 && c < board[0].length();
    }

}
