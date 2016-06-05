public class LargestSubsequence {

    public static void main(String[] args) {
        String s = "akvccoziowkmrzpdwsvybiszfccgowzlosn";
        LargestSubsequence ls = new LargestSubsequence();
        System.out.println(ls.getLargest(s));
    }

    public String getLargest(String s) {
        int index = 0;
        String res = "";
        while (index < s.length()) {

            int maxIndex = -1;
            int max = 0;
            // abzsdz
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) > max) {
                    max = s.charAt(i);
                    maxIndex = i;
                }
            }

            res += ""+((char)max);
            index = maxIndex+1;
        }
        return  res;
    }

}
