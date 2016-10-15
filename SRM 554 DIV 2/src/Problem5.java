import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int clubs = Integer.parseInt(bf.readLine());
        int [] c = new int[clubs];
        String[] cl = bf.readLine().split(" ");
        for (int i = 0; i < clubs; i++) {
            c[i] = Integer.parseInt(cl[i]);
        }
        int holes = Integer.parseInt(bf.readLine());
        int[] h = new int[holes];
        String[] hl = bf.readLine().split(" ");

        for (int i = 0; i < holes; i++) {
            h[i] = Integer.parseInt(hl[i]);
        }


        for (int i = 0; i < h.length; i++) {
            boolean[] v = new boolean[600 * 300];
            for (int j : c) {
                v[j] = true;
            }
            for (int j = 0; j < v.length; j++) {

                if (v[j]) {
                    for (int k : c) {
                        if (j + k < v.length) {
                            v[j + k] = true;
                        }
                        if (j - k >= 0) {
                            v[j - k] = true;
                        }

                    }
                }

            }
            if (v[h[i]]) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

}
