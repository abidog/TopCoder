import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class KingSort {

    public static void main(String[] args) {
        KingSort ks = new KingSort();
        String[] kings = new String[] {"Louis IX", "Louis VIII"};
        System.out.println(ks.getSortedList(kings));
    }

    class King{
        String name;
        int num ;
        String roman;
        public King(String line) {
            String[] spl = line.split(" ");
            name = spl[0];
            roman = spl[1];
            num = romanToInt(roman);
        }

    }
	public String[] getSortedList(String[] kings) {
        King[] king = new King[kings.length];
        for (int i = 0; i < kings.length; i++) {
            king[i] = new King(kings[i]);
        }
        Comparator<King> kingComp = new Comparator<King>(){
            public int compare(King k1, King k2) {
                if (k1.name.compareTo(k2.name) == 0) {
                    return k1.num - k2.num;
                } else {
                    return k1.name.compareTo(k2.name);
                }
            }
        };

        Arrays.sort(king, kingComp);
        for (int i = 0; i < king.length; i++) {
          kings[i] = king[i].name +" "+king[i].roman;
        }

        return kings;
	}
    public int romanToInt(String str){
        char[] sChar = str.toCharArray();
        int n = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            int cur = roman(sChar[i]);
            int nxt = roman(sChar[i + 1]);

            if (cur<nxt) {
                n-= cur;
            } else {
                n+= cur;
            }
        }
        n += roman(sChar[sChar.length - 1]);
        return n;
    }

    public int roman(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
