// Start 10:17am
// end  10:54am

import java.util.Arrays;

public class TheNumbersWithLuckyLastDigit {

    public static void main(String[] args) {
        TheNumbersWithLuckyLastDigit num = new TheNumbersWithLuckyLastDigit();
        int[] memo = new int[250000000];
        Arrays.fill(memo, -1);
        for (int i = 0; i < 250000000; i++) {
            System.out.println(memo[i]);
        }
    }
    public int find(int n) {
        int last = n % 10;
        if (last == 1 && n >= 11) {
            return 2;
        } else if (last == 2 && n >= 12) {
            return 3;
        } else if (last == 3 && n >= 33) {
            return 6;
        } else if (last == 4 && n >= 4) {
            return 1;
        } else if (last == 5 && n >= 15) {
            return 3;
        } else if (last == 6 && n >= 16) {
            return 4;
        } else if (last == 7 && n >= 7) {
            return 1;
        } else if (last == 8 && n >= 8) {
            return 2;
        } else if (last == 9 && n >= 19) {
            return 4;
        } else if (last == 0 && n >= 20) {
            return 5;
        }


        return -1;
    }

}
