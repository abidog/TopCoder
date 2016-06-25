package Strings;

import java.util.ArrayList;
import java.util.List;

public class GammaEncoding{

    public String encode(int[] a) {
        String result = "";
        for (int i : a) {
            String bin = Integer.toBinaryString(i);
            result += padZeros(bin, bin.length() - 1);
        }
        return result;
    }
    public String padZeros(String num, int count) {
        while (count-- > 0) {
            num = "0"+num;
        }
        return num;
    }

    public int[] decode(String s) {
        List<Integer> result = new ArrayList<>();
        for ( int i = 0; i < s.length(); i++) {
            int start = i;
            int count = 0;
            while (start < s.length() && s.charAt(start) == '0') {
                count++;
                start++;
            }
            int end = start;
            count++;
            String num = s.substring(end, end + count);
            int nm = 0;
            int p = 0;
            for (int j = num.length() - 1; j >= 0; j--) {
                nm += Math.pow(2, p++) * (num.charAt(j) - '0');
            }
            result.add(nm);
            i = end + count - 1;
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}

