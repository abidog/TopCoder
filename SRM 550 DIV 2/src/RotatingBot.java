import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class RotatingBot {
	class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            int hash = 71;
            hash = hash * x + y;
            return hash;
        }
        public boolean equals(Object o) {
            Point p = (Point)o;
            if (p.x == this.x && p.y == this.y) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] moves = new int[] {1, 2, 3, 4, 5};
        System.out.println(new RotatingBot().minArea(moves));
    }

	public int minArea(int[] moves) {

        int[][] move = {{1,0}, {0,1},{-1,0}, {0, -1}};

        int sx = 0;
        int sy = 0;
        int mx = 0;
        int my = 0;
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;

        minx = Math.min(minx, sx);
        mx = Math.max(mx, sx);
        my = Math.min(my, sy);
        miny = Math.min(miny, sy);

        Map<Point, Boolean> v = new HashMap<>();
        v.put(new Point(0, 0), true);
        int i = 0;
        for (; i < moves.length; i++) {
            int[] dir = move[i % 4];

            for (int j = 0; j < moves[i]; j++) {
                sx += dir[0];
                sy += dir[1];
                Point p = new Point(sx,sy);
                if (v.containsKey(p)) {
                    return -1;
                } else {
                    v.put(p, true);

                }

                minx = Math.min(minx, p.x);
                mx = Math.max(mx, p.x);
                my = Math.max(my, p.y);
                miny = Math.min(miny, p.y);


            }

        }


        Map<Point, Boolean> check = new HashMap<>();
        int bx = 0;
        int by = 0;
        check.put(new Point(bx, by), true);
        for (int j = 0; j < moves.length; j++) {
            int[] dir = move[j % 4];
            int nx = -1;
            int ny = -1;
            for (int k = 0; k < moves[j]; k++) {
                bx += dir[0];
                by += dir[1];

                if (!(bx >= minx && bx <= mx && by >= miny && by <= my)) {
                    return -1;
                }
                Point p = new Point(bx, by);
                if (check.containsKey(p)) {
                    return -1;
                } else {
                    check.put(new Point(bx, by), true);
                }
                if (k == moves[j] - 1) {
                    nx = bx + dir[0];
                    ny = by + dir[1];
                }
            }

            if (j != moves.length - 1) {
                Point p = new Point(nx, ny);
                if (!check.containsKey(p)) {
                    if (j % 4 == 0) {
                        if (bx != mx) {
                            return -1;
                        }
                    } else if (j % 4 == 1) {
                        if (by != my) {
                            return -1;
                        }
                    } else if (j % 4 == 2) {
                        if (bx != minx) {
                            return -1;
                        }
                    } else {
                        if (by != miny) {
                            return -1;
                        }
                    }
                }
            }



        }




        return (Math.abs(mx - minx) + 1) *(1 + Math.abs(miny - my));
	}
}
