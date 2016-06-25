package Strings;

public class LookAndSaySeq{
    public String lookAndSay(int n) {
        String start = "1";
        while (n-- > 1) {
            String next = "";
            for (int i = 0; i < start.length(); i++) {
                int count = 1;
                int begin = i;
                while (begin + 1 < start.length() && start.charAt(begin) == start.charAt(begin + 1)) {
                    count++;
                    begin++;
                }
                i = begin;
                next += String.valueOf(count)+start.charAt(i);
            }
            start = next;
        }
        return start;
    }
}
