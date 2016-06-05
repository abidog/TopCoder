import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class CuttingGrass {
    class Grass{
        int grow;
        int init;
        public Grass(int g, int i){
            this.grow = g;
            this.init = i;
        }
    }

    public static void main(String[] args) {
        CuttingGrass cg = new CuttingGrass();
        int[] init = new int[]{49, 13, 62, 95, 69, 75, 62, 96, 97, 22, 69, 69, 52};
        int[] grow = new int[]{7, 2, 4, 3, 6, 5, 7, 6, 5, 4, 7, 7, 4};
        int H = 517;
        System.out.println(cg.theMin(init, grow, H));
    }

    public int theMin(int[] init, int[] grow, int H){
        int sumInit = 0;



        for (int n = 0; n <= 50; n++) {

            List<Grass> grass = new ArrayList<>();
            for (int i = 0; i < init.length; i++) {
                grass.add(new Grass(grow[i], init[i] + (grow[i]*n)));
            }

            Comparator grassComp = new Comparator<Grass>() {
                public int compare(Grass g1, Grass g2) {
                    if (g1.init == g2.init) {
                        return g1.grow - g2.grow;
                    }
                    return g1.init - g2.init;
                }

            };
            Collections.sort(grass, grassComp);

            List<Grass> r = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                r.add(r.size(), grass.remove(grass.size() - 1));
            }
            Comparator rComp = new Comparator<Grass>() {
                public int compare(Grass g1, Grass g2) {
                    return g2.grow - g1.grow;
                }
            };

            Collections.sort(r, rComp);

            int h = 0;
            for (int i = 0; i < grass.size(); i++) {
                h += grass.get(i).init;
            }
            for (int i = 0; i < r.size() ; i++) {
                h += r.get(i).grow * i;
            }
            if (h <= H) {
                return n;
            }


        }
        return -1;

    }

    class P{
        int h;
        int g;

        @Override
        public String toString() {
            return "h="+h + ",g=" + g;
        }
    }

    public int theMinn(int[] init, int[] grow, int H) {
        int N = init.length;

        for (int n = 0; n < N; n++) {
            LinkedList<P> ps = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                P p = new P();
                p.h = init[i] + grow[i] * n;
                p.g = grow[i];
                ps.add(p);
            }

            Collections.sort(ps, new Comparator<P>() {
                @Override
                public int compare(P o1, P o2) {
                    if (o1.h == o2.h) {
                        return o1.g - o2.g;
                    }
                    return o1.h - o2.h;
                }
            });

            LinkedList<P> r = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                P p = ps.removeLast();
                r.add(p);
            }

            Collections.sort(r, new Comparator<P>() {
                @Override
                public int compare(P o1, P o2) {
                    return o2.g - o1.g;
                }
            });

            System.out.println("ps = " + ps);
            System.out.println("r = " + r);

            int h = 0;
            for (int i = 0; i < ps.size(); i++) {
                h += ps.get(i).h;
            }
            for (int i = 0; i < r.size(); i++) {
                h += r.get(i).g * i;
            }

            if (h <= H) {
                return n;
            }
        }

        return -1;
    }
}
