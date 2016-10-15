package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, result, 0, "", current);
        return result;
    }

    public void backtrack(String s, List<List<String>> result, int cur, String pal, List<String> curList) {
        if (cur == s.length() && isPalindrome(pal)) {
            List<String> res = new ArrayList<>(curList);
            res.add(pal);
            result.add(res);
            return;
        }

        for (int i = cur; i < s.length(); i++) {
            String next = pal + s.substring(cur, i + 1);
            if (isPalindrome(next)) {
                curList.add(next);
                backtrack(s, result, i + 1, "", curList);
                curList.remove(curList.size() - 1);
            }

        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
