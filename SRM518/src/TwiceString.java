public class TwiceString {

    public static void main(String[] args) {
        TwiceString ts = new TwiceString();
        System.out.println(ts.getShortest("abracadabra"));
    }
    public String getShortest(String s) {

        String begin = null;
        int len = s.length();

        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(0, i);
            if (s.endsWith(temp)) {
                begin = temp;
            }
        }
        if (begin != null) {
            return s + s.substring(begin.length());
        }
        return "";
    }

}
