// start 5:01
// end :
import java.util.*;
public class SlimeXResidentSlime {

    class Cell{
        int r;
        int c;
        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    class Slime{
        Cell c;
        int rt;
        public Slime(Cell c, int rt) {
            this.c = c;
            this.rt = rt;
        }
    }
    class Move{
        Cell c;
        int t;
        public Move(Cell c, int t) {
            this.c = c;
            this.t = t;
        }
    }
    int R;
    int C;
    int[][] sd;
    List<Slime> slimes;
    char[][] board;
    Cell start;
    int answer = Integer.MAX_VALUE;
    List<Move> moves = new ArrayList<>();


    public static void main(String[] args) {
        SlimeXResidentSlime sr = new SlimeXResidentSlime();
        String[] field = 	{"$.#2", "#..1"};
        System.out.println(sr.exterminate(field));
    }

    public int exterminate(String[] field) {
        slimes = new ArrayList<>();
        R = field.length;
        C = field[0].length();
        board =  new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C ; j++) {
                board[i][j] = field[i].charAt(j);
                char c = board[i][j];
                if (c == '$') {
                    start = new Cell(i,j);
                } else if ( c >= '1' && c <= '9') {
                    slimes.add(new Slime(new Cell(i,j), (c - '0')));
                }
            }
        }

        bfs();

        for (Slime s : slimes) {
            // start from this slime
            if (sd[s.c.r][s.c.c] != -1) {
                moves.add(new Move(new Cell(s.c.r, s.c.c), 0));
                dfs(s.c.r, s.c.c, 0, sd[s.c.r][s.c.c]);
                moves.remove(moves.size() - 1);
            }

        }

        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    int[] rr = {1,-1, 0, 0};
    int[] cc = {0, 0, 1, -1};

    private void dfs(int r, int c, int time, int start) {

        if (time > 9 ) {
            return ;
        }

        if (isWin(time)) {
            answer = Math.min(answer, time + start);
            return ;
        }

        for (int i = 0; i < 4 ; i++) {
            int dr = r + rr[i];
            int dc = c + cc[i];
            if (isValid(dr, dc)) {
                moves.add(new Move(new Cell(dr,dc), time + 1));
                dfs(dr, dc, time + 1, start);
                moves.remove(moves.size() - 1);
            }
        }
    }

    private boolean isWin(int time) {



        for (Slime s : slimes) {
            int killTime = -1;
            for (Move m : moves) {
                if (m.c.r == s.c.r && m.c.c == s.c.c) {
                    killTime = Math.max(killTime, m.t);
                }
            }
            if (killTime == -1) {
                return false;
            }
            if (time - killTime >= s.rt) {
                return false;
            }
        }
        return true;

    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C && board[r][c] != '#';
    }
    private void bfs() {
        sd = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(sd[i], -1);
        }



        List<Move> q = new ArrayList<>();
        q.add(new Move(start, 0));
        boolean[][] visited = new boolean[R][C];
        visited[start.r][start.c] = true;
        while (!q.isEmpty()) {

            Move m = q.remove(0);
            sd[m.c.r][m.c.c] = m.t;
            for (int i = 0; i < 4; i++) {
                int dr = m.c.r + rr[i];
                int dc = m.c.c + cc[i];
                if (isValid(dr, dc) && !visited[dr][dc]) {
                    q.add(new Move(new Cell(dr,dc), m.t + 1));
                    visited[dr][dc] = true;
                }
            }

        };
    }
}
