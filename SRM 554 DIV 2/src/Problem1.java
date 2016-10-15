import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1
{
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String mes = bf.readLine();

        int n = Integer.parseInt(bf.readLine());

        String res = "";
        int start = 0;
        while (start < mes.length()) {

            String temp = mes.substring(start, Math.min(start + n, mes.length()));
            res += new StringBuilder(temp).reverse().toString();
            if (start + n < mes.length()) {
                String temp2 = mes.substring(start + n, Math.min(start + 2 * n, mes.length()));
                res += temp2;
            }

            start = start + n + n;

        }
        System.out.println(res);



    }

}