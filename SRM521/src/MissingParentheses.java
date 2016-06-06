import java.util.*;

public class MissingParentheses {
    public static void main(String[] args) {
        String s = "()()(()";
        MissingParentheses mp = new MissingParentheses();
        System.out.println(mp.countCorrections(s));
    }
    public int countCorrections(String par) {
        int cur = 0;
        int needed = 0;
        for (int i = 0; i < par.length(); i++) {
              if (par.charAt(i) == '(') {
                  cur++;
              } else {
                  if (cur > 0) {
                      cur--;
                  } else {
                      needed++;
                  }
              }

        }
        return needed + cur;

    }
}
