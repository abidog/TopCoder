package primitivetypes;

public class Palindrome {
    public boolean isPalin(int num) {
        String rev = new StringBuilder(String.valueOf(num)).toString();
        long reverse = Long.parseLong(rev);
        while (num > 0) {
            int last = num % 10;
            int reverseLast = (int) (reverse % 10);
            if (last != reverseLast) {
                return false;
            }
            num /= 10;
            reverse /= 10;
        }
        return true;
    }


}
