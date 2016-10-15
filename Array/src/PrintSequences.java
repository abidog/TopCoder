public class PrintSequences {

    public static void main(String[] args) {
        System.out.println(count(4));
    }

    public static String count(int n) {

        String start = "1";
        while (n-- > 1) {
            String next= "";
            for (int i =0; i < start.length(); i++) {
                int j = i;
                while ( i + 1 < start.length() && start.charAt(i) == start.charAt(i + 1)) {
                    i++;
                }
                next += ""+(i - j + 1) + start.charAt(j)+"";
            }
            start = next;
        }
        return start;
    }

}
