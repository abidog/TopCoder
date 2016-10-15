import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int m = Integer.parseInt(bf.readLine());
        String temp = "";
        long res = 0;
        for (int i = 0; i < m; i++) {
            temp = (temp + s).charAt((temp + s).length() - i - 1) + temp;
            if ((temp + s).equals(s + temp) ) {
                res = m / temp.length();
                res %= 1e9 + 7;
                System.out.println(res);
                break;
            }


        }
        //System.out.println(res);

    }
}

// a   a aa aaa aaaa aaaaa aaaaa