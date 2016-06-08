import sun.security.provider.Sun;

import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class Sunnygraphs2 {

    public static void main(String[] args) {
        Sunnygraphs2 s = new Sunnygraphs2();
        int[] a = new int[] {1,0};

        System.out.println(s.count(a));
    }

    class DisjoinSet{
        int N;
        int[] p;
        int[] siz;
        public DisjoinSet(int size){
            this.N = size;
            p = new int[N];
            siz = new int[N];
            Arrays.fill(siz, 1);
            for (int i = 0; i < N; i++) {
                p[i] = i;
            }

        }

        public int find(int x) {
            int parent = p[x];
            if (parent == x){
                return x;
            }
            p[x] = find(parent);
            return p[x];
        }

        public void merge(int x, int y) {

            int px = find(x);
            int py = find(y);

            p[px] = py;

            siz[px] += p[py];

        }
    }

    class DS{
        int[] p;
        int[] size;
    public DS(int N) {
        p = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        for(int i = 0; i < N; i ++)
            size[i] = 1;
    }
    int find(int x) {
        if(p[x] == x)
            return x;
        return p[x] = find(p[x]);
    }
    boolean query(int a, int b) {
        return find(a) == find(b);
    }
    void merge(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        size[pb] += size[pa];
        p[pa] = pb;
    }
}



	
	public long count(int[] a) {

        // count the number of nodes in the cycle and the nodes in the tails, then total number will be
        // (2^(nodesInComponents - nodesInTail) - 1) * (2 ^ nodesInTail)
        DS ds = new DS(a.length);
        int[] deg = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int px = ds.find(i);
            int py = ds.find(a[i]);
            deg[a[i]]++;
            if (px != py) {
                ds.merge(i, a[i]);
            }
        }
        long ans = 1;
        long justOne = 0;
        for (int root = 0; root < a.length; root++) {

            long sizeComp = 0;
            List<Integer> q = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                if (ds.find(i) == root) {
                    sizeComp++;

                    if (deg[i] == 0) {
                        q.add(i);
                    }
                }
            }
            long sizeTail = 0;
            while (!q.isEmpty()) {
                int v = q.remove(0);
                sizeTail++;
                deg[a[v]]--;
                if (deg[a[v]] == 0) {
                    q.add(a[v]);
                }
            }
            sizeComp -= sizeTail;
            if (sizeComp > 0) {
                justOne++;
                ans *= ((1L << (sizeComp))- 1) * (1L << sizeTail);
            }
        }
        if (justOne == 1) {
            ans++;
        }
        return ans;
	}
}
