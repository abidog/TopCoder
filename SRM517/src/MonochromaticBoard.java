public class MonochromaticBoard {

    public static void main(String[] args) {
        String[] board = {"WBWBW",
                          "BBBBB",
                          "WBWBW",
                          "WBWBW"};
        MonochromaticBoard mb = new MonochromaticBoard();
        System.out.println(mb.theMin(board));
    }

    public int theMin(String[] board) {
        int[] row = new int[board.length];
        int[] col = new int[board[0].length()];

        for (int i = 0; i < board.length; i++) {
            String line = board[i];
            int count = 0;
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'B') {
                    count++;
                }
            }
            row[i] = count;
        }

        for (int i = 0; i < board[0].length(); i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j].charAt(i) == 'B') {
                    count++;
                }
            }
            col[i] = count;
        }
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            if (row[i] == board[0].length()) {
                res++;
            }
        }
        for (int i = 0; i < board[0].length(); i++) {
            if (col[i] == board.length) {
                res++;
            }
        }
        return res;
    }
}
