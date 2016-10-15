
import java.util.*;
public class Combinatoric {

    public static void main(String[] args) {
        Combinatoric c = new Combinatoric();
        List<String> result = new ArrayList<>();
        char[] temp = "abc".toCharArray();
        c.permute(temp, result);
        c.combinatoric(5);
        c.getCombina(5);
        System.out.println(result);
    }

    public long[][] combinatoric(int n) {
        long[][] nCk = new long[n][n];
        nCk[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    nCk[i][j] = 1;
                } else {
                    nCk[i][j] += nCk[i - 1][j - 1] + nCk[i - 1][j];
                }
            }
        }
        return nCk;
    }


    public long[][] getCombina(int n) {

        long [][] nCk= new long[ n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 ) {
                    nCk[i][j] = 1;
                    continue;
                } else {
                    nCk[i][j] = nCk[i - 1][j] + nCk[i - 1][j - 1];
                }
            }
        }
        return  nCk;
    }


    public void permute(char[] string, List<String> result) {
        backtrack(string, 0, result);
    }

    private void backtrack(char[] string, int start, List<String> result) {


        if (start == string.length) {
            result.add(new String(string));
            return;
        }

        for (int i = start; i <string.length ; i++) {
            swap(string, start, i);
            backtrack(string, start + 1, result);
            swap(string, start, i);
        }

    }
    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
