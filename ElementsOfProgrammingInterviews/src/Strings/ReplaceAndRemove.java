package Strings;

public class ReplaceAndRemove{
    public char[] replaceAndRemove(char[] str) {
        // remove 'b', replace a by 'dd'
        int end = str.length -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'b') {
                int start = i;
                while (start < end ) {
                    str[start] = str[start+1];
                    start++;
                }
                i--;
                end--;
            }
            if (i >= 0 && str[i] == 'a') {
                int e = end;
                while (e > i + 1) {
                    str[e + 1] = str[e];
                    e--;
                }
                str[i] = 'd';
                str[i + 1] = 'd';
                i++;
                end++;
            }
        }
        return str;
    }
}

