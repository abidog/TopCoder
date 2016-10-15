

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem6 {
    public static void main(String[] args) throws IOException {
        class Node{
            int r;
            int c;
            int dis;
            public Node(int r, int c, int d) {
                this.r = r;
                this.c = c;
                dis = d;
            }

        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nm= bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] board = new String[n];
        List<Node> launch = new ArrayList();
        Node start = null;
        for (int i = 0; i < n; i++) {
            board[i] = bf.readLine();
            if (board[i].indexOf('*') >= 0) {
             start = new Node(i, board[i].indexOf('*'), 0);
            }
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'S') {
                    launch.add(new Node(i, j, 0));
                }
            }
        }

        List<Node> q = new ArrayList<>();
        q.add(start);
        int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int min = Integer.MAX_VALUE;
        boolean[][]visited = new boolean[board.length][board[0].length()];
        visited[start.r][start.c] = true;
        boolean isGood = false;
        while (!q.isEmpty()) {

            Node v = q.remove(0);
            if (board[v.r].charAt(v.c) == 'S') {
                System.out.println(v.dis);
                isGood = true;
                break;
            }

            for (int [] d : move) {
                int dr = v.r + d[0];
                int dc = v.c + d[1];
                if (dr >= 0 && dr < board.length && dc >= 0 && dc < board[0].length() && !visited[dr][dc] && board[dr].charAt(dc) != 'X') {
                    q.add(new Node(dr, dc, v.dis + 1));
                    visited[dr][dc] = true;
                }
            }

        }
        if (!isGood)  {
            System.out.println(-1);
        }




    }
}
