public class DropCoins {
    public static void main(String[] args) {
        DropCoins dropCoins = new DropCoins();
        String[] board = new String[] { ".o..",
                                        "oooo",
                                        "..o." };
        int K = 3;

        System.out.println(dropCoins.getMinimum(board, K));
    }


    public 	int getMinimum(String[] board, int K) {
        int result = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'o'){
                    cnt++;
                }

            }
        }

        for (int ri = 0; ri < board.length; ri++) {
            for (int rj = 0; rj < board[0].length(); rj++) {

                for (int mi = ri; mi < board.length ; mi++) {
                    for (int mj =rj; mj < board[0].length() ; mj++) {


                        if (countCoin(ri, rj, mi, mj, board, K) == K) {

                            int left = rj;
                            int right = board[0].length() - mj - 1;
                            int up = ri;
                            int down = board.length - mi - 1;

                            result = Math.min(result, left + right + up + down + Math.min(up, down)+Math.min(left, right));
                        }

                    }
                }

            }
        }
        return result;
    }

    private int countCoin(int ri, int rj, int mi, int mj, String[] board, int k) {
        int count = 0;
        for (int i = ri; i <= mi ; i++) {
            for (int j = rj; j <=mj ; j++) {
                if (board[i].charAt(j) == 'o') {
                    count++;
                }

                if (count > k) {
                    return -1;
                }
            }
        }
        return count;

    }
}
