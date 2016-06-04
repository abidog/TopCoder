public class CutTheNumbers {


    public static void main(String[] args) {

    }

    public int maximumSum(String[] board) {
        int w = board.length;
        int h = board[0].length();

        int max = w * h;
        int res = 0;
        for (int mask = 0; mask < (1 << max); mask++) {
            int x = 0;
            int s = 0;
            // traverse every row, and add the rows that has entree 1
            for (int i = 0; i < w; i++) {

                for (int j = 0; j < h; j++) {
                    if (((mask >> (i * h + j)) & 0x1) == 0) {
                        s += x;
                        x = 0;
                    } else {
                        x = x * 10 + board[i].charAt(j) - '0';
                    }
                }
                s += x;

            }
            x = 0;
            // check columns that has entree 0
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w ; j++) {
                    if (((mask >> ( h * j + i)) & 0x1) != 0) {
                        s += x;
                        x = 0;
                    } else {
                        x = x * 10 + board[j].charAt(i) - '0';
                    }
                }
                s += x;
            }
            res = Math.max(res, s);
        }
        return res;

    }
}
