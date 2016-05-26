import java.util.*;

public class Algrid {
    // mask 1 << 16 and board


    public static void main(String[] args) {
        String[] output = {"WWWWWWW",
                "WWWWWWB",
                "BBBBBWW"};
        Algrid algrid = new Algrid();
        String[] res  = algrid.makeProgram(output);
        for (String s  : res ) {
            System.out.println(s);
        }

    }

    public String[] makeProgram(String[] output) {
       char[][] table = new char[output.length][output[0].length()];
        for (int i = 0; i < output.length; i++) {
            table[i] = output[i].toCharArray();
        }
        int h = output.length - 2;
        int w = output[0].length() - 2;
        for (int i = h; i > 0; i--) {
            for (int j = w; j > 0 ; j--) {
                char a = table[i][j];
                char b = table[i][j+1];
                char c = table[i+1][j];
                char d = table[i+1][j+1];

                if (a == 'B' && b == 'B') {
                    table[i+1][j+1] = c;
                    table[i+1][j] = d;

                } else if (a == 'W' && b == 'B') {
                    if (c == 'W' && d == 'W') {
                        table[i+1][j+1] = '?';
                        table[i+1][j] = '?';
                    } else {
                        return null;
                    }
                } else if (a == 'B' && b == 'W') {
                    if (c == 'B' && d == 'B') {
                        table[i+1][j+1] = '?';
                        table[i+1][j] = '?';
                    } else {
                        return null;
                    }
                }
            }
        }
        for (int i = 0; i < output.length; i++) {
            String temp =  new String(table[i]).replaceAll("[?]","B");
            output[i] = temp;
        }

        return output;
    }
}
