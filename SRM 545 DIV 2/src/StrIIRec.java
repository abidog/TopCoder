

import java.util.*;



public class StrIIRec {

    public static void main(String[] args) {

        int n = 16;
        int minInv = 64;
        String minStr = "k";
        System.out.println(new StrIIRec().recovstr(n, minInv, minStr));

    }

    public String recovstr(int n, int minInv, String minStr) {

        char[] inp = new char[n];
        Set<Character> set = new HashSet<>();
        int k = 0;
        for (char c : minStr.toCharArray()) {
            set.add(c);
            inp[k++] = c;
        }
        char a = 'a';
        for (int i = 0; i < n; i++) {
            if (!set.contains(a)) {
                inp[k++] = a;
            }
            a++;
        }
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(inp.toString(), true);
        for (int i = inp.length - 2; i >= 0; i--) {
            for (int j = inp.length - 1; j > i ; j--) {
                if (countInv(inp) >= minInv) {
                    return new String(inp);
                }
                if (inp[i] < inp[j]) {
                    swap(inp, i, j);
                }

            }
            if (countInv(inp) >= minInv) {
                return new String(inp);
            }
        }
        if (countInv(inp) >= minInv) {
            return new String(inp);
        }


        return "";
	}


    private int countInv(char[] num) {
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length ; j++) {
                if (num[i] > num[j]) {
                    res++;
                }
            }
        }
        return  res;

    }

    private void swap(char[] num, int l, int r) {
        char temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
