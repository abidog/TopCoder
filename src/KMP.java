public class KMP {
    public static void main(String args[]){

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMP ss = new KMP();
        boolean result = ss.hasSubString(str.toCharArray(), subString.toCharArray());
        System.out.print(result);

    }


    public boolean hasSubString(char[] search, char[] pattern) {

      if (search == null || pattern == null) {
          return false;
      }


        int[] lps = calculatePreArray(pattern);


        int i = 0;
        int j = 0;
        while (i < search.length && j < pattern.length) {

            if (search[i] == pattern[j]) {
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
        if (j == pattern.length) {
            return true;
        } else {
            return false;
        }
    }

    public int[] calculatePreArray(char[] pattern) {

        int[] lps = new int[pattern.length];
        if (pattern == null || pattern.length == 0) {
            return lps;
        }
        int index = 0;
        for (int i = 1; i < pattern.length; ) {


            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                i++;
                index++;
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

}
