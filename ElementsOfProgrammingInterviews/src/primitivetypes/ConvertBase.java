package primitivetypes;

public class ConvertBase {
    // convert from b1 to b2, assume s1 will fit in to 32 bit

    public char getHex(int base) {
        switch(base) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            default:
                return 'F';
        }
    }
    public String convert(String s1, int b1, int b2) {
        int x = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            x += (s1.charAt(i) - '0') * (b1 << i);
            if (i == 0  && s1.charAt(i) == '0') {
                x = 10;
            } else {
                x *= 10;
            }
        }
        String result = "";
        while (x / b2 > 0) {
            int remainder = x % b2;
            if (b2 > 10 && remainder > 10) {
                result += getHex(remainder);
            } else {
                result += String.valueOf(remainder);
            }
            x = x/b2;
        }
        if (b2 > 10 && x > 10) {
            result += getHex(x);
        } else {
            result += String.valueOf(x);
        }


        return new StringBuilder(result).reverse().toString();
    }
}
