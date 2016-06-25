package Strings;

public class Sinus{

    public String getSinus(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        String[] line1 = {"","",""};
        int alternate = 1;
        int increment = -1;
        for (int i = 0; i < word.length(); i++) {
            line1[alternate] += word.charAt(i);
            if (alternate == 0) {
                increment = -1 * increment;
            }
            if (alternate == 2) {
                increment  = -1 * increment;
            }
            alternate += increment;
        }
        return line1[0] + line1[1] + line1[2];
    }
}
