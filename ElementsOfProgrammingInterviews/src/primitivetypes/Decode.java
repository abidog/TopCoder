package primitivetypes;

public class Decode {
    public int ssDecodeColID(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int base = 'A' - 1;
        int sum = s.charAt(s.length() - 1) - base;
        int k = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            sum += (s.charAt(i) - base) * k * 26;
            k++;
        }
        return sum;
    }

}