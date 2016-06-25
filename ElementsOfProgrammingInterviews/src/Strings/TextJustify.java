package Strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        for (int i = 0; i < words.length; i++) {

            int start = i;
            int count = 0;
            while (start < words.length && count + words[start].length() <= maxWidth) {
                count += words[start].length() + 1;
                start++;
            }
            int numWords = start - i;
            int numSpace = numWords - 1;
            count = 0;
            for (int j = i; j < start; j++) {
                count += words[j].length();
            }
            int leftSpace = maxWidth - count;
            String line = "";
            if (numSpace == 0) {
                line += words[i] + getSpace(leftSpace);
                result.add(line);
                i = start - 1;
                continue;
            }
            if (start == words.length) {
                for (int w = i; w < start; w++) {
                    if (w != start - 1) {
                        line += words[w] +" ";
                    } else {
                        line += words[w];
                    }
                }
                line += getSpace(maxWidth - line.length());
                result.add(line);
                i = start - 1;
                continue;
            }
            int[] spaces = new int[numSpace];
            int index = 0;
            while (leftSpace-- > 0) {
                ++spaces[index++];
                if (index == spaces.length) {
                    index = 0;
                }
            }

            index = 0;
            for (int w = i; w < start; w++) {
                if (w != start - 1) {
                    line += words[w] + getSpace(spaces[index++]);
                }else {
                    line += words[w];
                }
            }
            result.add(line);
            i = start - 1;

        }
        return result;

    }
    private String getSpace(int count) {
        String result = "";
        while (count-- > 0) {
            result += " ";
        }
        return result;
    }
}
