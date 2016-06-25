package Strings;


public class ReverseWords {
    public char[] reverseWords(char[] sentence) {
        if (sentence == null || sentence.length == 0) {
            return null;
        }
        int l = 0;
        int r = sentence.length - 1;
        while (l < r) {
            swap(sentence, l, r);
            l++;
            r--;
        }
        for (int i = 0; i < sentence.length; i++) {
            int start = i;
            while (start < sentence.length && sentence[start] == ' ') {
                start++;
            }
            int end = start;
            while (end < sentence.length && sentence[end] != ' ') {
                end++;
            }
            reverse(sentence, start, end - 1);
            i = end - 1;
        }
        return sentence;
    }

    public void reverse(char [] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }
    public void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
