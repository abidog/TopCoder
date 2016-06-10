import java.util.Arrays;

public class UnsortedSequence {

    public static void main(String[] args) {
        UnsortedSequence us = new UnsortedSequence();
        int [] s = {1,1};
        int [] rtn = us.getUnsorted(s);
        for (int i = 0; i < rtn.length; i++) {
            System.out.println(rtn[i]);
        }
    }

    public int[] getUnsorted(int[] s) {
        Arrays.sort(s);
        int i = s.length - 1;
        while ( i > 0 && s[i] == s[i - 1]) {
            i--;
        }
        if (i == 0) {
            return new int[]{};
        } else {
            int temp = s[i - 1];
            s[i - 1] = s[i];
            s[i] = temp;
        }
        return s;
    }
}
