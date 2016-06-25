package Strings;

public class InterconvertString {
    public String intToString(int num) {
        StringBuilder result = new StringBuilder("");
        boolean isNeg = false;
        if (num < 0) {
            isNeg = true;
            num *= -1;
        }
        while (num > 0) {
            char digit =  (char)((num % 10) + 48);
            result.insert(0, digit);
            num /= 10;
        }

        if (isNeg) {
            result.insert(0, '-');
        }
        return result.toString();
    }

    public int stringToInt(String num) {
        boolean isNeg = false;
        if (num.charAt(0) == '-') {
            isNeg = true;
            num = num.substring(1);
        }
        int result =  0;
        for (int i = 0; i < num.length(); i++) {
            result = result * 10 + (num.charAt(i) - '0');
        }
        return isNeg ? -1* result : result;
    }


}
