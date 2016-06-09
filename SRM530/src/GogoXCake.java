import java.util.*;
public class GogoXCake {
    public static void main(String[] args) {
        GogoXCake gogo = new GogoXCake();
        String[] cake = new String[]	{"XX.XX........XX...X.XX........X.X..XX.......X..X.X", "..................................................", "X........XX.XX.....X.X..X..X.X......X..X....X.....", "X.....XX.............X............................", "......X...X.....X...X.......X.X....X........X..X.X", "X..X..X.....X..X......X................X.......X.X", "X..........X.......................X...X.....X....", "..................XX........X..X...........X......", "X...X............X.......X................X......X", "X..X.....X...................X..........X........X", "X.......X.....X......X............................", "....................X...X........X....X.XX.X......", "X........X..X....................X.XX.............", "X.X..X......X..............X...........X.......X..", "X....................X....X.....X.........XX......", ".......................................XX.........", ".......X.........X.......X....X.......X...XX..X...", "X.X............X.X......X.............X.X....X....", "X......X.........X...X................X...X......X", "..........X.....X....................XX.......X..X", "...XX.........X...X.X......X..X....X..............", ".........X..............XX......X.....X..X.....X..", "X.X..........X...X......................X......X.X", "..X..XXX.X...X..XX.....X..............X......X.X..", ".....................X.............X........X.....", "X.X..X...............X....XX...XX.XX.X............", "........X.X...............X..............X.X...X.X", ".....X..X................X......X..X...........X..", "X.XX..........XXX.X.X.........X.X..X..X...........", "X..........X.X..........X.X..X..............X.....", "......X......X.........X.........X.....X...X.....X", "X................X.X..XX..............X..X.....X.X", ".........X.X..X...........X...X...................", "X......X.X......X..................X..............", "..X...............X......X....X....X..........X..X", ".......X.........................X.....X.........X", "..X.....................X...X..............X......", "X....X......X...X.......X.XX.....X..X.X..........X", ".......XX...X.....X..............X.X..............", ".....X.....................X...XX.................", "X.XXX..X....X..........X..XX..X.......X...X.......", "X.X...X...........................................", "..........X......X..X.............................", "...X............X.........X..X........X..X....X...", "..X.......X.........X............................X", ".........X..........X.X.............X..X..........", ".....X.............X..............X...X.....X.XX.X", "X.X......X...XX..X.......X.X.X.X.................X", "..................................................", "X.....XXX...X....XX..XXX.X..........XX.X.X....XX.X"};
        String[] cutter = new String[] {".X", "X."};



        System.out.println(gogo.solve(cake, cutter));
    }

    public String solve(String[] cake, String[] cutter) {

        return placeCutter(cake, cutter);
    }

    public String placeCutter(String[] cake, String[]cutter) {
        char[][] cak = new char[cake.length][cake[0].length()];
        char[][] start = new char[cake.length][cake[0].length()];
        char[][] cut = new char[cutter.length][cutter[0].length()];
        for (int i = 0; i < cake.length; i++) {
            cak[i] = cake[i].toCharArray();
        }
        for (int i = 0; i < cutter.length; i++) {
            cut[i] = cutter[i].toCharArray();
        }
        int cuts = 0;
        int needsToBeCut = 0;
        for (int i = 0; i < cut.length; i++) {
            for (int j = 0; j < cut[0].length; j++) {
                if (cut[i][j] == '.'){
                    cuts++;
                }
            }
        }
        for (int i = 0; i < cak.length; i++) {
            for (int j = 0; j < cak[0].length; j++) {
                if (cak[i][j] == '.'){
                    needsToBeCut++;
                }
            }
        }

        for (int i = 0; i < cake.length; i++) {
            for (int j = 0; j < cake[0].length(); j++) {
                start[i][j] = 'X';
            }
        }
        if (place(cak, start, cut,0, cuts, needsToBeCut)) {
            return "Yes";
        } else {
            return "No";
        }


    }

    private boolean place(char[][] target, char[][] start,  char[][] cut,int cur,  int numCut, int needCut ) {
        if (cur == needCut) {
            if (isSame(target, start)) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start[0].length; j++) {
                char[][] possible = canBePlaced(target, start, cut, i, j);
                if (possible != null) {
                    if (place(target, possible, cut, numCut + cur, numCut, needCut)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isSame(char[][] target, char[][] start) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                if (target[i][j] != start[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private char[][] canBePlaced(char[][] target, char[][] cake, char[][] cutter, int i, int j) {
        int ci = 0;
        int cj = 0;
        if (!(i + cutter.length <= cake.length && j + cutter[0].length <= cake[0].length)) {
            return null;
        }
        char[][] newCake = new char[cake.length][];
        for (int k = 0; k < cake.length; k++) {
            newCake[k] = Arrays.copyOf(cake[k], cake[k].length);
        }
        for (int k = i; k < i + cutter.length ; k++) {
            for (int l = j; l < j + cutter[0].length ; l++) {
                if (cutter[ci][cj] == '.' && cake[k][l] == 'X' && target[k][l] == '.') {
                    newCake[k][l] = '.';
                    cj++;
                    continue;
                } else if (cutter[ci][cj] == '.'){
                    return null;
                }
                cj++;
            }
            ci++;
            cj = 0;
        }
        return newCake;
    }
}
