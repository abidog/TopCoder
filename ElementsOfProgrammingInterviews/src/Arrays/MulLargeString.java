package Arrays;

public class MulLargeString{
    public String mul(String num1, String num2) {
        String nm1 = new StringBuilder(num1).reverse().toString();
        String nm2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[nm1.length() + nm2.length()];

        for (int i = 0; i < nm1.length(); i++) {
            for (int j = 0; j < nm2.length(); j++) {
                d[i + j] += (nm1.charAt(i) - '0') * ( nm2.charAt(j) - '0');
            }
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            carry = d[i] / 10;
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            result.insert(0, mod);
        }
        result.insert(0, carry);
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            result.deleteCharAt(i);
        }


        return result.toString();
    }


}

