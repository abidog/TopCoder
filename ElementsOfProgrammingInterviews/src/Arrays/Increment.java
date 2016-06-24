package Arrays;

public class Increment{
    public String add(String num, int i, int index) {
        if (i == 0) {
            return num;
        }
        if (index < 0) {
            return String.valueOf(i) + num;
        }
        int sum = i + (num.charAt(index) - '0');
        num = num.substring(0, index) + String.valueOf(sum % 10) + num.substring(index + 1);
        return add(num, sum > 9 ? 1 : 0, index - 1);
    }
    public String increment(String num) {
        return add(num, 1, num.length() - 1);
    }
}

