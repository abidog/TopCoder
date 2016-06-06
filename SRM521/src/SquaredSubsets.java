import java.util.*;
//end 3:49pm
public class SquaredSubsets {

    public static void main(String[] args) {
        SquaredSubsets ss =new SquaredSubsets();
        int n = 5;
        int[] x= {-5,0,5};
        int[] y ={0,0,0};
        System.out.println(ss.countSubsets(n, x,y));

    }

    private boolean isInside(int x0, int y0, int x1, int y1,  int x, int y) {
        return x >= x1 && x <= x0 && y >= y0 && y <= y1;
    }

    private boolean isNSquare(int n, int nxi, int nyi, int nxj, int nyj) {
        if (Math.max(nxi, nyi) > n) {
            return false;
        }
        return nxi > n && nxj > n;
    }

    public long countSubsets(int n, int[] x, int[] y){
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i : x) {
            xs.add(i);
        }
        for (int i : y) {
            ys.add(i);
        }
        xs.add(Integer.MIN_VALUE);
        xs.add(Integer.MAX_VALUE);
        ys.add(Integer.MIN_VALUE);
        ys.add(Integer.MAX_VALUE);

        Collections.sort(xs);
        Collections.sort(ys);

        Set<Long> memo = new HashSet<>();

        for (int xi = 1; xi < xs.size(); xi++) {
            for (int yi = 1; yi < ys.size(); yi++) {
                for (int xj = xi; xj < xs.size() - 1; xj++) {
                    for (int yj = yi; yj < ys.size() - 1; yj++) {
                        int x0 = xs.get(xi);
                        int y0 = ys.get(yi);
                        int x1 = xs.get(xj);
                        int y1 = ys.get(yj);



                        if (isNSquare(n, x0 - x1, y0 - y1, xs.get(xj + 1) - xs.get(xi - 1), ys.get(yj+1)-ys.get(yi - 1))) {

                            long mask = 0;
                            for (int i = 0; i < x.length; i++) {
                                if (isInside(x0, y0, x1, y1, x[i], y[i])) {
                                    mask |= (1 << i);
                                }
                            }
                            memo.add(mask);

                        }


                    }
                }
            }
        }
        return memo.size();
    }
}
