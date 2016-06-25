package Strings;

import java.util.ArrayList;
import java.util.List;
//
public class AllValidIP {
    public List<String> compute(String add) {
        if (add == null || add.length() == 0) {
            return null;
        }

        List<String> result = new ArrayList<>();

        compute(add, result, 0, "", 0);
        return result;

    }

    public void compute(String add, List<String> result, int start, String current, int part) {
        if (part == 3) {

            int num = Integer.parseInt(add.substring(start));
            if (start < add.length() && num < 1000) {
                current += add.substring(start);
                result.add(current);
            }
            return;
        }
        for (int i = start + 1; i < Math.min(add.length(), start + 4); i++) {
            compute(add, result, i, current+add.substring(start, i) + ".", part+1);
        }
    }

}
