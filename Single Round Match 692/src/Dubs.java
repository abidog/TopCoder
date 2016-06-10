import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class Dubs {

    private int num(long num) {
        if (num < 11) {
           return 0;
        } else if (num >= 11 & num <= 21 ) {
            return 1;
        } else if (num >= 22 && num < 33) {
            return 2;
        } else if (num >= 33 && num < 44){
            return 3;
        } else if (num >= 44 && num < 55) {
            return 4;
        } else if (num >= 55 && num < 66) {
            return 5;
        } else if (num >= 66 && num < 77){
            return 6;
        } else if (num >= 77 && num < 88){
            return 7;
        } else if (num >= 88 && num < 99) {
            return 8;

        }else if (num <= 99) {
            return 9;
        } else if (num == 100) {
            return 10;
        }
        return 0;
    }


    public long count(long L, long R) {

        //00, 11, 22, 33,44,55...66,77,88 99 ->10
        // 10 -> 99 ----> 10

        long l = count(L);
        long r = count(R);
        if (L % 10 == (L / 10) % 10) {
            return r - l + 1;
        } else {
            return r - l;
        }

	}

    public long count (long l) {
        long remain = l % 100;
        return num(remain) + (l - remain) / 10;
    }
}
