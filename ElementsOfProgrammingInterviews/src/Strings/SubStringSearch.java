package Strings;

public class SubStringSearch {

    public int[] computeTempArray(char[] p) {
        int[] lps = new int[p.length];

        int index = 0;
        for (int i = 1; i < p.length;) {
            if (p[index] == p[i]) {
                lps[i] = index;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public boolean subString(char[] st, char[] p) {
        int[] lps = computeTempArray(p);
        int i = 0;
        int j = 0;
        while (i < st.length && j < p.length) {

            if (p[j] == st[i]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == p.length) {
            return true;
        }
        return false;
    }
}
