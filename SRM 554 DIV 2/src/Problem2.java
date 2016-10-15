

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Problem2 {
   static class Node{
        int index;
        int heigh;
        int level;
        public Node(int i, int h, int l) {
            index = i;
            heigh = h;
            level = l;
        }
    }
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());
        int [] h = new int[num];
        int i = 0;
        while (num--> 0) {
            h[i++] = Integer.parseInt(bf.readLine());
        }

        for (int s = 0; s < h.length; s++) {

            List<Node> q = new ArrayList();
            boolean[] v = new boolean[h.length];
            v[s] = true;
            q.add(new Node(s, h[s], 1));

           dfs(v, new Node(s, h[s], 1), h);

            /*
            while (!q.isEmpty()) {
                Node visiting = q.remove(0);
                max = Math.max(max, visiting.level);
                int start = visiting.index - 2;
                int end = visiting.index + 2;
                start = start < 0 ? 0 : start;
                end = end >= h.length ?h.length - 1 : end;
                for (int j = start; j <= end ; j++) {

                   if (!v[j] && h[j] < visiting.heigh)  {
                       v[j] = true;
                       q.add(new Node(j, h[j], visiting.level + 1));
                   }

                }

            }*/


        }
        System.out.println(max - 1);


    }

    private static void dfs(boolean[] v, Node node, int[] h) {

        v[node.index] = true;
        int start = node.index - 2;
        int end = node.index + 2;
        start = start < 0 ? 0 : start;
        end = end >= h.length ?h.length - 1 : end;
        max = Math.max(max, node.level);

        for (int i = start; i <= end ; i++) {
            if (!v[i] && h[i] < node.heigh) {
                dfs(v, new Node(i, h[i], node.level + 1), h);
            }
        }
        v[node.index] =  false;

    }

}
