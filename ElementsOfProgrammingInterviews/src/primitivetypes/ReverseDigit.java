package primitivetypes;



public class ReverseDigit{
    public int reverse(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            result *= 10;
            num /= 10;
        }
        return result / 10;
    }
    public int reverseDigit(int num) {
        if (num < 0) {
            return -1 * reverse(-1*num);
        } else {
            return reverse(num);
        }
    }

}

