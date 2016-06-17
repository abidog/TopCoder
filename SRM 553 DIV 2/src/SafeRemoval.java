import java.util.*;





public class SafeRemoval {

    public static void main(String[] args) {
        SafeRemoval sr = new SafeRemoval();
        int [] seq  = {823, 458, 806, 115, 383, 412, 971, 433, 31, 718, 837, 824, 684, 240, 775, 624, 861, 850, 776, 787, 979, 23, 115, 924, 747, 155, 993, 850, 713, 932, 606, 784};
        int k = 17;
        System.out.println(sr.removeThem(seq, k));
    }


	public int removeThem(int[] seqq, int k) {
        int[][] b = new int[4][55];
        int[][] a = new int[4][55];
        Arrays.sort(seqq);
        int[] seq = new int[seqq.length];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = seqq[seq.length - 1 - i];
        }
        for (int i = 0; i < 4; i++) {
            b[i][0] = a[i][0] = 0;
        }

        for (int i = 0; i < seq.length; i++) {
            int mod = seq[i] % 4;
            a[mod][++a[mod][0]] = seq[i];
            b[mod][a[mod][0]] = seq[i] + b[mod][a[mod][0] - 1];
        }


        int[][][][] f = new int[55][55][55][55];
        int n = seq.length;
        for (int i0 = 0; i0 < a[0][0]; i0++) {
            for (int i1 = 0; i1 < a[1][0] ; i1++) {
                for (int i2 = 0; i2 < a[2][0]; i2++) {
                    for (int i3 = 0; i3 < a[3][0]; i3++) {


                        if (i0 + i1 + i2 + i3 >= n - k) {
                            if (i0 + i1 + i2 + i3 == n - k) {
                                //in this case we just can not continue to remove any number
                                f[i0][i1][i2][i3] = b[0][i0] + b[1][i1] + b[2][i2] + b[3][i3];
                                if ((f[i0][i1][i2][i3] % 4) == 0) f[i0][i1][i2][i3] = -1;
                            }
                            else {
                                f[i0][i1][i2][i3] = -1;
                                if (((b[0][i0] + b[1][i1] + b[2][i2] + b[3][i3]) % 4) != 0) {
                                    if (i0 > 0 && f[i0][i1][i2][i3] < f[i0 - 1][i1][i2][i3]) f[i0][i1][i2][i3] = f[i0 - 1][i1][i2][i3];
                                    if (i1 > 0 && f[i0][i1][i2][i3] < f[i0][i1 - 1][i2][i3]) f[i0][i1][i2][i3] = f[i0][i1 - 1][i2][i3];
                                    if (i2 > 0 && f[i0][i1][i2][i3] < f[i0][i1][i2 - 1][i3]) f[i0][i1][i2][i3] = f[i0][i1][i2 - 1][i3];
                                    if (i3 > 0 && f[i0][i1][i2][i3] < f[i0][i1][i2][i3 - 1]) f[i0][i1][i2][i3] = f[i0][i1][i2][i3 - 1];
                                }
                            }
                        }



                    }
                }
            }
        }
        return f[ a[0][0] ][ a[1][0] ][ a[2][0] ][ a[3][0] ];
    }


}
