package Strings;

public class Palindrome{

    public boolean isPalin(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return true;
        }
        sentence = sentence.toLowerCase();
        sentence = sentence.replaceAll("[^a-z]", "");
        return sentence.equals(new StringBuilder(sentence).reverse().toString());
    }

}

