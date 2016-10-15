

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem {
    static class Node{
        int i;
        int j;
        String name;
        public Node(String name, int i, int j) {
            this.name = name;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] param = bf.readLine().split(" ");
        int x = Integer.parseInt(param[0]);
        int y = Integer.parseInt(param[1]);
        int time = Integer.parseInt(param[2]);
        int num = Integer.parseInt(param[3]);
        List<Node> patient = new ArrayList();
        for (int i = 0; i < num; i++) {
            String[] pr = bf.readLine().split(" ");
            patient.add(new Node(pr[0], Integer.parseInt(pr[1]), Integer.parseInt(pr[2])));
        }
        int max = Integer.MIN_VALUE;
        int[] best = new int[patient.size()];
        int[] order = new int[patient.size()];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }

        do {
            int tme = 0;
            int numberPatient =  0;
            for (int i = 0; i < order.length && tme <= time; i++) {
                tme +=  2* distance(x, y, patient.get(order[i]));
                numberPatient++;

            }
            if (tme > time && numberPatient - 1 > max ) {
                best = Arrays.copyOf(order, order.length);
                max = numberPatient - 1;
            } else if (numberPatient - 1 > max) {
                best = Arrays.copyOf(order, order.length);
                max = numberPatient;
            }


        } while (next(order));
        System.out.print(max+" ");
        for (int i = 0; i < max; i++) {
            if (i == max - 1) {
                System.out.print(patient.get(best[i]).name);
            } else {
                System.out.print(patient.get(best[i]).name+" ");
            }

        }
    }


    public static boolean next(int[]num) {

        int p = num.length - 1;
        // 1 2 4 7 9 12 10 3 0
        for (; p > 0 && num[p - 1] >= num[p]; p--);

        if (p == 0) {
            return false;
        }

        int q = num.length - 1;
        for (; q >= 0 && num[q] <= num[p - 1]; q-- );
        swap(num, p - 1 ,q);

        int l = p;
        int r = num.length - 1;
        while (l < r) {
            swap(num, l, r);
            l++;
            r--;
        }
        return true;
    }

    public static void swap(int[] num, int x, int y) {
        int t = num[x];
        num[x] = num[y];
        num[y] =t;
    }

    public static int distance(int x, int y, Node pat) {
        List<Node> topBottom = new ArrayList<>();
        if (pat.i % 10 == 0) {
            int j = (pat.j / 10) * 10;
            topBottom.add(new Node(pat.name, pat.i, j));
            topBottom.add(new Node(pat.name, pat.i, j + 10));
        } else {
            int i = (pat.i / 10) * 10;
            topBottom.add(new Node(pat.name, i, pat.j));
            topBottom.add(new Node(pat.name, i + 10, pat.j));
        }
        List<Node> ab = new ArrayList<>();

        if (x % 10 == 0) {
           int newY = (y / 10 )  * 10;
            ab.add(new Node("", x, newY));
            ab.add(new Node("", x, newY+ 10));
        } else {
            int newX = (x / 10 )  * 10;
            ab.add(new Node("", newX, y));
            ab.add(new Node("", newX+10, y));
        }
        int min = Integer.MAX_VALUE;
        for (Node n1 : topBottom) {
            for (Node n2 : ab) {
                min = Math.min(min, Math.abs(n1.i - n2.i) + Math.abs(n1.j- n2.j) + Math.abs(n1.i - pat.i) + Math.abs(n1.j - pat.j) + Math.abs(n2.i - x)+ Math.abs(n2.j - y));
            }
        }
        return min;

    }


}
