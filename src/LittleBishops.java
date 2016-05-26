import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class LittleBishops {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LittleBishops littleBishops = new LittleBishops();
        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            String[] param = line.split(" ");
            int n = Integer.parseInt(param[0]);
            int k = Integer.parseInt(param[1]);

            System.out.println(littleBishops.place(n, k));

        }


    }

    private String place(int n, int k) {


        int[] whiteBoard = new int[9];
        int[] blackBoard = new int[9];

        for (int i = 1; i <=n ; i++) {

            if (i % 2 == 0) {
                whiteBoard[i] = i;
            } else {
                whiteBoard[i] = whiteBoard[i - 1];
            }
        }
        for (int i = 1; i < n ; i++) {
            if (i % 2 == 0) {
                blackBoard[i] = blackBoard[i - 1];
            } else {
                blackBoard[i] = i + 1;
            }
        }
        long[][] white = new long[9][65];
        long[][] black = new long[9][65];
        for (int i = 0; i <=n; i++) {
            white[i][0] = 1;
        }
        for (int i = 0; i <n; i++) {
            black[i][0] = 1;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                white[i][j] = white[i - 1][j] + (white[i - 1][j - 1]*(whiteBoard[i] - (j - 1)));
            }
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                black[i][j] = black[i - 1][j] + black[i - 1][j - 1] * (blackBoard[i] - (j - 1));
            }
        }

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i <= k; i++) {
            sum = sum.add(new BigInteger(""+white[n][i]).multiply(new BigInteger(""+black[n - 1][k - i])));
        }

        return sum.toString();

    }


}

